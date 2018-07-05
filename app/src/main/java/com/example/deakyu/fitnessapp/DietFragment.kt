package com.example.deakyu.fitnessapp


import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


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

    }

}


