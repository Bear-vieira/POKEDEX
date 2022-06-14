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
import com.paulavieira.pokedex.models.Elements

class Adapter_Grass(var context: Context, var list: List<Elements>) : BaseAdapter() {
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

        var view = LayoutInflater.from(context).inflate(R.layout.item_detalhe_grass, null)

        var nome= view.findViewById<TextView>(R.id.nome)
        nome.text = list[p0].name

        var image = view.findViewById<ImageView>(R.id.imagem)
        image.load(list[p0].photo)

        var tipo = view.findViewById<TextView>(R.id.tipo)
        tipo.text = list[p0].type

        var hab1 = view.findViewById<TextView>(R.id.habilidade1)
        hab1.text = list[p0].ability1

        var hab2 = view.findViewById<TextView>(R.id.habilidade2)
        hab2.text = list[p0].ability2

        return view
    }
}