package com.supernet.sununigeria.data.registration.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(@SerializedName("status") @Expose var status: Int ,
                         @SerializedName("message") @Expose var message: String,
                         @SerializedName("result") @Expose var result: Result
) {

    data class Result(@SerializedName("HostUUID") @Expose var hostUUID: String,
    @SerializedName("HostTimeStamp") @Expose var hostTimeStamp: String,
    @SerializedName("Code") @Expose var code: String,
    @SerializedName("Token") @Expose var token: String,
    @SerializedName("ExpiryTime") @Expose var expiryTime: String)
}