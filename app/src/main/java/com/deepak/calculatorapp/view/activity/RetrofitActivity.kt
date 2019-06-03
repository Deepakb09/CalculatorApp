package com.deepak.calculatorapp.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.deepak.calculatorapp.APIClient
import com.deepak.calculatorapp.Poko.CountryList
import com.deepak.calculatorapp.interfaces.GetData
import com.deepak.calculatorapp.view.adapters.CountryRecyclerAdapter
import com.supernet.sununigeria.data.registration.model.LoginResponse
import com.supernet.sununigeria.data.registration.request.LoginData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_retrofit.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitActivity : AppCompatActivity() {

    companion object {
        //val BASE_URL = "http://206.189.250.106:8080/"
        val BASE_URL = "https://enduser.sunu-nonlife.info/"
    }

    private var myAdapter: CountryRecyclerAdapter? = null
    private var myCompositeDisposable: CompositeDisposable? = null
    var countryDetails : ArrayList<CountryList> = ArrayList()
    var apiInterface = APIClient.getClient().create(GetData::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.deepak.calculatorapp.R.layout.activity_retrofit)

        myCompositeDisposable = CompositeDisposable()
        initRecyclerView()
        loadData()

        LoginData.Data(
            UserName = "user@yopmail.com", UUID = "12345",
            TimeStamp = "2019-05-20 11:22:33+5:30"
        )
        LoginData.SecuredData(Password = /*etPassword.text.toString()*/"\$2y\$12\$1506357deddc536a6e356O8YEml8kXjRZWbNS9qpUCeWzSXr9miu6")

        var loginData = LoginData(
            LoginData.Data(
                UserName = "user@yopmail.com", UUID = "12345",
                TimeStamp = "2019-05-20 11:22:33+5:30"
            ),
            LoginData.SecuredData(Password = /*etPassword.text.toString()*/"\$2y\$12\$1506357deddc536a6e356O8YEml8kXjRZWbNS9qpUCeWzSXr9miu6")
        )

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var getData: GetData = retrofit.create(GetData::class.java)

        var call = apiInterface.getData()

        var response: Call<LoginResponse> = getData.createUser(loginData)

        /*call.enqueue(object : Callback<ArrayList<CountryList>> {
            override fun onFailure(call: Call<ArrayList<CountryList>>, t: Throwable) {
                Logger.getLogger(RetrofitActivity::class.java.name).warning("Failed")
            }

            override fun onResponse(call: Call<ArrayList<CountryList>>, response: Response<ArrayList<CountryList>>) {

                Logger.getLogger(RetrofitActivity::class.java.name).warning("Hello.." + response.code())

                var result = response.body()
                Toast.makeText(applicationContext, "" + result.toString(), Toast.LENGTH_LONG).show()
            }

        })*/
    }

    fun initRecyclerView(){
        rvCountry.layoutManager = LinearLayoutManager(this)
        rvCountry.adapter = CountryRecyclerAdapter(countryDetails, this)
    }

    private fun loadData(){
        val requestInterface = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(GetData::class.java)

        //var observable = requestInterface.getCountryData() : Observable

        myCompositeDisposable?.add(requestInterface.getData()
            .observeOn(AndroidSchedulers.mainThread())      //Send the Observable’s notifications to the main UI thread//
            .subscribeOn(Schedulers.io())       //Subscribe to the Observer away from the main UI thread//
            .subscribe(this::handleResponse))
    }

    private fun handleResponse(countryList: List<CountryList>) {

        countryDetails = ArrayList(countryList)
        myAdapter = CountryRecyclerAdapter(countryDetails!!, this)
        rvCountry.adapter = myAdapter  //Set the adapter//

    }

}
