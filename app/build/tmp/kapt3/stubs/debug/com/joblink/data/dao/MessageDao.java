package com.joblink.data.dao;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/joblink/data/dao/MessageDao;", "", "envoyer", "", "message", "Lcom/joblink/data/entity/Message;", "(Lcom/joblink/data/entity/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConversation", "", "utilisateur1", "", "utilisateur2", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface MessageDao {
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object envoyer(@org.jetbrains.annotations.NotNull()
    com.joblink.data.entity.Message message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "\n        SELECT * FROM messages\n        WHERE (expediteurId = :utilisateur1 AND destinataireId = :utilisateur2)\n        OR (expediteurId = :utilisateur2 AND destinataireId = :utilisateur1)\n        ORDER BY horodatage ASC\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getConversation(int utilisateur1, int utilisateur2, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.joblink.data.entity.Message>> $completion);
}