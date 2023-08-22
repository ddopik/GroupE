package com.example.ComposeExampleApp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class APIClient {
    companion object {

        private  var retrofit: Retrofit? = null


        fun getClient(): Retrofit? {

            if (retrofit != null) return retrofit

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client: OkHttpClient = OkHttpClient().newBuilder().addInterceptor(interceptor).build()


            retrofit = Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())

                .build()
            return retrofit
        }



    }
}