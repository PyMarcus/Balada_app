package br.com.ifmg.balada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.ifmg.balada.dao.ProductDAO
import br.com.ifmg.balada.databinding.ActivityListBinding
import br.com.ifmg.balada.repository.Database

class ListActivity : AppCompatActivity() {

    lateinit var binding: ActivityListBinding
    lateinit var productDAO: ProductDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        productDAO = ProductDAO(baseContext)
        fillData()
    }

    private fun fillData(){
        binding.amount.text = "R$ ${productDAO.getAmount()}"
        binding.spent.text = "R$ ${productDAO.getSpent()}"
        binding.total.text = "R$ ${productDAO.getTotal()}"
    }
}