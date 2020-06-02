package com.flowz.roomdatabasewithkotlin;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class Emp_DAO_Impl implements Emp_DAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfEmp_Entity;

  public Emp_DAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEmp_Entity = new EntityInsertionAdapter<Emp_Entity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Emp_Entity`(`emp_id`,`EMP_NAME`,`EMP_POST`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Emp_Entity value) {
        stmt.bindLong(1, value.getEmp_id());
        if (value.getEmp_name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmp_name());
        }
        if (value.getEmp_post() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmp_post());
        }
      }
    };
  }

  @Override
  public void saveEmp(Emp_Entity emp) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfEmp_Entity.insert(emp);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Emp_Entity> readEmp() {
    final String _sql = "select*from Emp_Entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfEmpId = _cursor.getColumnIndexOrThrow("emp_id");
      final int _cursorIndexOfEmpName = _cursor.getColumnIndexOrThrow("EMP_NAME");
      final int _cursorIndexOfEmpPost = _cursor.getColumnIndexOrThrow("EMP_POST");
      final List<Emp_Entity> _result = new ArrayList<Emp_Entity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Emp_Entity _item;
        _item = new Emp_Entity();
        final int _tmpEmp_id;
        _tmpEmp_id = _cursor.getInt(_cursorIndexOfEmpId);
        _item.setEmp_id(_tmpEmp_id);
        final String _tmpEmp_name;
        _tmpEmp_name = _cursor.getString(_cursorIndexOfEmpName);
        _item.setEmp_name(_tmpEmp_name);
        final String _tmpEmp_post;
        _tmpEmp_post = _cursor.getString(_cursorIndexOfEmpPost);
        _item.setEmp_post(_tmpEmp_post);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
