package com.example.ComposeExampleApp.contectlist.ui.main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.packageinstallerapp.R

class ContactListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)
        if (savedInstanceState == null) {

//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, ContactListFragment.newInstance(12))
//                .commitNow()
        }
    }
}