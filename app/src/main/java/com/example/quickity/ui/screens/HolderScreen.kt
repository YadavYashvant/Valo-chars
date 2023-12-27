package com.example.quickity.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.quickity.api_feature.ui.navigation.Navigation
import com.example.quickity.ui.BottomNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HolderScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) {
        Navigation()
    }
}
