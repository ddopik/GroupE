package com.example.ComposeExampleApp.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.raywenderlich.android.composableCookBook.RecipeList
import com.raywenderlich.android.composableCookBook.defaultRecipes


class MainActivity : ComponentActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>


    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight()
                    .clickable {
                    }) {
                    RecipeList(defaultRecipes)
                }
            }

                 mainActivityViewModel.getUserInfo(this)

        }

    }
}



