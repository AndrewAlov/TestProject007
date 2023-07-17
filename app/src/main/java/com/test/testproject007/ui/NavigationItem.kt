package com.test.testproject007.ui

import com.test.testproject007.R

sealed class NavigationItem(var route: String, var icon: Int, var title: Int) {
    object Home : NavigationItem("home", android.R.drawable.ic_menu_search, R.string.search)
    object Favourites : NavigationItem("favourites", android.R.drawable.star_on, R.string.favourites)
    object Booking : NavigationItem("booking", android.R.drawable.sym_action_email, R.string.booking)
    object Profile : NavigationItem("profile", android.R.drawable.star_on, R.string.profile)
}