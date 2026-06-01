package com.pdm0126.app.data.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


object KtorClient {

    val BASE_URL = "https://jsonplaceholder.typicode.com"

    val client = HttpClient(OkHttp) {

        //configuracion de json
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }

        //config por defecto
        defaultRequest {
            url(BASE_URL)
        }

    }

}