package com.zaid.airporttravel.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zaid.airporttravel.R

/**
 * Created by Zaid Zakir on 9/28/2019.
 */

class TravelAgencyFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_travel_agencies,container,false);
    }
}