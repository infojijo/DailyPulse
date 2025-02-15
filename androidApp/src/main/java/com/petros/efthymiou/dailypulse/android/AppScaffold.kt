package com.petros.efthymiou.dailypulse.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.petros.efthymiou.dailypulse.android.screens.AboutScreen
import com.petros.efthymiou.dailypulse.android.screens.ArticlesScreen
import com.petros.efthymiou.dailypulse.android.screens.HeadLinesScreen
import com.petros.efthymiou.dailypulse.android.screens.Screen
import com.petros.efthymiou.dailypulse.articles.ArticlesViewModel

@Composable
fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.ARTICLE.route,
        modifier = modifier,
    ) {
        composable(Screen.ARTICLE.route) {
            ArticlesScreen(
                onAboutButtonClick = { navController.navigate(Screen.ABOUT.route) },
                onHeadLinesButtonClick = { navController.navigate(Screen.HEADLINES.route) }
            )
        }
        composable(Screen.HEADLINES.route) {
            HeadLinesScreen(
                onAboutButtonClick = { navController.navigate(Screen.ABOUT.route) },
                onArticlesButtonClick = { navController.navigate(Screen.ARTICLE.route) }
            )
        }
        composable(Screen.ABOUT.route) {
            AboutScreen(
                onBackButtonClick = { navController.popBackStack() }
            )
        }
    }
}