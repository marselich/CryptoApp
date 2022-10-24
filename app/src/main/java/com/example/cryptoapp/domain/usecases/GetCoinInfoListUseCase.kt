package com.example.cryptoapp.domain.usecases

import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.CoinRepository
import com.example.cryptoapp.domain.entities.CoinInfo
import javax.inject.Inject

class GetCoinInfoListUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): LiveData<List<CoinInfo>> {
        return repository.getCoinInfoList()
    }

}