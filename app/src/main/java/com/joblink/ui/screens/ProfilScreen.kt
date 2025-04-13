package com.joblink.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun ProfilScreen() {
    val userName = "Mohamed Abdourahman"
    val role = "UI/UX Designer"
    val bio =
        "Concepteur UI/UX passionné qui aime créer des interfaces impressionnantes qui fonctionnent très bien, et qui croit que la conception visuelle devrait être en mesure d’aider le client à se renseigner plus facilement sur les caractéristiques des produits, des services ou des marques. J’aime ce que je fais."
    val competences = listOf("IOS", "UX Design", "Figma", "Adobe XD", "Flutter", "Audio", "Illustrator", "Android", "Animation")
    val experiences = listOf(
        "Conception et prototypage d’interfaces utilisateur pour des applications web, mobiles et de bureau",
        "Collaborer avec des équipes interfonctionnelles, y compris la gestion de produits, l’ingénierie et le marketing",
        "Travailler avec le motion design et le design d’interaction pour créer des expériences utilisateur intuitives et engageantes\n" +
                "S’assurer que les conceptions sont accessibles, inclusives et conformes aux normes et directives de conception pertinentes\n" +
                "Réalisation de tests A/B et analyses des données utilisateurs pour optimiser les conceptions\n" +
                "Encadrer et/ou diriger des designers juniors dans l’équipe."
    )

    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .background(Brush.verticalGradient(listOf(Color(0xFFCC99FF), Color(0xFFEEE5FF))))
                .padding(24.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = androidx.compose.ui.Modifier.fillMaxWidth()) {
                Icon(
                    Icons.Default.AccountCircle,
                    contentDescription = "Photo de profil",
                    tint = Color.White,
                    modifier = androidx.compose.ui.Modifier.size(100.dp)
                )
                Text(userName, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.White)
                Text(role, fontSize = 16.sp, color = Color.White.copy(alpha = 0.9f))
                Spacer(modifier = androidx.compose.ui.Modifier.height(12.dp))
                Text(bio, fontSize = 14.sp, color = Color.White, modifier = androidx.compose.ui.Modifier.padding(horizontal = 16.dp), textAlign = TextAlign.Center)
            }

            TextButton(
                onClick = { /* Naviguer vers édition */ },
                modifier = androidx.compose.ui.Modifier.align(Alignment.TopEnd)
            ) {
                Text("Modifier", color = Color.White)
            }
        }

        Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))

        // Compétences
        Text("Compétences", fontWeight = FontWeight.SemiBold, fontSize = 18.sp, modifier = androidx.compose.ui.Modifier.padding(horizontal = 16.dp))

        // Expériences
        Text("Experience", fontWeight = FontWeight.SemiBold, fontSize = 18.sp, modifier = androidx.compose.ui.Modifier.padding(horizontal = 16.dp))
        Column(modifier = androidx.compose.ui.Modifier.padding(16.dp)) {
            experiences.forEachIndexed { index, exp ->
                Text("${index + 1}. $exp", fontSize = 14.sp, modifier = androidx.compose.ui.Modifier.padding(bottom = 12.dp))
            }
        }

        Row(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Maroua. - 28 Jan 2025", fontSize = 12.sp, color = Color.Gray)
            Row {
                Text("Voir plus", fontSize = 14.sp, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = androidx.compose.ui.Modifier.width(8.dp))
                repeat(5) {
                    Icon(Icons.Default.Star, contentDescription = "Note", tint = Color(0xFFFFD700), modifier = androidx.compose.ui.Modifier.size(16.dp))
                }
            }
        }
    }
}
