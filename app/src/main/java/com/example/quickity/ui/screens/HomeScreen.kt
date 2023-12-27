package com.example.quickity.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.quickity.api_feature.ui.screen.AgentsList
import com.example.quickity.api_feature.ui.screen.WeaponsList
import com.example.quickity.api_feature.viewmodel.HomeViewModel
import com.example.quickity.ui.BottomNavigation
import com.example.quickity.ui.theme.blackV
import com.example.quickity.ui.theme.redV
import com.example.quickity.ui.theme.tungstenFont
import com.example.quickity.ui.theme.valorantFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel, navHostController: NavHostController){
    Scaffold(topBar = {
        CenterAlignedTopAppBar(colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            blackV
        ),
            title = {
                Text(
                    "QUICKITY",
                    style = TextStyle(
                        fontFamily = valorantFont,
                        color = Color.White,
                        fontSize = 30.sp
                    )
                )
            })
    },
/*        bottomBar = {
            BottomNavigation(navController = navHostController)
        }*/
        ) {
        TabScreen(modifier = Modifier.padding(it), navHostController, viewModel)
    }
}



@Composable
fun TabScreen(modifier: Modifier, navHostController: NavHostController, viewModel: HomeViewModel) {
    val tabIndex= viewModel.tabIndex

    val tabs = listOf("Agents", "Weapons")

    Column(modifier = modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = tabIndex,
            containerColor = blackV,
            contentColor = redV,
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
                    content = {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(redV)
                                .height(5.dp)
                                .align(Alignment.BottomCenter) // Adjust the height of the indicator
                        )
                    }
                )
            }) {
            tabs.forEachIndexed { index, title ->
                Tab(selectedContentColor = redV,
                    text = {
                        Text(
                            title,
                            style = TextStyle(fontSize = 20.sp, fontFamily = tungstenFont)
                        )
                    },
                    selected = tabIndex == index,
                    onClick = { viewModel.tabIndex(index) }
                )
            }
        }
        when (tabIndex) {
            0 -> AgentsList(navHostController, viewModel)
            1 -> WeaponsList(navHostController,viewModel)
        }
    }
}

/*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.quickity.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
) {
    //val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            //.verticalScroll(scrollState)
    ) {
        LazyColumn{
            item {
                */
/*Text(text = "Quickity",fontWeight = FontWeight.Bold, fontSize = 36.sp, modifier = Modifier
                    .padding(16.dp)
                    .padding(start = 32.dp)
                    .align(Alignment.CenterHorizontally))*//*

                Text(text = "Quickity", fontStyle = FontStyle.Italic, fontWeight = FontWeight.Bold, fontSize = 32.sp, modifier = Modifier
                    .padding(start = 160.dp)
                    .align(Alignment.CenterHorizontally),
                    color = Color(0xFF1E90FF))
                Box {
                    AnimatedPreloader(modifier = Modifier
                        .size(400.dp)
                        .padding(16.dp)
                    )
                }
            }
            items(10){
                HomeScreenCard()
            }
        }
    }
}

@Composable
private fun AnimatedPreloader(modifier: Modifier = Modifier) {
    val preloaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.quickity_anim1
        )
    )

    val preloaderProgress by animateLottieCompositionAsState(
        preloaderLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )


    LottieAnimation(
        composition = preloaderLottieComposition,
        progress = preloaderProgress,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenCard() {
    Card(
        onClick = { */
/*TODO*//*
 },
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                //fontFamily = spacefamily,
                text = "Products", fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(

                text ="Quickity is a mobile application that allows you to scan QR codes and pay for products, and is " +
                        "a smarter solution to overcome hassle in shopping malls."
                        +"This card is just for testing purposes.",
                //fontFamily = spacefamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)

            )
            Image(
                painter = painterResource(id = R.drawable.phone_shopping),
                contentDescription = "project image",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .align(Alignment.Start)
                    .clip(shape = MaterialTheme.shapes.extraLarge)
                    .background(color = Color.White)
                */
/*.background(color = Color.LightGray)*//*

                ,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Button(
                    onClick = { */
/*TODO*//*
 },
                    modifier = Modifier
                        .padding(vertical = 12.dp, horizontal = 16.dp)
                ) {
                    Text(text = "Buy Product", fontWeight = FontWeight.Bold)
                }

                OutlinedButton(
                    onClick = { */
/*TODO*//*
 },
                    modifier = Modifier
                        .padding(vertical = 12.dp, horizontal = 16.dp)
                ) {
                    Icon(imageVector = Icons.Filled.Info, contentDescription = "info", Modifier.padding(end = 5.dp))
                    Text(text = "Inquire" */
/*fontWeight = FontWeight.Bold*//*
)
                }
            }
        }
    }

}*/
