package com.pdm0126.app.data.api.posts

import kotlinx.serialization.Serializable

@Serializable
data class CreatePostRequestDTO(
    val userId: Int,
    val title: String,
    val body: String
)
{

}