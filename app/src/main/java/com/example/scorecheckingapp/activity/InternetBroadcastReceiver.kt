package com.example.scorecheckingapp.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

@Suppress("DEPRECATION")
class InternetBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (connectivityReceiverListener != null) {
            connectivityReceiverListener!!.onNetworkConnectionChanged(
                isConnectedORConnecting(context)
            )
        }
    }

    private fun isConnectedORConnecting(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo =connectivityManager.activeNetworkInfo
        return (networkInfo!= null) &&networkInfo.isConnectedOrConnecting
    }

    interface ConnectivityReceiverListener{
        fun onNetworkConnectionChanged(isConnected : Boolean)
    }

    companion object{
        var connectivityReceiverListener : ConnectivityReceiverListener? = null
    }
}