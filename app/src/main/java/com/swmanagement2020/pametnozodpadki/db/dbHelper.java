package com.swmanagement2020.pametnozodpadki.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {


    int DATABASE_VERSION = 1;

    private static final String CreateOdpadkitTable =
            "CREATE TABLE " + odpadkiDB.Odpadki.TABLE_NAME + " (" +
                    odpadkiDB.Odpadki.COL_NAME_ID    + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    odpadkiDB.Odpadki.COL_NAME_NAME + " VARCHAR(20) NOT NULL," +
                    odpadkiDB.Odpadki.COL_NAME_KODA + " VARCHAR(20)," +
                    odpadkiDB.Odpadki.COL_NAME_KANTA + " INTEGER," +
                    "FOREIGN KEY (kanta) REFERENCES " + odpadkiDB.Kante.TABLE_NAME + "(_OD));";

    private static final String CreateKanteTable =
            "CREATE TABLE " + odpadkiDB.Kante.TABLE_NAME + " (" +
                    odpadkiDB.Kante.COL_NAME_ID    + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    odpadkiDB.Kante.COL_NAME_NAME + " VARCHAR(20) NOT NULL," +
                    odpadkiDB.Kante.COL_NAME_BARVA + " VARCHAR(20) NOT NULL);";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateOdpadkitTable);
        db.execSQL(CreateKanteTable);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
