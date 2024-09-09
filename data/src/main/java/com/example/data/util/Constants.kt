package com.example.data.util


object HttpClient {
    const val BASE_URL = "https://www.jsonkeeper.com/"
    const val CONNECT_TIMEOUT = 10L
    const val READ_TIMEOUT = 10L
    const val WRITE_TIMEOUT = 10L
    const val CONNECTION_TIME_OUT_MLS = CONNECT_TIMEOUT * 1000L
}