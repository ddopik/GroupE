package com.example.ComposeExampleApp.main.data

import com.example.ComposeExampleApp.main.model.UserData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query


interface MainActivityRemoteData {

    @GET("users/2")
    suspend fun getRemoteData(@Path("ke1") key:String,@Query("id") id: String,@Query("username") username: String): Response<UserData?>?

    @POST("users/2")
    fun getRemoteData2(@Body userData:UserData): Call<String?>?


}