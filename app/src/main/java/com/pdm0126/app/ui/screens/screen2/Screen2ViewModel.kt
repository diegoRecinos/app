package com.pdm0126.app.ui.screens.screen2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.app.data.api.KtorClient
import com.pdm0126.app.data.model.Post
import com.pdm0126.app.data.repository.PostRepository.PostApiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class Screen2UiState(
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

class Screen2ViewModel : ViewModel() {

    private val repository = PostApiRepository(KtorClient.client)

    val _uiState = MutableStateFlow(Screen2UiState())

    val uiState: StateFlow<Screen2UiState> = _uiState.asStateFlow()

    init {
        fetchPosts()
    }

    fun fetchPosts(){

        viewModelScope.launch {

            _uiState.update { it.copy(isLoading = true) }

            try {
                val posts = repository.getPosts()
                _uiState.update { it.copy(posts = posts) }

                _uiState.update { it.copy(isLoading = false) }
            }catch (e: Exception){
                _uiState.update { it.copy(error = e.message) }
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }

    fun createPost(){

        viewModelScope.launch {

            try {
                val newPost = Post(userId = 1, id = 1, title = "New Post", body = "This is a new post")
                val result = repository.createPost(newPost)

                // Actualizar la lista de posts con el nuevo post
                _uiState.update { it.copy(posts = listOf(result) + it.posts) }

            }catch (e: Exception){
                _uiState.update { it.copy(error = e.message) }
            }

        }

    }


}