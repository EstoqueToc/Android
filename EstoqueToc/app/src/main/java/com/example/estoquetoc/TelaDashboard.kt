package com.example.estoquetoc

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.estoquetoc.ui.theme.EstoqueTocTheme

class TelaDashboard {

    @Composable
    fun DashboardScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            // UI Components here
            // DashboardContent()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DashboardScreenPreview() {
        EstoqueTocTheme {
            DashboardScreen()
        }
    }

}