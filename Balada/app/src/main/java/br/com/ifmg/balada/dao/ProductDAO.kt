package br.com.ifmg.balada.dao

import android.content.ContentValues
import android.content.Context
import br.com.ifmg.balada.models.Product
import br.com.ifmg.balada.repository.Database

class ProductDAO(var context: Context) {
    var db: Database = Database(context)

    fun save(product: Product){
        val content = ContentValues()
        content.put("name", product.name)
        content.put("price", product.price)
        content.put("date", product.date)
        content.put("entry", product.entry)

        val transaction = db.writableDatabase
        transaction.insert("products", null, content)
    }

    fun getSpent(): String{
        val transaction = db.readableDatabase
        val cursor = transaction.rawQuery("SELECT sum(price) FROM products WHERE entry = 0", null)

        var spent = "0.00"

        try {
            if (cursor.moveToFirst()) {
                spent = cursor.getString(0) ?: "0.00"
            }
        } finally {
            cursor.close()
        }

        return spent
    }

    fun getTotal(): String{
        return (getAmount().toDouble() - getSpent().toDouble()).toString()
    }

    fun getAmount(): String{
        val transaction = db.readableDatabase
        val cursor = transaction.rawQuery("SELECT sum(price) FROM products WHERE entry = 1", null)

        var spent = "0.00"

        try {
            if (cursor.moveToFirst()) {
                spent = cursor.getString(0) ?: "0.00"
            }
        } finally {
            cursor.close()
        }

        return spent
    }

}