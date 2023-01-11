package hr.algebra.masterdetailflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import hr.algebra.masterdetailflow.data.DummyContent
import kotlinx.android.synthetic.main.activity_web_list.*



class WebListActivity : AppCompatActivity( ) {

    val TAG = "WebListActivity"

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_web_list )

        myRecyclerView.adapter = WebPageAdapter(
                this,
                item_detail_fragment==null
        )

    }
}