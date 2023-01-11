package hr.algebra.masterdetailflow.data

object DummyContent {

    val ITEMS : MutableList< WebData > = ArrayList( )
    val ITEMS_MAP : MutableMap< Int, WebData > = HashMap( )

    init {
        addWebPortal( WebData( 0, "https://www.jutarnji.hr/", "Jutarnji list", 5 ))
        addWebPortal( WebData( 4, "https://www.vecernji.hr/", "Večernji", 6 ) )
        addWebPortal( WebData( 2, "https://www.index.hr/", "Index", 2 ) )
        addWebPortal( WebData( 3, "https://www.bitno.net/", "Bitno.NET", 8 ) )
        addWebPortal( WebData( 1, "https://www.dnevnik.hr/", "Dnevnik.hr", 7 ) )
    }

    private fun addWebPortal( item : WebData ) {
        ITEMS.add( item )
        ITEMS_MAP[ item.id ] = item
    }

    data class WebData( val id:Int, val url:String, val title:String, val mark:Int )
}