package com.example.wishlistapp

import android.app.Application


//In Android we have the Application Class that is useful for initiating
//global states that need to be available throughout the app
//This class is instantiated before any other class
class WishListApp: Application(){
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }

}