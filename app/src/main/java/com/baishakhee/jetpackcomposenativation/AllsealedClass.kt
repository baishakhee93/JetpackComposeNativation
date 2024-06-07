package com.baishakhee.jetpackcomposenativation


sealed class BottomNavigationScreen(val route: String) {
    object HomeScreen : BottomNavigationScreen("home")
    object ProfileScreen : BottomNavigationScreen("profile")
    object NotificationsScreen : BottomNavigationScreen("notifications")
    object SettingsScreen : BottomNavigationScreen("settings")
    object FavoriteScreen : BottomNavigationScreen("favorite")

    companion object {
        fun routeFromTitle(title: String): String? {
            return when (title) {
                "Home" -> Screens.HomeScreen.route
                "Profile" -> Screens.ProfileScreen.route
                "Notifications" -> Screens.NotificationsScreen.route
                "Settings" -> Screens.SettingsScreen.route
                "Favorite" -> Screens.FavoriteScreen.route

                else -> null
            }
        }
    }
}


sealed class Screens(val route: String) {
    object HomeScreen : Screens("home")
    object ProfileScreen : Screens("profile")
    object NotificationsScreen : Screens("notifications")
    object SettingsScreen : Screens("settings")
    object FavoriteScreen : Screens("favorite")
    object AboutUsScreen : Screens("about_us")
    object ShareScreen : Screens("share")

    companion object {
        fun routeFromTitle(title: String): String? {
            return when (title) {
                "Home" -> HomeScreen.route
                "Profile" -> ProfileScreen.route
                "Notifications" -> NotificationsScreen.route
                "Settings" -> SettingsScreen.route
                "Favorite" -> FavoriteScreen.route
                "About US" -> AboutUsScreen.route
                "Share" -> ShareScreen.route
                else -> null
            }
        }
    }
}
