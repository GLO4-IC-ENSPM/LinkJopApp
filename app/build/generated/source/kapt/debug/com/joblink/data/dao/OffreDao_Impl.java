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
import com.joblink.data.entity.Offre;
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
public final class OffreDao_Impl implements OffreDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Offre> __insertionAdapterOfOffre;

  public OffreDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOffre = new EntityInsertionAdapter<Offre>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `offres` (`id`,`titre`,`description`,`competencesRequises`,`recruteurId`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Offre value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitre() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitre());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getCompetencesRequises() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCompetencesRequises());
        }
        stmt.bindLong(5, value.getRecruteurId());
      }
    };
  }

  @Override
  public Object inserer(final Offre offre, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfOffre.insert(offre);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getToutes(final Continuation<? super List<Offre>> $completion) {
    final String _sql = "SELECT * FROM offres";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Offre>>() {
      @Override
      public List<Offre> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitre = CursorUtil.getColumnIndexOrThrow(_cursor, "titre");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCompetencesRequises = CursorUtil.getColumnIndexOrThrow(_cursor, "competencesRequises");
          final int _cursorIndexOfRecruteurId = CursorUtil.getColumnIndexOrThrow(_cursor, "recruteurId");
          final List<Offre> _result = new ArrayList<Offre>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Offre _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitre;
            if (_cursor.isNull(_cursorIndexOfTitre)) {
              _tmpTitre = null;
            } else {
              _tmpTitre = _cursor.getString(_cursorIndexOfTitre);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCompetencesRequises;
            if (_cursor.isNull(_cursorIndexOfCompetencesRequises)) {
              _tmpCompetencesRequises = null;
            } else {
              _tmpCompetencesRequises = _cursor.getString(_cursorIndexOfCompetencesRequises);
            }
            final int _tmpRecruteurId;
            _tmpRecruteurId = _cursor.getInt(_cursorIndexOfRecruteurId);
            _item = new Offre(_tmpId,_tmpTitre,_tmpDescription,_tmpCompetencesRequises,_tmpRecruteurId);
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
  public Object getParRecruteur(final int id, final Continuation<? super List<Offre>> $completion) {
    final String _sql = "SELECT * FROM offres WHERE recruteurId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Offre>>() {
      @Override
      public List<Offre> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitre = CursorUtil.getColumnIndexOrThrow(_cursor, "titre");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCompetencesRequises = CursorUtil.getColumnIndexOrThrow(_cursor, "competencesRequises");
          final int _cursorIndexOfRecruteurId = CursorUtil.getColumnIndexOrThrow(_cursor, "recruteurId");
          final List<Offre> _result = new ArrayList<Offre>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Offre _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitre;
            if (_cursor.isNull(_cursorIndexOfTitre)) {
              _tmpTitre = null;
            } else {
              _tmpTitre = _cursor.getString(_cursorIndexOfTitre);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCompetencesRequises;
            if (_cursor.isNull(_cursorIndexOfCompetencesRequises)) {
              _tmpCompetencesRequises = null;
            } else {
              _tmpCompetencesRequises = _cursor.getString(_cursorIndexOfCompetencesRequises);
            }
            final int _tmpRecruteurId;
            _tmpRecruteurId = _cursor.getInt(_cursorIndexOfRecruteurId);
            _item = new Offre(_tmpId,_tmpTitre,_tmpDescription,_tmpCompetencesRequises,_tmpRecruteurId);
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
