package com.raywenderlich.android.composableCookBook

import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme


import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp




@Composable
@Preview
fun RecipeCard(recipe: Recipe= defaultRecipes[0], modifier: Modifier?= Modifier.padding(16.dp)) {
  Surface(shape = RoundedCornerShape(8.dp), shadowElevation = 8.dp, modifier = modifier!!) {
    Column(modifier = Modifier.fillMaxWidth()) {
      Image(painterResource(recipe?.imageResource!!), "",contentScale = ContentScale.Crop, modifier = Modifier.fillMaxWidth().height(144.dp))
      Column(modifier = Modifier.padding(16.dp)) {
        Text(recipe?.title!!, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(bottom = 4.dp))
        for (ingredient in recipe?.ingredients!!) {
          Text("• $ingredient")
        }
      }
    }
  }
}


