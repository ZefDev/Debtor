package com.mandriklab.Debtor.Model;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

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
                        database.execSQL("INSERT INTO 'debtors' (idDebtor, fullName, number,address) VALUES (1,'Юрий Гончарик','+375293083345','ул.Залупкина д 5')");
                        database.execSQL("INSERT INTO 'operation' (idOperation, idDebtorOperation, typeOperation,summa,dateOperation,lastDate) VALUES (1,1,0,11234.65,1564617600000,1565616619000)");
                        database.execSQL("INSERT INTO 'operation' (idOperation, idDebtorOperation, typeOperation,summa,dateOperation,lastDate) VALUES (2,1,1,-17567,1565271019000,1565616619000)");
                        database.execSQL("INSERT INTO 'operation' (idOperation, idDebtorOperation, typeOperation,summa,dateOperation,lastDate) VALUES (3,1,0,15678.32,1564617600000,1565616619000)");
                        database.execSQL("INSERT INTO 'operation' (idOperation, idDebtorOperation, typeOperation,summa,dateOperation,lastDate) VALUES (4,1,1,-23456.54,1565271019000,1565616619000)");
                        database.execSQL("INSERT INTO 'operation' (idOperation, idDebtorOperation, typeOperation,summa,dateOperation,lastDate) VALUES (5,1,0,12334.05,1564617600000,1565616619000)");

                        database.setTransactionSuccessful();
                    } finally {
                        database.endTransaction();
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