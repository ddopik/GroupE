package com.example.ComposeExampleApp

import android.app.Activity
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity(), ConnectivityReceiver.ConnectivityReceiverListener {

    companion object {
        const val result_code_model = 122
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpBroadcastReceiver()
        setContent {
            mainView(this)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun mainView(activity: Activity) {
        var email by remember { mutableStateOf("") }
        MaterialTheme {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight()
                    .padding(12.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedTextField(
                    value = email,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    onValueChange = {
                        email = it
                    },
                    shape = RoundedCornerShape(30.dp),
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(50.dp))
                Button(onClick = {


                }) {
                    Text(text = "Submit")
                }

                Button(onClick = {

                    startService()
                }) {
                    Text(text = "Start Service")
                }

                Button(onClick = {
                    stopService()

                }) {
                    Text(text = "Stop Service")
                }
                checkNotificationPermeation(activity = activity) {
                    startService()
                }
            }
        }
    }


    private fun setUpBroadcastReceiver() {
        registerReceiver(ConnectivityReceiver(this), IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }


    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        showNetworkMessage(isConnected)
    }

    override fun onResume() {
        super.onResume()
    }

    private fun showNetworkMessage(isConnected: Boolean) {
        if (!isConnected) {
            Toast.makeText(this, "Not Connected", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "isConnected", Toast.LENGTH_LONG).show()
        }
    }

    fun startService() {
        val serviceIntent = Intent(this, ForegroundService::class.java)

        //Start service:
        //Start service:
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


            serviceIntent.putExtra("inputExtra", "Foreground Service Example in Android")
            startForegroundService(Intent(this, ForegroundService::class.java))


        } else {

            serviceIntent.putExtra("inputExtra", "Foreground Service Example in Android")
            startService(serviceIntent)


        }
    }

    private fun stopService() {
        val serviceIntent = Intent(this, ForegroundService::class.java)
        stopService(serviceIntent)
    }

}



