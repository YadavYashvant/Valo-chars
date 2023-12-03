package com.example.quickity

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quickity.ui.screens.HolderScreen
import com.example.quickity.ui.theme.QuickityTheme

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuickityTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HolderScreen()
                    /*Text(text = "Welcome to quickity",
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.headlineMedium
                    )

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            HomeScreen(navController = navController)
                        }
                        composable("bills") {
                            Text(text = "Bills")
                        }
                        composable("settings") {
                            Text(text = "Settings")
                        }
                    }*/
                    /*val mContext = LocalContext.current
                    val navController = rememberNavController()
                    val viewModel: HomeViewModel = hiltViewModel()

                    LazyColumn(
                        modifier = Modifier.padding(16.dp).fillMaxWidth()
                    ) {
                        items(viewModel.employeeList.value?.size!!) { index ->
                            Text(text = viewModel!!.employeeList.value?.get(index)?.employeeName.toString())
                        }
                    }

                    Button(
                        onClick = {
                                  val employee = Employee(
                                      id = 100,
                                      employeeId = 25,
                                      employeeName = "Yashvant Yadav",
                                      employeeDesignation = "CEO"
                                  )
                            addEmployeeInDB(mContext,navController, employee, viewModel)
                                  },
                        modifier = Modifier.padding(32.dp)
                    ) {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = null)
                    }*/
                }
            }
        }
    }
}
