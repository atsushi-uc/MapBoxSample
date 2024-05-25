package com.example.mapboxsample.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mapboxsample.R

@Composable
fun CommonBottomAppBar(
    onMoreVertNavLogin: () -> Unit = {},
    onMoreVertNavHome: () -> Unit = {},
    onMoreVertNavPhotoDetail: () -> Unit = {},
    onEditClick: () -> Unit = {},
    onDeleteClick: () -> Unit = {},
    onAddClick: () -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }

    BottomAppBar(
        actions = {
            IconButton(onClick = { expanded = true }) {
                Icon(
                    Icons.Filled.MoreVert,
                    contentDescription = stringResource(id = R.string.common_app_bottom_nav_action_more_vert_description),
                    tint = Color.White
                )
            }
            IconButton(onClick = { onEditClick() }) {
                Icon(
                    Icons.Filled.Edit,
                    contentDescription = stringResource(id = R.string.common_app_bottom_nav_action_edit_description),
                    tint = Color.White
                )
            }
            IconButton(onClick = { onDeleteClick() }) {
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = stringResource(id = R.string.common_app_bottom_nav_action_delete_description),
                    tint = Color.White,
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onAddClick() },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(
                    Icons.Filled.Add,
                    stringResource(id = R.string.common_app_bottom_nav_floating_action_add_description)
                )
            }
        }
    )
    DropdownMenu(
        modifier = Modifier
            // タップされた時の背景を円にする
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.onSurface),
        expanded = expanded,
        // メニューの外がタップされた時に閉じる
        onDismissRequest = { expanded = false }) {
        DropdownMenuItem(
            trailingIcon = {
                Icon(
                    Icons.AutoMirrored.Filled.ExitToApp,
                    contentDescription = stringResource(id = R.string.common_app_bottom_nav_action_more_vert_login_description),
                    tint = Color.Black
                )
            },
            text = { Text(stringResource(id = R.string.common_app_bottom_nav_action_more_vert_login_text)) },
            colors = MenuDefaults.itemColors(textColor = Color.Black),
            onClick = { onMoreVertNavLogin() })
        DropdownMenuItem(
            trailingIcon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = stringResource(id = R.string.common_app_bottom_nav_action_more_vert_home_description),
                    tint = Color.Black
                )
            },
            text = { Text(stringResource(id = R.string.common_app_bottom_nav_action_more_vert_home_text)) },
            colors = MenuDefaults.itemColors(textColor = Color.Black),
            onClick = { onMoreVertNavHome() },
        )
        DropdownMenuItem(
            trailingIcon = {
                Icon(
                    Icons.Filled.Check,
                    contentDescription = stringResource(id = R.string.common_app_bottom_nav_action_more_vert_photo_detail_description),
                    tint = Color.Black
                )
            },
            text = { Text(stringResource(id = R.string.common_app_bottom_nav_action_more_vert_photo_detail_text)) },
            colors = MenuDefaults.itemColors(textColor = Color.Black),
            onClick = { onMoreVertNavPhotoDetail() })
    }
}

@Preview
@Composable
fun PreviewCommonBottomAppBar() {
    CommonBottomAppBar()
}
