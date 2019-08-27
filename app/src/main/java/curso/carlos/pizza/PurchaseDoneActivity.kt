package curso.carlos.pizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.squareup.picasso.Picasso

class PurchaseDoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase_done)

        val image = findViewById<ImageView>(R.id.confirmed)
        Picasso.get().load("https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX31422333.jpg").into(image)

        val btn = findViewById<Button>(R.id.goIndex)
        btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
