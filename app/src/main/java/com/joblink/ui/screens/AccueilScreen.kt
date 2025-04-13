package com.joblink.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joblink.R

@Composable
fun AccueilScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Message de bienvenue
        Text(
            text = "Bienvenue sur JobLink !",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary

        )

        Text(
            text = "Votre carrière ou votre équipe commence ici !",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )


        Image(
            painter = painterResource(id = R.drawable.joblink1), // logo.png placé dans res/drawable/
            contentDescription = "Logo JobLink",
            modifier = Modifier
                .size(400.dp)
                .padding(bottom = 24.dp)
        )


    }
}
