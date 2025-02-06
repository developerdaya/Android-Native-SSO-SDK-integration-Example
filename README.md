# Android Native SSO SDK Integration

## Requirements

To integrate the Android Native SSO SDK, ensure you have the following:

1. **Private Key**:
   - Connect with the support team to obtain the `private_key`.
   - Contact details:
     - **Phone**: 0522-3514751
     - **Email**: [support@edugorilla.org](mailto\:support@edugorilla.org)
       Once you have the `private_key`, proceed with the steps below.

---

## Step 1: Add SSO SDK Dependency

1. Open the file `android/app/build.gradle`.
2. Add the following dependency in the `dependencies` block:
   ```groovy
   implementation 'com.gitlab.shashwat-vik:android-sso-sdk:1.11'
   ```

---

## Step 2: Add Private Key File

1. Create a `res/raw` directory inside your project structure: `android/app/src/main/res/raw`.
2. Place the `private_key` file obtained from the support team in this directory.

---

## Step 3: Update AndroidManifest.xml

Ensure the following permission is added in your `AndroidManifest.xml` file:

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

---

## Step 4: Implement SSO SDK in Your App

Below is a complete implementation for integrating the SSO SDK into your app:

### MainActivity.kt

```kotlin

            // Initialize the EdugorillaSSO SDK
            EdugorillaSSO.initializeBaseUrlAndFileLocation(
                "your_base_url",
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
            EdugorillaSSO.encryptUrlAndOpenWebView(
                this,
                userInfo.toString(),
                "your_redirect_page_url" 
            )
        
    
```

---

## Final Step: Verify Integration

Congratulations! Your integration is complete.

---
## This is our sample App:
https://gitlab.com/dayanand.khatik/android-sso-sdk-integration-example-kotlin

## Support

If you face any issues or have queries, feel free to reach out to our support team:

- **Phone**: 0522-3514751
- **Email**: [support@edugorilla.org](mailto\:support@edugorilla.org)

