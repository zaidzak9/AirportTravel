package com.zaid.airporttravel.domain

import com.zaid.airporttravel.model.PlacesApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Zaid Zakir on 9/29/2019.
 */
class PlacesApiDomain {

    val placesApiRepository:PlacesApiRepository? = null

    fun getBitcoinChartData(placesApiCallback: PlacesApiCallback,map: Map<String,String>) {

        placesApiCallback.onLoading()

        placesApiRepository?.getPlacesData(map)?.enqueue(object : Callback<PlacesApiResponse>{
            override fun onFailure(call: Call<PlacesApiResponse>, t: Throwable) {
                placesApiCallback.onFailure()
            }

            override fun onResponse(call: Call<PlacesApiResponse>, response: Response<PlacesApiResponse>) {

               if (response.isSuccessful) {
                   placesApiCallback.onSuccess(response)
               }else{
                   placesApiCallback.onFailure()
               }

            }

        })

    }
}
