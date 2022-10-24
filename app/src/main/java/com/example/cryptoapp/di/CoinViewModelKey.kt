package com.example.cryptoapp.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class CoinViewModelKey(val key: KClass<out ViewModel>)
