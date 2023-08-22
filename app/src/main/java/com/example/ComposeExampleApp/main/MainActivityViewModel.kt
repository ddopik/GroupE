package com.example.ComposeExampleApp.main

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.ComposeExampleApp.main.data.MainActivityRemoteData
import com.example.ComposeExampleApp.main.model.UserData
import com.example.ComposeExampleApp.network.APIClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    var temoCal: Call<UserData?>? = null

    private val installer = getApplication<Application>().packageManager.packageInstaller
    private val resolver = getApplication<Application>().contentResolver


    fun getUserInfo(context: Context) {


        val mainActivityRemoteData = APIClient.getClient()?.create(MainActivityRemoteData::class.java)

        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    val response = mainActivityRemoteData?.getRemoteData("key","2","admin")
                    val firstName = response?.body()?.data?.first_name
                    withContext(Dispatchers.Main) {
                        if (response?.isSuccessful == true) {
                            Toast.makeText(context, firstName, Toast.LENGTH_LONG).show()
                        }
                        if (response?.code() == 500) {
                            Log.e("MainActivityViewModel", "getUserInfo ---> ")

                        }
                        if (response?.code() == 999) {
                            Log.e("MainActivityViewModel", "Not updated ")
                        }
                    }
                }
            } catch (error: Exception) {
                Log.e("MainActivityViewModel", "getUserInfo ---> " + error.message)
            }

        }


    }


}
