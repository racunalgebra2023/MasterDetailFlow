package hr.algebra.masterdetailflow

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import hr.algebra.masterdetailflow.data.DummyContent
import kotlinx.android.synthetic.main.web_list_item.view.*

class WebPageAdapter( val context : Context, val mobitel : Boolean )
    : RecyclerView.Adapter< WebPageAdapter.WebViewHolder >( ) {

    private val onClickListner = View.OnClickListener {
       if( mobitel )
           context.startActivity(
               Intent( context, WebPortalActivity::class.java ).apply {
                   putExtra( ARG_ID, it.webId.text.toString( ).toInt( ) )
               } )
       else {
           ( context as WebListActivity )
               .supportFragmentManager
                    .beginTransaction( )
                    .replace( R.id.item_detail_fragment, WebPortalFragment( ).apply {
                        arguments = Bundle( ).apply {
                            putInt( ARG_ID, it.webId.text.toString( ).toInt( ) )
                        }
                    } )
                    .commit( )
        }

    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): WebViewHolder {
        return WebViewHolder(
            LayoutInflater
                .from( context )
                .inflate( R.layout.web_list_item, parent, false )
        )
    }

    override fun onBindViewHolder(holder: WebViewHolder, position: Int) {
        val webPage = DummyContent.ITEMS[position]
        holder.idView.text = webPage.id.toString( )
        holder.titleView.text = webPage.title
        holder.markView.text = webPage.mark.toString( )
        holder.itemView.setBackgroundColor(
            if( position%2==0 ) Color.parseColor( "#DDDDFF")
            else                Color.parseColor( "#FFDDDD")
        )

        holder.itemView.setOnClickListener( onClickListner )
    }

    override fun getItemCount(): Int {
        return DummyContent.ITEMS.size
    }

    inner class WebViewHolder( v : View ) : RecyclerView.ViewHolder( v ) {
        val idView : TextView = v.webId
        val titleView : TextView = v.webTitle
        val markView : TextView = v.webMark
    }
}