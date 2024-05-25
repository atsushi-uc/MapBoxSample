package com.example.mapboxsample.presentation.screen.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mapboxsample.presentation.component.ErrorDialog
import com.example.mapboxsample.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val topAppBarColors = Color.Black
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(topAppBarState)
    val sidebarWidth = 50.dp

    val uiState by  viewModel.uiState.collectAsState()
    val uiEvent by viewModel.uiEvents.collectAsState()

    uiEvent.forEach { event ->
        when(event) {
            is UiEvent.NavigateToSomewhere -> {
                // navController.navigate(NavigationRoute.SomeOtherScreen.withArgs(event.arg))
                // viewModel.consume(event)
            }
        }
    }

    BackHandler(enabled = uiState.isBackHandlingEnabled) { }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(stringResource(id = R.string.header_title)) },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = topAppBarColors)
            )
        }
    ){ paddingValues ->
        HomeContent(
            paddingValues = paddingValues,
            isLoading = uiState.isLoading,
            error = uiState.error,
            dismissErrorDialog = { viewModel.dismissErrorDialog() },
        )
    }
}

@Composable
fun HomeContent(
    paddingValues: PaddingValues = PaddingValues(),
    isLoading: Boolean = false,
    error: String? = null,
    dismissErrorDialog: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 10.dp, end = 10.dp),
        ) {

        }
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        if (!error.isNullOrBlank()) {
            ErrorDialog(message = error) {
                dismissErrorDialog()
            }
        }
    }

}

@Preview
@Composable
fun PreView() {
    HomeContent()
}

