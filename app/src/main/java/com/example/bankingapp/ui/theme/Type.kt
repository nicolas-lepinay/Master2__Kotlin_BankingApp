package com.example.bankingapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bankingapp.R

// Druk Cyr Font Family
val drukCyr = FontFamily(
    Font(R.font.drukcyr_medium, FontWeight.Normal),
    Font(R.font.drukcyr_bold, FontWeight.Bold),
    Font(R.font.drukcyr_mediumitalic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.drukcyr_bolditalic, FontWeight.Bold, FontStyle.Italic)
)

// Déclaration du style personnalisé en dehors de Typography
val customHeadlineLargeItalic = TextStyle(
    fontFamily = drukCyr,
    fontWeight = FontWeight.Normal,
    fontStyle = FontStyle.Italic,
    fontSize = 36.sp,
    lineHeight = 40.sp,
    letterSpacing = 1.sp
)

val customHeadlineLarge = TextStyle(
    fontFamily = drukCyr,
    fontWeight = FontWeight.Normal,
    fontSize = 36.sp, // Same as default
    lineHeight = 40.sp, // Same as default
    letterSpacing = 1.sp
)

val customTitleMedium = TextStyle(
    fontFamily = drukCyr,
    fontWeight = FontWeight.Medium, // Same as default
    fontSize = 24.sp, // Same as default
    lineHeight = 30.sp, // Same as default
    letterSpacing = 1.sp
)

val displayLargeBold = TextStyle(
    fontFamily = FontFamily.Default, // Same as default
    fontWeight = FontWeight.Bold,
    fontSize = 57.sp, // Same as default
    lineHeight = 64.sp, // Same as default
    letterSpacing = (-0.25).sp // Same as default
)

val displayMediumBold = TextStyle(
    fontFamily = FontFamily.Default, // Same as default
    fontWeight = FontWeight.Bold,
    fontSize = 45.sp, // Same as default
    lineHeight = 52.sp, // Same as default
    letterSpacing = 0.sp // Same as default
)

// Set of Material typography styles to start with
val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default, // Same as default
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp, // Same as default
        lineHeight = 40.sp, // Same as default
        letterSpacing = 0.sp // Same as default
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Default, // Same as default
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp, // Same as default
        lineHeight = 32.sp, // Same as default
        letterSpacing = 0.sp // Same as default
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    )