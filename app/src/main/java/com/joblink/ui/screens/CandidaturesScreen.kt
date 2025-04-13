package com.joblink.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joblink.data.entity.Candidature

@Composable
fun CandidaturesScreen(candidatures: List<Candidature> = emptyList()) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(candidatures) { c ->
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Offre ID : ${c.offreId}", style = MaterialTheme.typography.bodyMedium)
                    Text("Date : ${c.date}")
                }
            }
        }
    }
}