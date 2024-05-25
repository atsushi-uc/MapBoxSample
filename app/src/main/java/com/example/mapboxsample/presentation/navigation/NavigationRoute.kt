package com.example.mapboxsample.presentation.navigation

sealed class NavigationRoute(val route: String) {
    data object HomeScreen : NavigationRoute("home_screen")

    //実際の引数代入用の関数
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    //引数定義用の関数（引数の定義は）
    fun withArgsFormat(vararg arg: String): String {
        return buildString {
            arg.forEach {
                append("/{$arg}")
            }
        }
    }
}