package com.swmanagement2020.pametnozodpadki.db;

import android.provider.BaseColumns;

// To je schema DB
public final class odpadkiDB {
//    private constructor
    private odpadkiDB(){}
//    Table contents -> definiranje kolon DB
    public static class Odpadki implements BaseColumns{
        public static final String TABLE_NAME        = "odpadki";
        public static final String COL_NAME_ID       = "oid";
        public static final String COL_NAME_NAME    = "odpadek";
        public static final String COL_NAME_KODA    = "koda";
        public static final String COL_NAME_KANTA    = "kanta";
}
    public static class Kante implements BaseColumns{
        public static final String TABLE_NAME      = "kante";
        public static final String COL_NAME_ID     = "kid";
        public static final String COL_NAME_NAME  = "kanta";
        public static final String COL_NAME_BARVA = "barva";
    }

}
