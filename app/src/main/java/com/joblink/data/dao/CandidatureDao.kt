package com.joblink.data.dao

import androidx.room.*
import com.joblink.data.entity.Candidature

@Dao
interface CandidatureDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun postuler(candidature: Candidature)

    @Query("SELECT * FROM candidatures WHERE utilisateurId = :id")
    suspend fun getParCandidat(id: Int): List<Candidature>

    @Query("SELECT * FROM candidatures WHERE offreId = :offreId")
    suspend fun getParOffre(offreId: Int): List<Candidature>
}