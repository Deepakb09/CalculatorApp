package com.deepak.calculatorapp

import com.deepak.calculatorapp.view.activity.RetrofitActivity
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

    companion object {

        fun getClient() : Retrofit{
            var retrofit = Retrofit.Builder()
                .baseUrl(RetrofitActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return retrofit
        }
    }
}