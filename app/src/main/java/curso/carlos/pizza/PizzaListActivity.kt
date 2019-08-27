package curso.carlos.pizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_pizza_list.*

class PizzaListActivity : AppCompatActivity() {

    private var pizzas: ArrayList<Pizza> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_list)

        rv_pizzas.layoutManager = LinearLayoutManager(this)
        rv_pizzas.adapter = PizzaAdapter(pizzas, this)

        loadPizzas()
    }

    private fun loadPizzas() {
        pizzas.add(Pizza(
            "Pepper",
            15.10,
            "https://easychickenrecipes.com/wp-content/uploads/2019/07/bbq-chicken-pizza-6-200x200.jpg"
        ))

        pizzas.add(Pizza(
            "Chilli",
            18.10,
            "http://www.catalogodelempaque.com/documenta/imagenes/124398/Blondas-Bases-de-Pizza-1p.jpg"
        ))

        pizzas.add(Pizza(
            "Napolitana",
            13.10,
            "https://img.pystatic.com/products/483442-4951d2e8-b615-47f7-a828-c909be9e460e.jpg"
        ))

        pizzas.add(Pizza(
            "Yorkshire",
            19.10,
            "https://topwithcinnamon.com/wp-content/uploads/2018/02/Yorkshire-Pudding-Pizza-3-200x200.jpg"
        ))

        pizzas.add(Pizza(
            "Cristys",
            21.10,
            "https://www.oliviascuisine.com/wp-content/uploads/2015/03/Potato-Pizza-3-200x200.jpg"
        ))
    }
}
