package com.deepak.calculatorapp.interfaces

import com.deepak.calculatorapp.Poko.CountryList
import com.supernet.sununigeria.data.registration.model.LoginResponse
import com.supernet.sununigeria.data.registration.request.LoginData
import io.reactivex.Observable
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.*


interface GetData {

    @GET("Cjeunes-KYC/getRestAllCountriesByStatus?status=1")
    fun getData() : Observable<ArrayList<CountryList>>

    @POST("user/authentication")
    fun createUser(@Body login: LoginData): Call<LoginResponse>

    @POST("prefix/user/{login}")
    fun login(@Path("login") postfix: String, @Body params: RequestBody): Call<ResponseBody>

    /*@GET("Cjeunes-KYC/getRestAllCountriesByStatus?status=1")
    fun getCountryData() : Call<ArrayList<CountryList>>*/

}