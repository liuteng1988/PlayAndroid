package com.zj.play.view.share.add

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.view.View
import com.blankj.utilcode.util.RegexUtils
import com.zj.core.util.showToast
import com.zj.core.view.BaseActivity
import com.zj.play.R
import com.zj.play.network.ShareRepository
import kotlinx.android.synthetic.main.activity_add_share.*

class AddShareActivity : BaseActivity(), View.OnClickListener {


    override fun getLayoutId(): Int {
        return R.layout.activity_add_share
    }

    override fun initData() {}

    override fun initView() {
        addShareBtnAdd.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.addShareBtnAdd -> {
                addShare()
            }
        }
    }

    private fun addShare() {
        val title = addShareEtTitle.text.toString().trim()
        if (TextUtils.isEmpty(title) || title == "") {
            addShareEtTitle.error = "标题不能为空"
            return
        }
        val link = addShareEtLink.text.toString().trim()
        if (TextUtils.isEmpty(link) || link == "") {
            addShareEtLink.error = "链接不能为空"
            return
        }
        if (!RegexUtils.isURL(link)) {
            addShareEtLink.error = "链接格式输入错误"
            return
        }
        ShareRepository.shareArticle(title, link).observe(this, {
            if (it.isSuccess) {
                showToast("分享成功")
                finish()
            }
        })
    }

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, AddShareActivity::class.java)
            context.startActivity(intent)
        }
    }

}