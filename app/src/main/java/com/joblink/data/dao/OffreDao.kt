package com.joblink.data.dao

import androidx.room.*
import com.joblink.data.entity.Offre

@Dao
interface OffreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserer(offre: Offre)

    @Query("SELECT * FROM offres")
    suspend fun getToutes(): List<Offre>

    @Query("SELECT * FROM offres WHERE recruteurId = :id")
    suspend fun getParRecruteur(id: Int): List<Offre>
}