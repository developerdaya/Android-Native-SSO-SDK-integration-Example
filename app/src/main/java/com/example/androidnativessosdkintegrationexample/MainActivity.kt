package com.example.androidnativessosdkintegrationexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.edugorilla.ssologin.EdugorillaSSO
import com.example.androidnativessosdkintegrationexample.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set button click listener
        binding.btnClick.setOnClickListener {
            Toast.makeText(this, "Opening SSO SDK", Toast.LENGTH_SHORT).show()

            // Initialize the EdugorillaSSO SDK
            EdugorillaSSO.initializeBaseUrlAndFileLocation(
                "https://stgtestseries.edugorilla.com/",
                resources.getIdentifier(
                    "private_key", "raw", packageName
                )
            )

            // Create user info JSON object
            val userInfo = JSONObject().apply {
                put("name", "Dayanand Khatik")
                put("email", "developerdaya@gmail.com")
                put("mobile", "7054576474")
            }

            // Encrypt URL and open WebView
            EdugorillaSSO.encryptUrlAndOpenWebView(this, userInfo.toString(), "https://stgtestseries.edugorilla.com")
        }
    }
}
