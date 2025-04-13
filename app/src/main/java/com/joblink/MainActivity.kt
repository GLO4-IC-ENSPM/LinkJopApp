package com.joblink

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.joblink.ui.screens.*

data class NavItem(
    val route: String,
    val label: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

val bottomNavItems = listOf(
    NavItem("accueil", "Accueil", Icons.Default.Home),
    NavItem("offres", "Offres", Icons.Default.List),
    NavItem("messagerie", "Messages", Icons.Default.MailOutline),
    NavItem("profil", "Profil", Icons.Default.Person)

)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStackEntry?.destination?.route
                Scaffold(
                    topBar = {
                        if (currentRoute != "connexion" && currentRoute != "inscription") {
                            @OptIn(ExperimentalMaterial3Api::class)
                            TopAppBar(
                                title = {
                                    Text(
                                        when (currentRoute) {
                                            "accueil" -> "Accueil"
                                            "offres" -> "Offres"
                                            "candidatures" -> "Candidatures"
                                            "messagerie" -> "Messagerie"
                                            "profil" -> "Profil"
                                            "ajouter" -> "Ajouter une offre"
                                            else -> ""
                                        }
                                    )
                                },
                                colors = TopAppBarDefaults.smallTopAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                                )
                            )
                        }
                    },
                    bottomBar = {
                        if (currentRoute != "connexion" && currentRoute != "inscription") {
                            BottomNavigationBar(navController = navController)
                        }
                    }
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = "connexion",
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable("connexion") { ConnexionScreen(navController) }
                        composable("accueil") { AccueilScreen() }
                        composable("offres") { ListeOffresScreen(navController) }
                        composable("candidatures") { CandidaturesScreen() }
                        composable("messagerie") { MessagerieScreen() }
                        composable("profil") { ProfilScreen() }
                        composable("ajouter") { AjouterOffreScreen(navController) }
                        composable("inscription") { InscriptionScreen(navController) }
                    }
                }
            }
        }
    }
}


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    val selectedColor = Color(0xFF8E24AA) // Violet foncé
    val unselectedColor = Color(0xFFB39DDB) // Violet clair

    NavigationBar {
        bottomNavItems.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = selectedColor,
                    unselectedIconColor = unselectedColor,
                    selectedTextColor = selectedColor,
                    unselectedTextColor = unselectedColor
                )
            )
        }
    }
}

