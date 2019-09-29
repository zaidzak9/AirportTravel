package com.zaid.airporttravel.domain

import com.zaid.airporttravel.model.PlacesApiResponse
import com.zaid.airporttravel.utility.retrofit.GooglePlacesApi
import com.zaid.airporttravel.utility.retrofit.RetrofitClient
import retrofit2.Call

/**
 * Created by Zaid Zakir on 9/29/2019.
 */
class PlacesApiRepository {

    private var retrofit = RetrofitClient.instance
    private var googlePlacesApi: GooglePlacesApi = retrofit
    fun getPlacesData(map: Map<String,String>): Call<PlacesApiResponse>? {
        return googlePlacesApi.getPlacesData(map)
    }
}