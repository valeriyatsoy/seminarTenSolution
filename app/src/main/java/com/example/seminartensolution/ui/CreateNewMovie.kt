package com.example.seminartensolution.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.seminartensolution.data.Movie

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seminartensolution.R

@Composable
fun CreateNewMovie(viewModel: MovieViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var productionYear by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf(5f) }
    val context = LocalContext.current
    val validationMsgStr = stringResource(R.string.create_movie_validation_empty)

    Column(modifier = Modifier.padding(Dimens.MediumPadding)) {

        Spacer(modifier = Modifier.height(Dimens.SmallPadding))

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(stringResource(R.string.movie_name_input_hint)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(Dimens.SmallPadding))

        TextField(
            value = productionYear,
            onValueChange = { if (it.all { char -> char.isDigit() }) productionYear = it },
            label = { Text(stringResource(R.string.production_year_input_hint)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Rating: ${rating}")
        Slider(
            value = rating,
            onValueChange = { rating = it },
            valueRange = 0f..10f,
            steps = 9,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(Dimens.MediumPadding))

        Button(
            onClick = {
                if (name.isNotEmpty() && productionYear.isNotEmpty()) {
                    viewModel.newMovie = Movie(
                        name = name,
                        productionYear = productionYear.toInt(),
                        rating = rating
                    )

                    Toast.makeText(context, viewModel.newMovie.toString(), Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, validationMsgStr, Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.create_movie_button))
        }
    }
}
