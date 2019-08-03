package com.mandriklab.Debtor.Model;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import com.mandriklab.Debtor.Model.DAO.DebtorsDao;
import com.mandriklab.Debtor.Model.DAO.OperationDao;
import com.mandriklab.Debtor.Model.Entity.Debtors;
import com.mandriklab.Debtor.Model.Entity.Operation;


@Database(entities = {Debtors.class, Operation.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase = null;

    /**
     * from developers android, made my own singleton
     *
     * @param context
     * @return
     */
    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            RoomDatabase.Callback rdc = new RoomDatabase.Callback() {
                public void onCreate (SupportSQLiteDatabase database) {
                    database.beginTransaction();
                    try {
                      //  database.execSQL("INSERT INTO 'site' (ids, nameS, address,isShowS) VALUES (0,'Sectret','Secret',0)");
                       // database.execSQL("INSERT INTO 'groupsites' (id, name, isShow,isDelete) VALUES (0,'All',0,0)");
                        //database.setTransactionSuccessful();
                    } finally {
                        //database.endTransaction();
                    }
                }
                public void onOpen (SupportSQLiteDatabase db) {
                    // do something every time database is open
                }
            };
            appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "database-name").addCallback(rdc).build();

        }
        return appDatabase;
    }

    public abstract DebtorsDao debtorsDao();
    public abstract OperationDao operationDao();
}