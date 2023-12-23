package com.example.quickity

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import kotlin.random.Random

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
                    var mOpenMenu by remember { mutableStateOf(false) }
                    val mContext = LocalContext.current

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { TopAppBar(
                            title = {Text(text = "Quickity", fontStyle = FontStyle.Italic, fontWeight = FontWeight.Bold, fontSize = 32.sp, modifier = Modifier
                                .padding(start = 130.dp),
                                color = Color(0xFF1E90FF)
                            ) },
                            navigationIcon = {
                                Icon(painter = painterResource(id = R.drawable.quickity_navicon), contentDescription = null)
                            },
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
                                        modifier = Modifier.clip(RoundedCornerShape(40.dp)).wrapContentWidth()
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
/*
@Composable
fun FallingObjectsGame() {
    var score by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Catch the Falling Objects!",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        FallingObjectsGameView(onCatch = { score++ })
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Score: $score",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun FallingObjectsGameView(onCatch: () -> Unit) {
    val coroutineScope = rememberCoroutineScope()
    val objectsState = remember { mutableStateOf(listOf<FallingObject>()) }

    LaunchedEffect(objectsState) {
        while (true) {
            delay(1000) // Spawn new objects every second
            objectsState.value = objectsState.value + FallingObject()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        objectsState.value.forEach { fallingObject ->
            FallingObjectView(
                fallingObject = fallingObject,
                onCatch = { onCatch(); objectsState.value -= it }
            )
        }
    }
}

@Composable
fun FallingObjectView(fallingObject: FallingObject, onCatch: (FallingObject) -> Unit) {
    val animationSpec = remember { infiniteRepeatable(tween(1000), RepeatMode.Restart) }
    val offset by animateFloatAsState(
        targetValue = with(LocalDensity.current) { fallingObject.position.y.toDp() },
        animationSpec = animationSpec
    )

    Box(
        modifier = Modifier
            .offset(y = offset)
            .size(50.dp)
            .background(Color.Red)
            .pointerInput(Unit) {
                detectTapGestures { offsetPosition ->
                    if (offsetPosition.x in fallingObject.position.x..(fallingObject.position.x + 50)) {
                        onCatch(fallingObject)
                    }
                }
            }
    )
}

data class FallingObject(val position: Offset = Offset(Random.nextFloat() * 500, 0f))*/
