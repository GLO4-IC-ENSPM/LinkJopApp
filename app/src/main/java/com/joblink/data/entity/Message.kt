package com.joblink.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val expediteurId: Int,
    val destinataireId: Int,
    val contenu: String,
    val horodatage: String
)