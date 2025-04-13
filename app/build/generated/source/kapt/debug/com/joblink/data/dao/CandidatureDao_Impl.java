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
import com.joblink.data.entity.Candidature;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class CandidatureDao_Impl implements CandidatureDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Candidature> __insertionAdapterOfCandidature;

  public CandidatureDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCandidature = new EntityInsertionAdapter<Candidature>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `candidatures` (`id`,`offreId`,`utilisateurId`,`date`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Candidature value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getOffreId());
        stmt.bindLong(3, value.getUtilisateurId());
        if (value.getDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDate());
        }
      }
    };
  }

  @Override
  public Object postuler(final Candidature candidature,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCandidature.insert(candidature);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getParCandidat(final int id,
      final Continuation<? super List<Candidature>> $completion) {
    final String _sql = "SELECT * FROM candidatures WHERE utilisateurId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Candidature>>() {
      @Override
      public List<Candidature> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfOffreId = CursorUtil.getColumnIndexOrThrow(_cursor, "offreId");
          final int _cursorIndexOfUtilisateurId = CursorUtil.getColumnIndexOrThrow(_cursor, "utilisateurId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final List<Candidature> _result = new ArrayList<Candidature>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Candidature _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpOffreId;
            _tmpOffreId = _cursor.getInt(_cursorIndexOfOffreId);
            final int _tmpUtilisateurId;
            _tmpUtilisateurId = _cursor.getInt(_cursorIndexOfUtilisateurId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            _item = new Candidature(_tmpId,_tmpOffreId,_tmpUtilisateurId,_tmpDate);
            _result.add(_item);
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
  public Object getParOffre(final int offreId,
      final Continuation<? super List<Candidature>> $completion) {
    final String _sql = "SELECT * FROM candidatures WHERE offreId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, offreId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Candidature>>() {
      @Override
      public List<Candidature> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfOffreId = CursorUtil.getColumnIndexOrThrow(_cursor, "offreId");
          final int _cursorIndexOfUtilisateurId = CursorUtil.getColumnIndexOrThrow(_cursor, "utilisateurId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final List<Candidature> _result = new ArrayList<Candidature>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Candidature _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpOffreId;
            _tmpOffreId = _cursor.getInt(_cursorIndexOfOffreId);
            final int _tmpUtilisateurId;
            _tmpUtilisateurId = _cursor.getInt(_cursorIndexOfUtilisateurId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            _item = new Candidature(_tmpId,_tmpOffreId,_tmpUtilisateurId,_tmpDate);
            _result.add(_item);
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
