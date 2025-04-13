package com.joblink.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.joblink.data.entity.Offre
import kotlinx.coroutines.runBlocking

@Composable
fun ListeOffresScreen(navController: NavHostController) {
    val offres = remember { mutableStateListOf<Offre>() }

    // Exemple de données simulées
    LaunchedEffect(Unit) {
        offres.addAll(
            listOf(
                Offre(titre = "Développeur Android", description = "App mobile Kotlin", competencesRequises = "Kotlin, Jetpack Compose", recruteurId = 1),
                Offre(titre = "Data Analyst", description = "Analyse de données", competencesRequises = "Python, SQL", recruteurId = 2),
                Offre(titre = "UX Designer", description = "UI/UX Design", competencesRequises = "Figma, Adobe XD", recruteurId = 3)
            )
        )
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("ajouter") },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Ajouter une offre", tint = Color.White)
            }
        }
    ) { innerPadding ->
        val context = LocalContext.current
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(offres) { offre ->
                OffreCard(offre = offre, onPostulerClicked = {
                    // navController.navigate("postuler/${offre.id}")

                    Toast.makeText(context, "Candidature envoyée !", Toast.LENGTH_SHORT).show()

                })
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun OffreCard(offre: Offre, onPostulerClicked: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp, shape = RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF6F6FE)),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Build, contentDescription = "Poste", tint = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = offre.titre,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Info, contentDescription = "Description", tint = Color.Gray)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = offre.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.CheckCircle, contentDescription = "Compétences", tint = Color(0xFF6A5ACD))
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = offre.competencesRequises,
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.DarkGray)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onPostulerClicked,
                modifier = Modifier.align(Alignment.End),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Icon(Icons.Default.Send, contentDescription = "Postuler", modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("Postuler")
            }
        }
    }
}

