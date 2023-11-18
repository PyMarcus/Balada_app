package br.com.ifmg.balada.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context: Context): SQLiteOpenHelper(context, DB_NAME, null, VERSION) {

    companion object{
        private const val DB_NAME: String = "balada_db"
        private const val VERSION: Int = 1
    }

    override fun onCreate(p0: SQLiteDatabase) {
        p0.execSQL("CREATE TABLE products(id integer primary key autoincrement, name text, price real, date text, entry integer)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}