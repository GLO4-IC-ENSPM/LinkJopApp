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
import com.joblink.data.entity.Message;
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
public final class MessageDao_Impl implements MessageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Message> __insertionAdapterOfMessage;

  public MessageDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMessage = new EntityInsertionAdapter<Message>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `messages` (`id`,`expediteurId`,`destinataireId`,`contenu`,`horodatage`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Message value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getExpediteurId());
        stmt.bindLong(3, value.getDestinataireId());
        if (value.getContenu() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getContenu());
        }
        if (value.getHorodatage() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getHorodatage());
        }
      }
    };
  }

  @Override
  public Object envoyer(final Message message, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMessage.insert(message);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getConversation(final int utilisateur1, final int utilisateur2,
      final Continuation<? super List<Message>> $completion) {
    final String _sql = "\n"
            + "        SELECT * FROM messages\n"
            + "        WHERE (expediteurId = ? AND destinataireId = ?)\n"
            + "        OR (expediteurId = ? AND destinataireId = ?)\n"
            + "        ORDER BY horodatage ASC\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, utilisateur1);
    _argIndex = 2;
    _statement.bindLong(_argIndex, utilisateur2);
    _argIndex = 3;
    _statement.bindLong(_argIndex, utilisateur2);
    _argIndex = 4;
    _statement.bindLong(_argIndex, utilisateur1);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Message>>() {
      @Override
      public List<Message> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfExpediteurId = CursorUtil.getColumnIndexOrThrow(_cursor, "expediteurId");
          final int _cursorIndexOfDestinataireId = CursorUtil.getColumnIndexOrThrow(_cursor, "destinataireId");
          final int _cursorIndexOfContenu = CursorUtil.getColumnIndexOrThrow(_cursor, "contenu");
          final int _cursorIndexOfHorodatage = CursorUtil.getColumnIndexOrThrow(_cursor, "horodatage");
          final List<Message> _result = new ArrayList<Message>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Message _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpExpediteurId;
            _tmpExpediteurId = _cursor.getInt(_cursorIndexOfExpediteurId);
            final int _tmpDestinataireId;
            _tmpDestinataireId = _cursor.getInt(_cursorIndexOfDestinataireId);
            final String _tmpContenu;
            if (_cursor.isNull(_cursorIndexOfContenu)) {
              _tmpContenu = null;
            } else {
              _tmpContenu = _cursor.getString(_cursorIndexOfContenu);
            }
            final String _tmpHorodatage;
            if (_cursor.isNull(_cursorIndexOfHorodatage)) {
              _tmpHorodatage = null;
            } else {
              _tmpHorodatage = _cursor.getString(_cursorIndexOfHorodatage);
            }
            _item = new Message(_tmpId,_tmpExpediteurId,_tmpDestinataireId,_tmpContenu,_tmpHorodatage);
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
