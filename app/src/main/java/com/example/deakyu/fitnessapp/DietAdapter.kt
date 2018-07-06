package com.example.deakyu.fitnessapp

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation

open internal class DietAdapter(private val titles: Array<String>) : RecyclerView.Adapter<DietAdapter.AdapterViewHolder>() {


    class AdapterViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView)

    override fun getItemCount(): Int {
        return titles.size
    }


    override fun onCreateViewHolder(
            parent: ViewGroup, viewType: Int): DietAdapter.AdapterViewHolder {
        val cv = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_item_diet, parent, false) as CardView
        return AdapterViewHolder(cv)
    }

    override fun onBindViewHolder(holderAdapter: AdapterViewHolder, position: Int) {
        val cardView = holderAdapter.cardView
        val textView = cardView.findViewById(R.id.item_text) as TextView
        textView.text = titles[position]
        cardView.setOnClickListener (
                Navigation.createNavigateOnClickListener(R.id.next_action,null)
        )

    }


}
