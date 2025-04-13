package com.joblink.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "candidatures")
data class Candidature(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val offreId: Int,
    val utilisateurId: Int,
    val date: String
)