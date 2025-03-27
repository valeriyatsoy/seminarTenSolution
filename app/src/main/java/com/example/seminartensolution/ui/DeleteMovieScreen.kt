package com.example.seminartensolution.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seminartensolution.R


@Composable
fun DeleteMovieScreen() {

    val viewModel: MovieViewModel = viewModel()
    val movieId = viewModel.movieId
    val onMovieIdChange: (String) -> Unit = { viewModel.movieId = it }
    val onDeleteClick: () -> Unit = { viewModel.deleteMovieById(movieId) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DeleteLabel()
        DeleteInput(
            movieId, onMovieIdChange
        )
        DeleteButton(
            onDeleteClick
        )

    }
}


@Composable
fun DeleteLabel() {
    Text(
        text = stringResource(R.string.delete_label),
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 8.dp)
    )

}

@Composable
fun DeleteInput(movieId: String, onMovieIdChange: (String) -> Unit) {
    TextField(
        value = movieId,
        onValueChange = onMovieIdChange,
        placeholder = { Text(stringResource(R.string.delete_input_hint)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    )
}

@Composable
fun DeleteButton(onDeleteClick: () -> Unit) {
    Button(
        onClick = onDeleteClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = stringResource(R.string.delete_button))
    }
}