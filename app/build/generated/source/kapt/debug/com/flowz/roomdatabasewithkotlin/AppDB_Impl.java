package com.flowz.roomdatabasewithkotlin;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class AppDB_Impl extends AppDB {
  private volatile Emp_DAO _empDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Emp_Entity` (`emp_id` INTEGER NOT NULL, `EMP_NAME` TEXT NOT NULL, `EMP_POST` TEXT NOT NULL, PRIMARY KEY(`emp_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"2a3e0f8737d4cb6800fb85f6c93723fa\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Emp_Entity`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
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
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsEmpEntity = new HashMap<String, TableInfo.Column>(3);
        _columnsEmpEntity.put("emp_id", new TableInfo.Column("emp_id", "INTEGER", true, 1));
        _columnsEmpEntity.put("EMP_NAME", new TableInfo.Column("EMP_NAME", "TEXT", true, 0));
        _columnsEmpEntity.put("EMP_POST", new TableInfo.Column("EMP_POST", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEmpEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEmpEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEmpEntity = new TableInfo("Emp_Entity", _columnsEmpEntity, _foreignKeysEmpEntity, _indicesEmpEntity);
        final TableInfo _existingEmpEntity = TableInfo.read(_db, "Emp_Entity");
        if (! _infoEmpEntity.equals(_existingEmpEntity)) {
          throw new IllegalStateException("Migration didn't properly handle Emp_Entity(com.flowz.roomdatabasewithkotlin.Emp_Entity).\n"
                  + " Expected:\n" + _infoEmpEntity + "\n"
                  + " Found:\n" + _existingEmpEntity);
        }
      }
    }, "2a3e0f8737d4cb6800fb85f6c93723fa", "84674e114a2e3ec8742b7b1eacbd3f30");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Emp_Entity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Emp_Entity`");
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
  public Emp_DAO empDAO() {
    if (_empDAO != null) {
      return _empDAO;
    } else {
      synchronized(this) {
        if(_empDAO == null) {
          _empDAO = new Emp_DAO_Impl(this);
        }
        return _empDAO;
      }
    }
  }
}
