package com.pdm0126.app.data.api.posts

import com.pdm0126.app.data.model.Post
import kotlinx.serialization.Serializable

@Serializable
data class GetPostResponseDTO(
    val userId: Int,
    val resutls: List<PostDTO>
){

}