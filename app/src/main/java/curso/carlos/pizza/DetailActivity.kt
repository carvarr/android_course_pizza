package curso.carlos.pizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        MobileAds.initialize(this,
            "ca-app-pub-5671424531462473~5400024009")

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        val tvName = findViewById<TextView>(R.id.pizza_detail_name)
        tvName.text = intent.extras.getString(Pizza.PIZZA_PARAM_NAME)
        val tvPrice = findViewById<TextView>(R.id.pizza_detail_price)
        tvPrice.text = "Price: ${intent.extras.getString(Pizza.PIZZA_PARAM_PRICE)} $"
        val image = findViewById<ImageView>(R.id.pizza_detail_image)
        Picasso.get().load(intent.extras.getString(Pizza.PIZZA_PARAM_IMG)).into(image)
        val confirm = findViewById<Button>(R.id.confirm)
        confirm.setOnClickListener {

            if(mInterstitialAd.isLoaded) {
                Log.d("PizzaAd", "The interstitial was loaded and is going to be displayed")
                mInterstitialAd.show()
            }else {
                Log.d("PizzaAd", "The interstitial wasn't loaded yet.")
            }

            val intent = Intent(this, PurchaseDoneActivity::class.java)
            startActivity(intent)

        }
    }
}
