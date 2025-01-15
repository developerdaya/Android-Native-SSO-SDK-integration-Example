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
            // replace_your_base_url and private_key
            EdugorillaSSO.initializeBaseUrlAndFileLocation(
                "https://stgtestseries.edugorilla.com/",
                resources.getIdentifier(
                    "private_key", "raw", packageName
                )
            )

            // Create user info JSON object
            val userInfo = JSONObject().apply {
                put("name", "replace_your_name")
                put("email", "replace_your_email")
                put("mobile", "replace_your_mobile")
            }

            // Encrypt URL and open WebView
            // replace_your_redirect_url
            EdugorillaSSO.encryptUrlAndOpenWebView(this, userInfo.toString(), "https://stgtestseries.edugorilla.com")
        }
    }
}
