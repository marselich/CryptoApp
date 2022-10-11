package com.example.cryptoapp.data.mapper

import com.example.cryptoapp.data.database.CoinInfoDbModel
import com.example.cryptoapp.data.network.model.CoinInfoDto
import com.example.cryptoapp.data.network.model.CoinInfoJsonContainerDto
import com.example.cryptoapp.data.network.model.CoinNamesListDto
import com.example.cryptoapp.domain.entities.CoinInfo
import com.google.gson.Gson

class CoinMapper {

    fun mapDtoToDbModel(dto: CoinInfoDto): CoinInfoDbModel = CoinInfoDbModel(
        fromSymbol = dto.fromSymbol,
        toSymbol = dto.toSymbol,
        price = dto.price,
        lastUpdate = dto.lastUpdate,
        lastMarket = dto.lastMarket,
        highDay = dto.highDay,
        lowDay = dto.lowDay,
        imageUrl = dto.imageUrl
    )

    fun mapDbModelToEntity(model: CoinInfoDbModel): CoinInfo = CoinInfo(
        fromSymbol = model.fromSymbol,
        toSymbol = model.toSymbol,
        price = model.price,
        lastUpdate = model.lastUpdate,
        lastMarket = model.lastMarket,
        highDay = model.highDay,
        lowDay = model.lowDay,
        imageUrl = model.imageUrl
    )

    fun mapEntityToDbModel(entity: CoinInfo): CoinInfoDbModel = CoinInfoDbModel(
        fromSymbol = entity.fromSymbol,
        toSymbol = entity.toSymbol,
        price = entity.price,
        lastUpdate = entity.lastUpdate,
        lastMarket = entity.lastMarket,
        highDay = entity.highDay,
        lowDay = entity.lowDay,
        imageUrl = entity.imageUrl
    )

    fun mapJsonContainerToListCoinInfo(jsonContainer: CoinInfoJsonContainerDto): List<CoinInfoDto> {
        val result = mutableListOf<CoinInfoDto>()
        val jsonObject = jsonContainer.json ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinInfoDto::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    fun mapNamesListToString(namesListDto: CoinNamesListDto): String {
        return namesListDto.names?.map {
            it.coinName?.name
        }?.joinToString(",") ?: ""
    }


}