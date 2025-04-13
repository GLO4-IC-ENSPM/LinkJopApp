package com.joblink.data.dao;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/joblink/data/dao/CandidatureDao;", "", "getParCandidat", "", "Lcom/joblink/data/entity/Candidature;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getParOffre", "offreId", "postuler", "", "candidature", "(Lcom/joblink/data/entity/Candidature;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface CandidatureDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object postuler(@org.jetbrains.annotations.NotNull()
    com.joblink.data.entity.Candidature candidature, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM candidatures WHERE utilisateurId = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getParCandidat(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.joblink.data.entity.Candidature>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM candidatures WHERE offreId = :offreId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getParOffre(int offreId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.joblink.data.entity.Candidature>> $completion);
}