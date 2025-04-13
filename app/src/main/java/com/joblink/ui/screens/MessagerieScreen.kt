package com.joblink.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.joblink.data.entity.Message

@Composable
fun MessagerieScreen(
    conversationId: Int = 2,
    nomContact: String = "Nana Nafissatou"
) {
    val messages = remember {
        mutableStateListOf(
            Message(1, 1, conversationId, "Salut !", "10:00"),
            Message(2, conversationId, 1, "Salut ! Comment ça va ?", "10:01")
        )
    }
    var message by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        // En-tête de la conversation
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Surface(
                shape = CircleShape,
                color = Color(0xFFE0E0E0),
                modifier = Modifier.size(45.dp)
            ) {
                Icon(
                    Icons.Default.Person,
                    contentDescription = "Avatar",
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = nomContact,
                style = MaterialTheme.typography.titleMedium
            )
        }

        Divider()

        // Liste des messages
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            items(messages) { msg ->
                val isMine = msg.expediteurId == 1
                Row(
                    horizontalArrangement = if (isMine) Arrangement.End else Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = if (isMine) Color(0xFFDCF8C6) else Color(0xFFFFFFFF),
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text(
                            msg.contenu ?: "",
                            modifier = Modifier.padding(10.dp),
                            color = Color.Black
                        )
                    }
                }
            }
        }

        Divider()

        // Champ de saisie
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
        ) {
            TextField(
                value = message,
                onValueChange = { message = it },
                placeholder = { Text("Écrire un message...") },
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = {
                    if (message.isNotBlank()) {
                        messages.add(
                            Message(
                                id = messages.size + 1,
                                expediteurId = 1,
                                destinataireId = conversationId,
                                contenu = message,
                                horodatage = "Now"
                            )
                        )
                        message = ""
                    }
                }
            ) {
                Icon(Icons.Default.Send, contentDescription = "Envoyer")
            }
        }
    }
}
