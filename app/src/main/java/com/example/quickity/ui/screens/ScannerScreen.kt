package com.example.quickity.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ScannerScreen(
    navController: NavController
) {
    Box(
        modifier = androidx.compose.ui.Modifier.padding(16.dp),
        contentAlignment = androidx.compose.ui.Alignment.Center,

    ) {
        Text(text = "Scan the QR code", modifier = androidx.compose.ui.Modifier.align(androidx.compose.ui.Alignment.Center), fontSize = 24.sp)
    }

}