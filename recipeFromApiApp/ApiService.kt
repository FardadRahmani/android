package com.example.myrecipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    val recipeService = retrofit.create(ApiService::class.java)

interface ApiService {
    //suspend = NonBlocking/Asynchron programming, so User doesnt have
    // to wait while it is loading. It happens in BG without blocking
    // the main thread. API are slow so this makes sense!:

    @GET("categories.php")
    suspend fun getCategories() : CategoriesResponse

}