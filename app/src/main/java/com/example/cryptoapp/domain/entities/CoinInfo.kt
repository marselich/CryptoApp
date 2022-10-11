package com.example.cryptoapp.domain.entities

data class CoinInfo(
    val fromSymbol:String,
    val toSymbol:String?,
    val price:String?,
    val lastUpdate:Long?,
    val lastMarket:String?,
    val highDay:String?,
    val lowDay:String?,
    val imageUrl:String?
)
