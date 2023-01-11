package hr.algebra.masterdetailflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import hr.algebra.masterdetailflow.data.DummyContent
import kotlinx.android.synthetic.main.activity_web_portal.*

const val ARG_ID = "ARG_ID"

class WebPortalActivity : AppCompatActivity( ) {
    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_web_portal )

        val id = intent.getIntExtra( ARG_ID, -1 )
        webPortal.webViewClient = WebViewClient( )
        webPortal.settings.javaScriptEnabled = true
        webPortal.loadUrl( DummyContent.ITEMS_MAP[id]!!.url )

    }
// 0. U activity_web_portal dodati TextView
// 1. Iz WebListActivity-a na klik otvoriti WebPortalActivity
// 2. Poziv (1) napuniti s ID-em Web Portala
// 3. U WebPortalActivity dohvatiti ID (koji je poslan u 2) i ispisati pripadnu adresu u TextView (0)
}