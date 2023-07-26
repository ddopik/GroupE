package com.example.ComposeExampleApp.ui.theme

import android.app.Application
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageInstaller
import android.net.Uri
import androidx.documentfile.provider.DocumentFile
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.ComposeExampleApp.InstallReceiver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {


    private val installer = getApplication<Application>().packageManager.packageInstaller
    private val resolver = getApplication<Application>().contentResolver

    companion object {
        const val PI_INSTALL_REQUEST_CODE = 12
    }

    fun setupApk(uri:Uri) {
        viewModelScope.launch {
            installCoroutine(uri)
        }
    }

    private suspend fun installCoroutine(apkUri: Uri) {
        withContext(Dispatchers.IO) {
            resolver.openInputStream(apkUri)?.use { apkStream ->
                val length =
                    DocumentFile.fromSingleUri(getApplication(), apkUri)?.length() ?: -1
                val params =
                    PackageInstaller.SessionParams(PackageInstaller.SessionParams.MODE_FULL_INSTALL)
                val sessionId = installer.createSession(params)
                val session = installer.openSession(sessionId)

                session.openWrite("session_file_name", 0, length).use { sessionStream ->
                    apkStream.copyTo(sessionStream)
                    session.fsync(sessionStream)
                }

                val intent = Intent(getApplication(), InstallReceiver::class.java)
                val pi = PendingIntent.getBroadcast(
                    getApplication(),
                    PI_INSTALL_REQUEST_CODE,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT or  PendingIntent.FLAG_MUTABLE,
                )

                session.commit(pi.intentSender)
                session.close()
            }
        }
    }
}