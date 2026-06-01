package com.pdm0126.app.data.api.posts

import com.pdm0126.app.data.model.Post
import kotlinx.serialization.Serializable

@Serializable
class PostDTO(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)


//mappers

fun PostDTO.toModel() = Post(
    userId = userId,
    id = id,
    title = title,
    body = body
)

fun Post.toDTO() = PostDTO(
    userId = userId,
    id = id,
    title = title,
    body = body
)