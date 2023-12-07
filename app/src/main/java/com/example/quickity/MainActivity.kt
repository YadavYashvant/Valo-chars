package com.example.quickity

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quickity.animations.EnterAnimation
import com.example.quickity.ui.BottomNavigation
import com.example.quickity.ui.screens.BillScreen
import com.example.quickity.ui.screens.HomeScreen
import com.example.quickity.ui.screens.ScannerScreen
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

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { TopAppBar(
                            title = { Text(text = "Quickity") },
                            navigationIcon = {
                                Text(
                                    text = "Quickity",
                                    modifier = Modifier.padding(start = DEFAULT_PADDING.dp),
                                    style = MaterialTheme.typography.headlineMedium
                                )
                            },
                        ) },
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
                                    ScannerScreen(navController = navController)
                                }
                            }
                            composable("Bills") {
                                EnterAnimation {
                                    BillScreen(navController = navController)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}