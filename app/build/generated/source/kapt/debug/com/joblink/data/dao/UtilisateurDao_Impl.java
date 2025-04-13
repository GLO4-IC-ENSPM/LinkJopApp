package com.joblink.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.joblink.data.entity.Utilisateur;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UtilisateurDao_Impl implements UtilisateurDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Utilisateur> __insertionAdapterOfUtilisateur;

  public UtilisateurDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUtilisateur = new EntityInsertionAdapter<Utilisateur>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `utilisateurs` (`id`,`nom`,`email`,`motDePasse`,`type`,`disponibilite`,`competences`,`cv`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Utilisateur value) {
        stmt.bindLong(1, value.getId());
        if (value.getNom() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNom());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
        if (value.getMotDePasse() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMotDePasse());
        }
        if (value.getType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getType());
        }
        if (value.getDisponibilite() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDisponibilite());
        }
        if (value.getCompetences() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCompetences());
        }
        if (value.getCv() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCv());
        }
      }
    };
  }

  @Override
  public Object inserer(final Utilisateur utilisateur,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUtilisateur.insert(utilisateur);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object login(final String email, final String motDePasse,
      final Continuation<? super Utilisateur> $completion) {
    final String _sql = "SELECT * FROM utilisateurs WHERE email = ? AND motDePasse = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    _argIndex = 2;
    if (motDePasse == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, motDePasse);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Utilisateur>() {
      @Override
      public Utilisateur call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfMotDePasse = CursorUtil.getColumnIndexOrThrow(_cursor, "motDePasse");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfDisponibilite = CursorUtil.getColumnIndexOrThrow(_cursor, "disponibilite");
          final int _cursorIndexOfCompetences = CursorUtil.getColumnIndexOrThrow(_cursor, "competences");
          final int _cursorIndexOfCv = CursorUtil.getColumnIndexOrThrow(_cursor, "cv");
          final Utilisateur _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNom;
            if (_cursor.isNull(_cursorIndexOfNom)) {
              _tmpNom = null;
            } else {
              _tmpNom = _cursor.getString(_cursorIndexOfNom);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpMotDePasse;
            if (_cursor.isNull(_cursorIndexOfMotDePasse)) {
              _tmpMotDePasse = null;
            } else {
              _tmpMotDePasse = _cursor.getString(_cursorIndexOfMotDePasse);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final String _tmpDisponibilite;
            if (_cursor.isNull(_cursorIndexOfDisponibilite)) {
              _tmpDisponibilite = null;
            } else {
              _tmpDisponibilite = _cursor.getString(_cursorIndexOfDisponibilite);
            }
            final String _tmpCompetences;
            if (_cursor.isNull(_cursorIndexOfCompetences)) {
              _tmpCompetences = null;
            } else {
              _tmpCompetences = _cursor.getString(_cursorIndexOfCompetences);
            }
            final String _tmpCv;
            if (_cursor.isNull(_cursorIndexOfCv)) {
              _tmpCv = null;
            } else {
              _tmpCv = _cursor.getString(_cursorIndexOfCv);
            }
            _result = new Utilisateur(_tmpId,_tmpNom,_tmpEmail,_tmpMotDePasse,_tmpType,_tmpDisponibilite,_tmpCompetences,_tmpCv);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getParId(final int id, final Continuation<? super Utilisateur> $completion) {
    final String _sql = "SELECT * FROM utilisateurs WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Utilisateur>() {
      @Override
      public Utilisateur call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfMotDePasse = CursorUtil.getColumnIndexOrThrow(_cursor, "motDePasse");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfDisponibilite = CursorUtil.getColumnIndexOrThrow(_cursor, "disponibilite");
          final int _cursorIndexOfCompetences = CursorUtil.getColumnIndexOrThrow(_cursor, "competences");
          final int _cursorIndexOfCv = CursorUtil.getColumnIndexOrThrow(_cursor, "cv");
          final Utilisateur _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNom;
            if (_cursor.isNull(_cursorIndexOfNom)) {
              _tmpNom = null;
            } else {
              _tmpNom = _cursor.getString(_cursorIndexOfNom);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpMotDePasse;
            if (_cursor.isNull(_cursorIndexOfMotDePasse)) {
              _tmpMotDePasse = null;
            } else {
              _tmpMotDePasse = _cursor.getString(_cursorIndexOfMotDePasse);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final String _tmpDisponibilite;
            if (_cursor.isNull(_cursorIndexOfDisponibilite)) {
              _tmpDisponibilite = null;
            } else {
              _tmpDisponibilite = _cursor.getString(_cursorIndexOfDisponibilite);
            }
            final String _tmpCompetences;
            if (_cursor.isNull(_cursorIndexOfCompetences)) {
              _tmpCompetences = null;
            } else {
              _tmpCompetences = _cursor.getString(_cursorIndexOfCompetences);
            }
            final String _tmpCv;
            if (_cursor.isNull(_cursorIndexOfCv)) {
              _tmpCv = null;
            } else {
              _tmpCv = _cursor.getString(_cursorIndexOfCv);
            }
            _result = new Utilisateur(_tmpId,_tmpNom,_tmpEmail,_tmpMotDePasse,_tmpType,_tmpDisponibilite,_tmpCompetences,_tmpCv);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
