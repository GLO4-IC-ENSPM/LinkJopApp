package com.joblink.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joblink.data.entity.*
import com.joblink.data.dao.*

@Database(
    entities = [Utilisateur::class, Offre::class, Candidature::class, Message::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun utilisateurDao(): UtilisateurDao
    abstract fun offreDao(): OffreDao
    abstract fun candidatureDao(): CandidatureDao
    abstract fun messageDao(): MessageDao
}