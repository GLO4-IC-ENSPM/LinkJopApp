package com.joblink.data.dao;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ#\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/joblink/data/dao/UtilisateurDao;", "", "getParId", "Lcom/joblink/data/entity/Utilisateur;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inserer", "", "utilisateur", "(Lcom/joblink/data/entity/Utilisateur;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "email", "", "motDePasse", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface UtilisateurDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object inserer(@org.jetbrains.annotations.NotNull()
    com.joblink.data.entity.Utilisateur utilisateur, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM utilisateurs WHERE email = :email AND motDePasse = :motDePasse")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String motDePasse, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.joblink.data.entity.Utilisateur> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM utilisateurs WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getParId(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.joblink.data.entity.Utilisateur> $completion);
}