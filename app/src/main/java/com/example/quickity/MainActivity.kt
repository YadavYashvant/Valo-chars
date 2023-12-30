package com.example.quickity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.quickity.ui.screens.HolderScreen
import com.example.quickity.ui.theme.QuickityTheme
import com.example.quickity.ui.theme.blackV

const val URL_KEY: String = "UrlKey"
var urlText by mutableStateOf("")
//@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuickityTheme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,

                ) {

                    Box(
                        modifier = Modifier.fillMaxSize().background(color = blackV)
                    ) {
                        HolderScreen() //HolderScreen contains Compose navigation logic
                    }

                    /*val navController = rememberNavController()
                    var mOpenMenu by remember { mutableStateOf(false) }
                    val mContext = LocalContext.current

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { TopAppBar(
                            title = {Text(text = "Quickity", fontStyle = FontStyle.Italic, fontWeight = FontWeight.Bold, fontSize = 32.sp, modifier = Modifier
                                .padding(start = 130.dp),
                                color = Color(0xFF1E90FF)
                            ) },
                            *//*navigationIcon = {
                                Icon(painter = painterResource(id = R.drawable.quickity_navicon), contentDescription = null)
                            },*//*
                            actions = {
                                IconButton(onClick = { mOpenMenu = !mOpenMenu }) {
                                    Icon(Icons.Default.MoreVert, "",
                                        tint = Color(0xFF1E90FF),

                                    )
                                }
                                    // Creating a dropdown menu
                                    DropdownMenu(
                                        expanded = mOpenMenu,
                                        onDismissRequest = { mOpenMenu = false },
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(40.dp))
                                            .wrapContentWidth()
                                    ) {
                                        // Creating dropdown menu item, on click
                                        // would create a Toast message
                                        DropdownMenuItem(
                                            onClick = {
                                                Toast.makeText(
                                                    mContext,
                                                    "Profile",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            },
                                            modifier = Modifier.padding(horizontal = 8.dp),
                                            text = { Text(text = "Profile") },
                                            leadingIcon = {
                                                Icon(
                                                    imageVector = Icons.Default.Person,
                                                    contentDescription = null
                                                )
                                            }
                                        )

                                        // Creating dropdown menu item, on click
                                        // would create a Toast message
                                        DropdownMenuItem(
                                            onClick = {
                                                Toast.makeText(
                                                    mContext,
                                                    "Settings",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            },
                                            modifier = Modifier.padding(horizontal=8.dp),
                                            text = { Text(text = "Settings") },
                                            leadingIcon = {
                                                Icon(
                                                    imageVector = Icons.Default.Settings,
                                                    contentDescription = null
                                                )
                                            }
                                        )
                                        DropdownMenuItem(
                                            onClick = {
                                                Toast.makeText(
                                                    mContext,
                                                    "About",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            },
                                            modifier = Modifier.padding(horizontal=8.dp),
                                            text = { Text(text = "My Cart") },
                                            leadingIcon = {
                                                Icon(
                                                    imageVector = Icons.Default.ShoppingCart,
                                                    contentDescription = null
                                                )
                                            }
                                        )
                                        DropdownMenuItem(
                                            onClick = {
                                                Toast.makeText(
                                                    mContext,
                                                    "About",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            },
                                            modifier = Modifier.padding(horizontal=8.dp),
                                            text = { Text(text = "About Us") },
                                            leadingIcon = {
                                                Icon(
                                                    imageVector = Icons.Default.Info,
                                                    contentDescription = null
                                                )
                                            }
                                        )
                                    }
                            }
                        ) },
                        bottomBar = {
                            BottomNavigation(navController)
                        }
                    ) {
                        NavHost(navController = navController, startDestination = "Home") {
                            composable("Home") {
                                EnterAnimation {
                                    HomeScreen(
                                        navController = navController,

                                    )
                                }
                            }
                            composable("Scan") {
                                EnterAnimation {
                                    ScannerScreen(
                                        navController = navController,
                                        urlText = urlText,
                                        onUrlTextUpdate = {
                                            urlText = it
                                        },
                                    )
                                }
                            }
                            composable("Bills") {
                                EnterAnimation {
                                    BillScreen(navController = navController)
                                }
                            }
                        }
                    }*/
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(URL_KEY, urlText)
        super.onSaveInstanceState(outState) // need to be called last
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val restoreUrlText = savedInstanceState.getString(URL_KEY)

        if(restoreUrlText != null) urlText = restoreUrlText
    }
    
}
