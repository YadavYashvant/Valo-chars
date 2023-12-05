package com.example.quickity.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.quickity.R

@Composable
fun ScannerScreen(
    navController: NavController
) {
    Box(
        modifier = androidx.compose.ui.Modifier.padding(16.dp),
        contentAlignment = androidx.compose.ui.Alignment.Center,

    ) {
        //Text(text = "Scan the QR code", modifier = androidx.compose.ui.Modifier.align(androidx.compose.ui.Alignment.Center), fontSize = 24.sp)
        AnimatedPreloaderScan(modifier = Modifier
            .size(500.dp)
            .padding(16.dp)
        )
    }

}

@Composable
fun AnimatedPreloaderScan(modifier: Modifier = Modifier) {
    val preloaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.scan_anim
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