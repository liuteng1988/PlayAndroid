package com.zj.play.network

/**
 * 版权：渤海新能 版权所有
 * @author zhujiang
 * 版本：1.5
 * 创建日期：2020/5/19
 * 描述：PlayAndroid
 *
 */
object CollectRepository {

    /**
     * 获取收藏列表
     *
     * @param page 页码
     */
    fun getCollectList(page: Int) = fires { PlayAndroidNetwork.getCollectList(page) }

    /**
     * 收藏文章
     *
     * @param id 文章id
     */
    fun toCollect(id: Int) = fires { PlayAndroidNetwork.toCollect(id) }

    /**
     * 取消收藏
     *
     * @param id 文章id
     */
    fun cancelCollect(id: Int) = fires {
        PlayAndroidNetwork.cancelCollect(id)
    }

    suspend fun cancelCollects(id: Int) = PlayAndroidNetwork.cancelCollect(id)
    suspend fun toCollects(id: Int) = PlayAndroidNetwork.toCollect(id)

}