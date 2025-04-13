package com.joblink.data.dao

import androidx.room.*
import com.joblink.data.entity.Message

@Dao
interface MessageDao {
    @Insert
    suspend fun envoyer(message: Message)

    @Query("""
        SELECT * FROM messages
        WHERE (expediteurId = :utilisateur1 AND destinataireId = :utilisateur2)
        OR (expediteurId = :utilisateur2 AND destinataireId = :utilisateur1)
        ORDER BY horodatage ASC
    """)
    suspend fun getConversation(utilisateur1: Int, utilisateur2: Int): List<Message>
}