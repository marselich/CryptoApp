package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.CoinRepository
import javax.inject.Inject

class LoadDataUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    suspend operator fun invoke() {
        repository.loadData()
    }

}