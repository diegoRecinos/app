package com.pdm0126.app.data.repository.PostRepository

import com.pdm0126.app.data.model.Post

interface PostRepository {

    suspend fun getPosts(): List<Post>

    suspend fun createPost(post: Post): Post

}