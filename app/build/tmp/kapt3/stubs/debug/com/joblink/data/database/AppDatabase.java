package com.joblink.data.database;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/joblink/data/database/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "candidatureDao", "Lcom/joblink/data/dao/CandidatureDao;", "messageDao", "Lcom/joblink/data/dao/MessageDao;", "offreDao", "Lcom/joblink/data/dao/OffreDao;", "utilisateurDao", "Lcom/joblink/data/dao/UtilisateurDao;", "app_debug"})
@androidx.room.Database(entities = {com.joblink.data.entity.Utilisateur.class, com.joblink.data.entity.Offre.class, com.joblink.data.entity.Candidature.class, com.joblink.data.entity.Message.class}, version = 1)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.joblink.data.dao.UtilisateurDao utilisateurDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.joblink.data.dao.OffreDao offreDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.joblink.data.dao.CandidatureDao candidatureDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.joblink.data.dao.MessageDao messageDao();
}