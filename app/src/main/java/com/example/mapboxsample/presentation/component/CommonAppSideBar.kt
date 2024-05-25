package com.example.mapboxsample.presentation.component

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
fun CommonSideAppBar(initialSidebarWidth: Dp = 50.dp, paddingValues: PaddingValues = PaddingValues(), backgroundColor: Color = Color.Unspecified) {
    var isExpanded by remember { mutableStateOf(false) }
    val widthAnim by animateDpAsState(targetValue = if(isExpanded) 200.dp else initialSidebarWidth, label = "", animationSpec = tween(3000))
    val currentLayoutDirection = LocalLayoutDirection.current
    Column(
        Modifier
            .fillMaxHeight()
            .width(widthAnim)
            .background(backgroundColor)
            .padding(
                PaddingValues(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding(),
                    start = 10.dp + paddingValues.calculateStartPadding(currentLayoutDirection),
                    end = 10.dp + paddingValues.calculateEndPadding(currentLayoutDirection)
                )
            ),
        horizontalAlignment = Alignment.Start


    ) {

        Icon(
            Icons.Default.Menu,
            modifier = Modifier
                .clickable { isExpanded = !isExpanded },
            contentDescription = null, tint = Color.White
        )
        Spacer(modifier = Modifier.height(20.dp))
        DrawerItem(Icons.Default.Person, "Profile", isExpanded)
        DrawerItem(Icons.Default.Settings, "Setting", isExpanded)
        DrawerItem(Icons.Default.Info, "About Us", isExpanded)
        DrawerItem(Icons.Default.Call, "Contact Us", isExpanded)

    }

}

@Composable
fun DrawerItem(icon: ImageVector, title: String, expanded: Boolean) {


    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = Color.White,
        )
        AnimatedContent(
            targetState = expanded,
            transitionSpec ={
                fadeIn(animationSpec = tween(100)) togetherWith fadeOut(tween(100)
                ) using SizeTransform { initialSize, targetSize ->
                    keyframes {
                        IntSize(targetSize.width, initialSize.height) at 0
                        durationMillis = 100
                    }

                }
            }, label = ""
        ) {
                targetState ->
            if (targetState) {

                Row( Modifier.fillMaxWidth() ) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = title, color = Color.White)
                }
            }
        }

    }

}

@Preview
@Composable
fun PreviewCommonSideAppBar() {
    CommonSideAppBar()
}