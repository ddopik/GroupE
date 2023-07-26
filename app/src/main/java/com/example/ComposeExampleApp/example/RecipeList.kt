package com.raywenderlich.android.composableCookBook


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
@Preview
fun RecipeList
            (recipes: List<Recipe> = defaultRecipes) {
    LazyColumn {
        items(recipes.size) {
           RecipeCard(recipes[it], Modifier.padding(16.dp))
        }
    }
}

