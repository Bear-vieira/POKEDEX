package com.paulavieira.pokedex.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.paulavieira.pokedex.R
import com.paulavieira.pokedex.models.Pokemon

class Adapter_Pokemon(var context: Context, var list: List<Pokemon>) : BaseAdapter() {
    override fun getCount(): Int {
      return list.size
    }

    override fun getItem(p0: Int): Any {
      return ""
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        //aqui mostra os detalhes do pokemon(não ta pronta)
        // As listas precisam de adapter também
        var view = LayoutInflater.from(context).inflate(R.layout.detalhe_pokemon5, null)

        var id = view.findViewById<TextView>(R.id.id)
        id.text = list[p0].id

        var image = view.findViewById<ImageView>(R.id.foto)
        image.load(list[p0].photo)

        var description = view.findViewById<TextView>(R.id.description)
        description.text = list[p0].description

        return view
    }
}