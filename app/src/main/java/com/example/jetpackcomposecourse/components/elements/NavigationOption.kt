package com.example.jetpackcomposecourse.components.elements

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.jetpackcomposecourse.R

enum class NavigationOption(
    @param:DrawableRes val icon: Int,
    @param:StringRes val label: Int
) {
    HOME(R.drawable.ic_home, R.string.home_label),
    SETTINGS(R.drawable.ic_settings, R.string.settings_label),
    ADD(R.drawable.ic_add, R.string.add_label),
    PROFILE(R.drawable.ic_person, R.string.profile_label)
}