package curso.carlos.pizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import com.google.android.vending.licensing.AESObfuscator
import com.google.android.vending.licensing.LicenseChecker
import com.google.android.vending.licensing.LicenseCheckerCallback
import com.google.android.vending.licensing.ServerManagedPolicy

class MainActivity : AppCompatActivity(), LicenseCheckerCallback {

    private lateinit var licenseChecker: LicenseChecker
    private var allow: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val deviceId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        val policy = ServerManagedPolicy(this, AESObfuscator(SALT, packageName, deviceId))
        licenseChecker = LicenseChecker(this, policy, PUBLIC_LICENSE_KEY)

    }

    fun onCheckLicense(view: View) {
        licenseChecker.checkAccess(this)
    }

    fun access(view: View) {
        if (allow) {
            val intent = Intent(this, PizzaListActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Licencia no valida", Toast.LENGTH_LONG).show()
        }
    }

    override fun allow(reason: Int) {
        allow = true
        Toast.makeText(this, "Licencia correcta: $reason", Toast.LENGTH_LONG).show()
    }

    override fun dontAllow(reason: Int) {
        allow = false
        Toast.makeText(this, "Licencia no valida: $reason", Toast.LENGTH_LONG).show()
    }

    override fun applicationError(errorCode: Int) {
        Toast.makeText(this, "Error al comprobar licencia: $errorCode", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        licenseChecker.onDestroy()
    }

    companion object {
        private val PUBLIC_LICENSE_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAriHNoGbRwp72GvV27WPwsvjpk7Et99CaqxgJpKq/he+hOUGoSlBR/GPcdMa14xMgYllo1dBd9mCcnaKQd9FkRR6fVriIaoaKa82YMKmWgAmakQjmLQGuURMPVAjQVR91Xti56GEFdewUbRYr7e2ZeycGY+92/mruQXxGo3Cj/54VFaTosXMO4gQxbW8PiPzdcrJtlK8KgZfcL25fyhhujSSLJdi6TVq9194uye6latJvKoPcCWQPYoTHvdFL2+J4BdDQd/DO/HEl2SLlfnNKMXaovAtPgw9V5jPD+nHcDjUequv+Ww5BCtc5uhhXOqeGtOgu9U35s3Pu08mbzmoLMwIDAQAB"
        private val SALT = byteArrayOf(-46, 65, 30,-128,-103, -57, 74,-64, 51, 88,-95,-45, 77,-117,-36,-113,-11, 32,-64, 89)
    }


}
