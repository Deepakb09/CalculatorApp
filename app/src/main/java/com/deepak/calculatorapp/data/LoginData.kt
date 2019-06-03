package com.supernet.sununigeria.data.registration.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginData(@SerializedName("data") @Expose var data: Data,
                     @SerializedName("secureData") @Expose var secureData: SecuredData){

    data class Data(@SerializedName("UserName") @Expose var UserName: String,
                    @SerializedName("UUID") @Expose var UUID: String,
                    @SerializedName("TimeStamp") @Expose var TimeStamp: String)

    data class SecuredData(@SerializedName("Password") @Expose var Password: String)
}