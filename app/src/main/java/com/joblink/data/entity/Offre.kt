package com.joblink.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "offres")
data class Offre(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titre: String,
    val description: String,
    val competencesRequises: String,
    val recruteurId: Int
)