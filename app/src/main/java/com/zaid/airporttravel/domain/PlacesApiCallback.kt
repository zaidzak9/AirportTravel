package com.zaid.airporttravel.domain

import com.zaid.airporttravel.model.PlacesApiResponse
import retrofit2.Response

/**
 * Created by Zaid Zakir on 9/29/2019.
 */
interface PlacesApiCallback {

    fun onSuccess(response: Response<PlacesApiResponse>)

    fun onFailure()

    fun onLoading()
}