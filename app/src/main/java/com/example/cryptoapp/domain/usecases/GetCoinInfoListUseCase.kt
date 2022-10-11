package com.example.cryptoapp.domain.usecases

import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.CoinRepository
import com.example.cryptoapp.domain.entities.CoinInfo

class GetCoinInfoListUseCase(
    private val repository: CoinRepository
) {

    operator fun invoke(): LiveData<List<CoinInfo>> {
        return repository.getCoinInfoList()
    }

}