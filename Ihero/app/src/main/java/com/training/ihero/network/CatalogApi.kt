package com.training.ihero.network

import com.training.ihero.response.ListHeroResponse
import retrofit2.Response
import retrofit2.http.*

interface CatalogApi {
    @GET("hero/list")
    suspend fun listHero(): Response<ListHeroResponse>

//
//    @POST("api/cancion")
//    suspend fun saveCancion(@Body cancion: CancionData): Response<Void>
//    //suspend esta muy relacionada con las coroutine (2  procesos en ejecucion paralelamente)
//    //suspend esta funcion se va a ejecutar en un hilo separado
//
//    @PUT("api/cancion/{id}")
//    suspend fun updateCancion(@Path("id") id: Int?, @Body cancion: CancionData): Response<Void>
//
//    @DELETE("api/cancion/{id}")
//    suspend fun deleteCancion(@Path("id") id: Int?): Response<Void>
}