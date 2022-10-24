package com.example.cryptoapp.di

import android.app.Application
import com.example.cryptoapp.presentation.CoinDetailActivity
import com.example.cryptoapp.presentation.CoinDetailFragment
import com.example.cryptoapp.presentation.CoinPriceListActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, CoinViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: CoinDetailFragment)

    fun inject(activity: CoinPriceListActivity)

    @Component.Factory
    interface ApplicationFactory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }

}