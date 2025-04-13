package com.joblink.data.dao

import androidx.room.*
import com.joblink.data.entity.Utilisateur

@Dao
interface UtilisateurDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserer(utilisateur: Utilisateur)

    @Query("SELECT * FROM utilisateurs WHERE email = :email AND motDePasse = :motDePasse")
    suspend fun login(email: String, motDePasse: String): Utilisateur?

    @Query("SELECT * FROM utilisateurs WHERE id = :id")
    suspend fun getParId(id: Int): Utilisateur?
}