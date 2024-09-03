package com.petros.efthymiou.dailypulse.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.petros.efthymiou.dailypulse.topheadlines.HeadLineRaw
import com.petros.efthymiou.dailypulse.topheadlines.HeadLinesViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HeadLinesScreen(
    onAboutButtonClick: () -> Unit,
    onArticlesButtonClick: () -> Unit,
    headLinesViewModel: HeadLinesViewModel = getViewModel()
) {
    val headlinesState = headLinesViewModel.headLinesList.collectAsState()

    Column {
        AppBar(onAboutButtonClick, onArticlesButtonClick)
        if (headlinesState.value.loading)
            Loader()
        if (headlinesState.value.error != null)
            ErrorMessage(headlinesState.value.error!!)
        if (headlinesState.value.articles.isNotEmpty())
            ArticlesListView(headLinesViewModel.headLinesList.value.articles)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(
    onAboutButtonClick: () -> Unit,
    onArticlesButtonClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "Articles") },
        actions = {
            IconButton(onClick = onAboutButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "About Device Button",
                )
            }
            IconButton(onClick = onArticlesButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Articles",
                )
            }
        }
    )
}

@Composable
fun ArticlesListView(articles: List<HeadLineRaw>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(articles) { article ->
            ArticleItemView(article = article)
        }
    }
}

@Composable
fun ArticleItemView(article: HeadLineRaw) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = article.desc ?: "",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = article.title ?: "")
        Spacer(modifier = Modifier.height(4.dp))
    }
}