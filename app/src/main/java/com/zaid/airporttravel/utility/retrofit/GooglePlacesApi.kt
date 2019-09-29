package com.zaid.airporttravel.utility.retrofit

import com.zaid.airporttravel.model.PlacesApiResponse
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by Zaid Zakir on 9/29/2019.
 */

interface GooglePlacesApi {

    @FormUrlEncoded
    @GET("place/findplacefromtext/json?")
    fun getPlacesData(@QueryMap queryMap: Map<String,String>):Call<PlacesApiResponse>
}