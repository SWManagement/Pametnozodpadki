package com.swmanagement2020.pametnozodpadki.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABESE_NAME = "odpadkiDB.db";

    private static final String CreateOdpadkiTable =
            "CREATE TABLE " + odpadkiDB.Odpadki.TABLE_NAME + " (" +
                    odpadkiDB.Odpadki.COL_NAME_ID    + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    odpadkiDB.Odpadki.COL_NAME_NAME + " VARCHAR(20) NOT NULL," +
                    odpadkiDB.Odpadki.COL_NAME_KODA + " VARCHAR(20)," +
                    odpadkiDB.Odpadki.COL_NAME_KANTA + " INTEGER," +
                    "FOREIGN KEY (kanta) REFERENCES " + odpadkiDB.Kante.TABLE_NAME + "(_ID));";

    private static final String CreateKanteTable =
            "CREATE TABLE " + odpadkiDB.Kante.TABLE_NAME + " (" +
                    odpadkiDB.Kante.COL_NAME_ID    + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    odpadkiDB.Kante.COL_NAME_NAME + " VARCHAR(20) NOT NULL," +
                    odpadkiDB.Kante.COL_NAME_BARVA + " VARCHAR(20) NOT NULL);";

    private static final String DeleteOdpadkiTable =
            "DROP TABLE IF EXISTS " + odpadkiDB.Odpadki.TABLE_NAME;

    private static final String DeleteKanteTable =
            "DROP TABLE IF EXISTS " + odpadkiDB.Kante.TABLE_NAME;


    public dbHelper(Context context) {
        super(context, DATABESE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateOdpadkiTable);
        db.execSQL(CreateKanteTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DeleteOdpadkiTable);
        db.execSQL(DeleteKanteTable);
        onCreate(db);
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DeleteOdpadkiTable);
        db.execSQL(DeleteKanteTable);
        onCreate(db);
    }
}
