package com.example.mapboxsample.presentation.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mapboxsample.R

@Composable
fun ErrorDialog(
    title: String = stringResource(id = R.string.error_dialog_message_default_title),
    message: String = "",
    onDismiss: () -> Unit = {}

) {
    AlertDialog(
        modifier = Modifier.clip(RoundedCornerShape(12.dp)),
        onDismissRequest = {},
        confirmButton = {
            TextButton(
                onClick = { onDismiss() }
            ) {
                Text(stringResource(id = R.string.error_dialog_btn_positive))
            }
        },
        dismissButton = null,
        title = {
            Text(title)
        },
        text = {
            Text(message)
        },
    )

}

@Preview
@Composable
private fun ErrorDialog() {
    ErrorDialog()
}