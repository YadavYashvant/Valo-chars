package com.example.quickity

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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.quickity.Viewmodels.HomeViewModel
import com.example.quickity.models.Employee
import com.example.quickity.ui.screens.addEmployeeInDB
import com.example.quickity.ui.theme.QuickityTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuickityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val mContext = LocalContext.current
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
                    }
                }
            }
        }
    }
}
