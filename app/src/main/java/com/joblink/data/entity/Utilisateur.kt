package com.joblink.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "utilisateurs")
data class Utilisateur(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nom: String,
    val email: String,
    val motDePasse: String,
    val type: String,
    val disponibilite: String? = null,
    val competences: String? = null,
    val cv: String? = null
)