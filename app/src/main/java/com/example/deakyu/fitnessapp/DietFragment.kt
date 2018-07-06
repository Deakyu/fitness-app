package com.example.deakyu.fitnessapp


import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController


class DietFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_diet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

                view.findViewById<FloatingActionButton>(R.id.fab_diet)?.setOnClickListener{
                   DietActivity.createAlertDialog(getString(R.string.add_diet),context!!)

               }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview_diet)

        val titles = List<String>(5){"Item"}

        val adapter = DietAdapter(titles.toTypedArray())

        recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager


    }
}