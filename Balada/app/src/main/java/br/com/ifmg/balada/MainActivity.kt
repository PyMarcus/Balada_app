package br.com.ifmg.balada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import br.com.ifmg.balada.dao.ProductDAO
import br.com.ifmg.balada.databinding.ActivityMainBinding
import br.com.ifmg.balada.models.Product
import br.com.ifmg.balada.repository.Database

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var binding: ActivityMainBinding
    lateinit var database: Database
    lateinit var dao: ProductDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = Database(baseContext)
        dao = ProductDAO(baseContext)
        setClickEvents()
    }

    private fun setClickEvents(){
        binding.register.setOnClickListener(this)
        binding.list.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            binding.register.id -> register()
            binding.list.id -> list()
        }
    }

    private fun register(){
        val name = binding.product.text.toString()
        val price = binding.value.text.toString().toDouble()
        val date = binding.date.text.toString()
        val entry = if (binding.entry.isChecked) 1 else 0

        val product = Product(name, price, date, entry)
        dao.save(product)
    }

    private fun list(){
        val listIntent = Intent(baseContext, ListActivity::class.java)
        startActivity(listIntent)
    }
}