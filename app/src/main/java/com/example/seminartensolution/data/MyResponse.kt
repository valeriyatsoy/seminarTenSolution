package com.example.seminartensolution.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class MyResponse {
    @SerialName("code")
    val code: Int = 0
    @SerialName("status")
    val status: String = ""
    @SerialName("message")
    val message: String = ""
}