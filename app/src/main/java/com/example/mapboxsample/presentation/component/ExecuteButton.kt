package com.example.mapboxsample.presentation.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ExecuteButton(
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    label: String ="",
    submit: () -> Unit,
) {
    Button(onClick = submit, enabled = !isLoading, modifier = modifier, shape = RoundedCornerShape(20.dp)) {
        if (isLoading) {
            CircularProgressIndicator(
                strokeWidth = 2.dp,
                modifier = Modifier.size(24.dp)
            )
        } else {
            Text(label)
        }
    }
}

@Preview
@Composable
private fun ExecuteButton() {
    ExecuteButton(submit = {})
}