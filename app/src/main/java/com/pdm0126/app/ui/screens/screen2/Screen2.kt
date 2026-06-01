package com.pdm0126.app.ui.screens.screen2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pdm0126.app.ui.components.MainTopBar
import androidx.compose.runtime.getValue
@Composable
fun Screen2(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: Screen2ViewModel = viewModel()

){
    val uiState =  viewModel.uiState.collectAsState()

    Scaffold (
        topBar = {
            MainTopBar(title = "Screen 2")
        },
        floatingActionButton = { Button(onClick = { viewModel.createPost() }) { Text("Create Post") } }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding( innerPadding)

        ) {
            Text(text = "Screen 2")
            Button( onClick = { viewModel.fetchPosts() }
            ) { Text("get post") }
            Spacer(modifier = Modifier.height(16.dp))


            if (uiState.value.isLoading) {
                CircularProgressIndicator()
            }

            LazyColumn( ) {
                items(uiState.value.posts
                ) { post ->
                    Text(
                        text = post.title
                    )
                    HorizontalDivider()
                }
            }


        }
    }
}