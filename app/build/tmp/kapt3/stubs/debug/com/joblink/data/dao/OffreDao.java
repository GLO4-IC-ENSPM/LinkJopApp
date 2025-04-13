package com.joblink.data.dao;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/joblink/data/dao/OffreDao;", "", "getParRecruteur", "", "Lcom/joblink/data/entity/Offre;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getToutes", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inserer", "", "offre", "(Lcom/joblink/data/entity/Offre;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface OffreDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object inserer(@org.jetbrains.annotations.NotNull()
    com.joblink.data.entity.Offre offre, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM offres")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getToutes(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.joblink.data.entity.Offre>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM offres WHERE recruteurId = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getParRecruteur(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.joblink.data.entity.Offre>> $completion);
}