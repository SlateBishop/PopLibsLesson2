package ru.gb.makulin.poplibslesson2.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import androidx.core.content.getSystemService
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject

class NetworkStatus(context: Context) {

    private val connectivityManager = context.getSystemService<ConnectivityManager>()
    private val request = NetworkRequest.Builder().build()
    private val networkStatusSubject = BehaviorSubject.create<Boolean>()

    init {
        networkStatusSubject.onNext(false)

        connectivityManager?.registerNetworkCallback(request, object : ConnectivityManager
        .NetworkCallback() {
            override fun onAvailable(network: Network) {
                networkStatusSubject.onNext(true)
            }

            override fun onUnavailable() {
                networkStatusSubject.onNext(false)
            }

            override fun onLost(network: Network) {
                networkStatusSubject.onNext(false)
            }
        })
    }

    fun isOnline(): Single<Boolean> = networkStatusSubject.first(false)

}