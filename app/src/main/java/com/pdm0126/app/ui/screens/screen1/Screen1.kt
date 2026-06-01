package com.pdm0126.app.ui.screens.screen1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pdm0126.app.ui.components.MainTopBar


@Composable
fun Screen1(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: Screen1ViewModel = viewModel()
) {

    val uiState = viewModel.uiState.collectAsState()

    Scaffold (
        topBar = {
            MainTopBar(title = "Screen 1")
        },

    ) { innerPadding ->
        Column(
            //modifier = Modifier.fillMaxSize(),
            //horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.Center
            modifier = Modifier.padding(innerPadding),
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top
            ) {
                Button(onClick = { viewModel.fetchPosts() }) { Text("Fetch Posts")}
                //Button(onClick = { viewModel.createPost() }) { Text("Create Post")}
            }

            if (uiState.value.isLoading) {
                CircularProgressIndicator()
            }

            Text(text = "Screen 1")
            Spacer(modifier = Modifier.height(16.dp))


            LazyColumn (){
                items(uiState.value.posts.size) { index ->
                    Text(text = uiState.value.posts[index].title)
                    HorizontalDivider()
                }
            }


            Button(
                onClick = onBack,
                modifier = modifier
            ) {Text("Back") }
        }
    }
}