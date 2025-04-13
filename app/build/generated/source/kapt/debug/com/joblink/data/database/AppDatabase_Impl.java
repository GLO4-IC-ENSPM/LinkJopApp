package com.joblink.data.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.joblink.data.dao.CandidatureDao;
import com.joblink.data.dao.CandidatureDao_Impl;
import com.joblink.data.dao.MessageDao;
import com.joblink.data.dao.MessageDao_Impl;
import com.joblink.data.dao.OffreDao;
import com.joblink.data.dao.OffreDao_Impl;
import com.joblink.data.dao.UtilisateurDao;
import com.joblink.data.dao.UtilisateurDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UtilisateurDao _utilisateurDao;

  private volatile OffreDao _offreDao;

  private volatile CandidatureDao _candidatureDao;

  private volatile MessageDao _messageDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `utilisateurs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nom` TEXT NOT NULL, `email` TEXT NOT NULL, `motDePasse` TEXT NOT NULL, `type` TEXT NOT NULL, `disponibilite` TEXT, `competences` TEXT, `cv` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `offres` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `titre` TEXT NOT NULL, `description` TEXT NOT NULL, `competencesRequises` TEXT NOT NULL, `recruteurId` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `candidatures` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `offreId` INTEGER NOT NULL, `utilisateurId` INTEGER NOT NULL, `date` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `messages` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `expediteurId` INTEGER NOT NULL, `destinataireId` INTEGER NOT NULL, `contenu` TEXT NOT NULL, `horodatage` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b71bb27f11b2170499f09271ed641dbd')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `utilisateurs`");
        _db.execSQL("DROP TABLE IF EXISTS `offres`");
        _db.execSQL("DROP TABLE IF EXISTS `candidatures`");
        _db.execSQL("DROP TABLE IF EXISTS `messages`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUtilisateurs = new HashMap<String, TableInfo.Column>(8);
        _columnsUtilisateurs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUtilisateurs.put("nom", new TableInfo.Column("nom", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUtilisateurs.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUtilisateurs.put("motDePasse", new TableInfo.Column("motDePasse", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUtilisateurs.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUtilisateurs.put("disponibilite", new TableInfo.Column("disponibilite", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUtilisateurs.put("competences", new TableInfo.Column("competences", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUtilisateurs.put("cv", new TableInfo.Column("cv", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUtilisateurs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUtilisateurs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUtilisateurs = new TableInfo("utilisateurs", _columnsUtilisateurs, _foreignKeysUtilisateurs, _indicesUtilisateurs);
        final TableInfo _existingUtilisateurs = TableInfo.read(_db, "utilisateurs");
        if (! _infoUtilisateurs.equals(_existingUtilisateurs)) {
          return new RoomOpenHelper.ValidationResult(false, "utilisateurs(com.joblink.data.entity.Utilisateur).\n"
                  + " Expected:\n" + _infoUtilisateurs + "\n"
                  + " Found:\n" + _existingUtilisateurs);
        }
        final HashMap<String, TableInfo.Column> _columnsOffres = new HashMap<String, TableInfo.Column>(5);
        _columnsOffres.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOffres.put("titre", new TableInfo.Column("titre", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOffres.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOffres.put("competencesRequises", new TableInfo.Column("competencesRequises", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOffres.put("recruteurId", new TableInfo.Column("recruteurId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOffres = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOffres = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOffres = new TableInfo("offres", _columnsOffres, _foreignKeysOffres, _indicesOffres);
        final TableInfo _existingOffres = TableInfo.read(_db, "offres");
        if (! _infoOffres.equals(_existingOffres)) {
          return new RoomOpenHelper.ValidationResult(false, "offres(com.joblink.data.entity.Offre).\n"
                  + " Expected:\n" + _infoOffres + "\n"
                  + " Found:\n" + _existingOffres);
        }
        final HashMap<String, TableInfo.Column> _columnsCandidatures = new HashMap<String, TableInfo.Column>(4);
        _columnsCandidatures.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCandidatures.put("offreId", new TableInfo.Column("offreId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCandidatures.put("utilisateurId", new TableInfo.Column("utilisateurId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCandidatures.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCandidatures = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCandidatures = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCandidatures = new TableInfo("candidatures", _columnsCandidatures, _foreignKeysCandidatures, _indicesCandidatures);
        final TableInfo _existingCandidatures = TableInfo.read(_db, "candidatures");
        if (! _infoCandidatures.equals(_existingCandidatures)) {
          return new RoomOpenHelper.ValidationResult(false, "candidatures(com.joblink.data.entity.Candidature).\n"
                  + " Expected:\n" + _infoCandidatures + "\n"
                  + " Found:\n" + _existingCandidatures);
        }
        final HashMap<String, TableInfo.Column> _columnsMessages = new HashMap<String, TableInfo.Column>(5);
        _columnsMessages.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("expediteurId", new TableInfo.Column("expediteurId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("destinataireId", new TableInfo.Column("destinataireId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("contenu", new TableInfo.Column("contenu", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("horodatage", new TableInfo.Column("horodatage", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMessages = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMessages = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMessages = new TableInfo("messages", _columnsMessages, _foreignKeysMessages, _indicesMessages);
        final TableInfo _existingMessages = TableInfo.read(_db, "messages");
        if (! _infoMessages.equals(_existingMessages)) {
          return new RoomOpenHelper.ValidationResult(false, "messages(com.joblink.data.entity.Message).\n"
                  + " Expected:\n" + _infoMessages + "\n"
                  + " Found:\n" + _existingMessages);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "b71bb27f11b2170499f09271ed641dbd", "0c23961d823f85a75c746382ac9d72fd");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "utilisateurs","offres","candidatures","messages");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `utilisateurs`");
      _db.execSQL("DELETE FROM `offres`");
      _db.execSQL("DELETE FROM `candidatures`");
      _db.execSQL("DELETE FROM `messages`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UtilisateurDao.class, UtilisateurDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(OffreDao.class, OffreDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CandidatureDao.class, CandidatureDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MessageDao.class, MessageDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public UtilisateurDao utilisateurDao() {
    if (_utilisateurDao != null) {
      return _utilisateurDao;
    } else {
      synchronized(this) {
        if(_utilisateurDao == null) {
          _utilisateurDao = new UtilisateurDao_Impl(this);
        }
        return _utilisateurDao;
      }
    }
  }

  @Override
  public OffreDao offreDao() {
    if (_offreDao != null) {
      return _offreDao;
    } else {
      synchronized(this) {
        if(_offreDao == null) {
          _offreDao = new OffreDao_Impl(this);
        }
        return _offreDao;
      }
    }
  }

  @Override
  public CandidatureDao candidatureDao() {
    if (_candidatureDao != null) {
      return _candidatureDao;
    } else {
      synchronized(this) {
        if(_candidatureDao == null) {
          _candidatureDao = new CandidatureDao_Impl(this);
        }
        return _candidatureDao;
      }
    }
  }

  @Override
  public MessageDao messageDao() {
    if (_messageDao != null) {
      return _messageDao;
    } else {
      synchronized(this) {
        if(_messageDao == null) {
          _messageDao = new MessageDao_Impl(this);
        }
        return _messageDao;
      }
    }
  }
}
