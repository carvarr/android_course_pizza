package curso.carlos.pizza

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pizza_list_item.view.*

class PizzaAdapter(val items: ArrayList<Pizza>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.pizza_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = items[position].name
        holder.tvPrice.text = items[position].price.toString()
        holder.imageUrl = items[position].image
        Picasso.get().load(items[position].image).into(holder.image)
    }
}

class ViewHolder : RecyclerView.ViewHolder, View.OnClickListener {

    // Holds the TextView that will add each animal to
    val tvName: TextView
    val tvPrice: TextView
    val image: ImageView
    val buyBtn: Button

    var imageUrl: String = ""

    constructor(view: View) : super(view) {
        tvName = view.pizza_title
        tvPrice = view.pizza_price
        image = view.pizza_icon
        buyBtn = view.buy

        buyBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when(v?.id) {
            R.id.buy -> {
                val intent = Intent(v.context, DetailActivity::class.java)
                intent.putExtra(Pizza.PIZZA_PARAM_NAME, tvName.text)
                intent.putExtra(Pizza.PIZZA_PARAM_PRICE, tvPrice.text)
                intent.putExtra(Pizza.PIZZA_PARAM_IMG, imageUrl)
                v.context.startActivity(intent)
            }
        }

    }
}