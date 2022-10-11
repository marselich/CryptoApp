package com.example.cryptoapp.domain.usecases

import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.CoinRepository
import com.example.cryptoapp.domain.entities.CoinInfo

class GetCoinInfoUseCase(
    private val repository: CoinRepository
) {

    operator fun invoke(fromSymbol: String): LiveData<CoinInfo> {
        return repository.getCoinInfo(fromSymbol)
    }

}