package com.example.dummycookies

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.dummycookies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var webView: WebView? = null
    private val baseUrl = "https://pmi-abelkhede.qak8s.vibrenthealth.com"
    private var url = baseUrl+"/formTest"
    private val cookieManager = CookieManager.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        webView = binding.webView

        applyWebViewSettings()
        setCookies()
    }


    override fun onPause() {
        val ckAll = cookieManager.getCookie(baseUrl)
        Log.d("cookie", ckAll)
        super.onPause()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun applyWebViewSettings() {
        webView?.webChromeClient = WebChromeClient()
        webView?.webViewClient = WebViewClient()
        val settings = webView?.settings
        settings?.javaScriptEnabled = true
        settings?.javaScriptCanOpenWindowsAutomatically = true
        settings?.useWideViewPort = true
        settings?.loadWithOverviewMode = true
        settings?.builtInZoomControls = true
        settings?.setSupportZoom(true)
        settings?.allowFileAccessFromFileURLs = true
        settings?.useWideViewPort = true
        settings?.domStorageEnabled = true
        settings?.userAgentString = System.getProperty("http.agent")
    }



    private fun setCookies() {
//
//        val accessToken = ""
//        val cookieString = "token=$accessToken;Secure;path=/;SameSite=Lax;"
//        val cookieList = cookieString.split(";")
//
//
//        cookieManager.removeAllCookie()
//        cookieManager.setAcceptCookie(true)
//        cookieManager.setAcceptThirdPartyCookies(webView, true)
//        cookieList.forEach { cookie ->
//            cookieManager.setCookie(baseUrl, cookie)
//        }

//        webView?.loadUrl("https://stackoverflow.com/questions/6552160/prevent-webview-from-displaying-web-page-not-available")

        //load url
        webView?.loadUrl(url)

        val accessToken = ""
//        val cookieString = "name=amar;token=$accessToken;Secure;path=/;SameSite=Lax;"
        val cookieString = ""
        val cookieList = cookieString.split(";")


        cookieManager.removeAllCookie()
        cookieManager.setAcceptCookie(true)
        cookieManager.setAcceptThirdPartyCookies(webView, true)
        cookieList.forEach { cookie ->
            cookieManager.setCookie(baseUrl, cookie)
        }
    }


}