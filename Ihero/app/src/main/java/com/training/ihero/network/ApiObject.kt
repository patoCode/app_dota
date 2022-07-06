package com.training.ihero.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val url = "http://10.240.2.110:1234/"

object ApiObject {
    fun ApiAdapter(): CatalogApi {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val retrofit = Retrofit.Builder().baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit.create(CatalogApi::class.java)
    }
}