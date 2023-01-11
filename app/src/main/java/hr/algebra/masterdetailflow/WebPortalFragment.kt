package hr.algebra.masterdetailflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import hr.algebra.masterdetailflow.data.DummyContent
import kotlinx.android.synthetic.main.activity_web_portal.*

class WebPortalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate( R.layout.fragment_web_portal, container, false )

        arguments?.let {
            if( it.containsKey( ARG_ID ) ) {
                var webData = DummyContent.ITEMS_MAP[it.getInt(ARG_ID)]
                webData?.let {
                    val webView = rootView.findViewById< WebView >( R.id.webPortal )
                    webView.webViewClient = WebViewClient( )
                    webView.settings.javaScriptEnabled = true
                    webView.loadUrl( it.url )
                }
            }
        }


        return rootView
    }

}