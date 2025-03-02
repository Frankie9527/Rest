package com.sixth.space.uitls

import com.sixth.space.base.Constant
import com.sixth.space.data.video.CommentItem
import com.sixth.space.data.video.HotItem
import com.sixth.space.data.video.RecommendItem
import com.sixth.space.data.dao.VideoInfo
import com.sixth.space.data.video.TikTokItem

/**
 * author: Frankie
 * Date: 2024/3/8
 * Description:
 */
fun hotItem2VideoInfo(hot: HotItem): VideoInfo {
    return VideoInfo(
        videoId = hot.data.id,
        videoType = Constant.recycler_adapter_type_hot,
        title = hot.data.title,
        description = hot.data.description,
        playUrl = hot.data.playUrl,
        blurred = hot.data.cover.blurred,
        category = hot.data.category,
        cover = hot.data.cover.feed,
        user_name = hot.data.author?.name.toString(),
        user_description = hot.data.author?.description.toString(),
        avatar = hot.data.author.icon,
        releaseTime = 0,
        duration = 0,
        consumption = VideoInfo.Consumption(
            hot.data.consumption.collectionCount,
            hot.data.consumption.replyCount,
            hot.data.consumption.shareCount
        ),
        likeCount = 0,
        commentMsg = ""
    )
}


fun List<HotItem>.hotList2Video(): List<VideoInfo> {
    return this.map { hotItem2VideoInfo(it) }
}

fun recommendItem2VideoInfo(recommend: RecommendItem): VideoInfo {
    return VideoInfo(
        videoId = recommend.data.id,
        videoType = Constant.recycler_adapter_type_recommend,
        title = recommend.data.title,
        description = recommend.data.description,
        playUrl = recommend.data.playUrl,
        blurred = recommend.data.cover.blurred,
        category = recommend.data.category,
        cover = recommend.data.cover.feed,
        user_name = recommend.data.author?.name.toString(),
        user_description = recommend.data.author?.description.toString(),
        avatar = recommend.data.author?.icon.toString(),
        releaseTime = recommend.data.releaseTime,
        duration = recommend.data.duration,
        consumption = VideoInfo.Consumption(
            recommend.data.consumption.collectionCount,
            recommend.data.consumption.replyCount,
            recommend.data.consumption.shareCount
        ),
        likeCount = 0,
        commentMsg = ""
    )
}

fun List<RecommendItem>.recommendList2Video(): List<VideoInfo> {
    return this.map { recommendItem2VideoInfo(it) }
}

fun commentItem2VideoInfo(comment: CommentItem): VideoInfo {
    return VideoInfo(
        videoId = comment.data.videoId,
        videoType = Constant.recycler_adapter_type_comment,
        title = "",
        description = "",
        playUrl = "",
        blurred = "",
        category = "",
        cover = "",
        user_name = comment.data.user?.nickname.toString(),
        user_description = comment.data.user?.description.toString(),
        avatar = comment.data.user.avatar,
        releaseTime = comment.data.createTime,
        duration = 0,
        consumption = VideoInfo.Consumption(0, 0, 0),
        likeCount = comment.data.likeCount,
        commentMsg = comment.data.message
    )
}

fun List<CommentItem>.replyList2Video(): List<VideoInfo> {
    return this.map { commentItem2VideoInfo(it) }
}

fun List<TikTokItem>.homeList2Video(): List<VideoInfo> {
    return this.map { homeItem2VideoInfo(it) }
}

fun homeItem2VideoInfo(info: TikTokItem): VideoInfo {
    return VideoInfo(
        videoId = info.data.content.data.id,
        videoType = Constant.recycler_adapter_type_tiktok,
        title = info.data.content.data.title,
        description = info.data.content.data.description,
        playUrl = info.data.content.data.playUrl,
        blurred = info.data.content.data?.cover!!.blurred,
        category = info.data.content.data.category,
        cover = info.data.content.data.cover.feed,
        user_name = info.data.content.data.author.name,
        user_description = info.data.content.data?.author!!.description,
        avatar = info.data.content.data.author.icon,
        releaseTime = info.data.content.data.releaseTime,
        duration = info.data.content.data.duration,
        consumption = VideoInfo.Consumption(
            info.data.content.data.consumption.collectionCount,
            info.data.content.data.consumption.replyCount,
            info.data.content.data.consumption.shareCount
        ),
        likeCount = 0,
        commentMsg = ""
    )
}

fun VideoInfo.video2Detail(info: VideoInfo): VideoInfo {
    this.videoId=info.videoId
    this.videoType=info.videoType
    this.title=info.title
    this.description=info.description
    this.playUrl=info.playUrl
    this.blurred=info.blurred
    this.category=info.category
    this.cover=info.cover
    this.user_name=info.user_name
    this.user_description=info.user_description
    this.avatar=info.avatar
    this.releaseTime=info.releaseTime

    this.duration=info.duration
    this.consumption=info.consumption
    this.likeCount=info.likeCount
    return this;
}