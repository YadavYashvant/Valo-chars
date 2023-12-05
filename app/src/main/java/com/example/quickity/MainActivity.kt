package com.example.quickity

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quickity.animations.EnterAnimation
import com.example.quickity.ui.BottomNavigation
import com.example.quickity.ui.screens.HomeScreen
import com.example.quickity.ui.theme.DEFAULT_PADDING
import com.example.quickity.ui.theme.QuickityTheme

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuickityTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val context = LocalContext.current
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        bottomBar = {
                            BottomNavigation(navController)
                        }
                    ) {

                        NavHost(navController = navController, startDestination = "Home") {
                            composable("Home") {
                                EnterAnimation {
                                    HomeScreen(
                                        navController = navController
                                    )
                                }
                            }
                            composable("Scan") {
                                EnterAnimation {
                                    Text(text = "Scan the QR code")
                                }
                            }
                            composable("Bills") {
                                EnterAnimation {
                                    Text(text = "Bills")
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}
