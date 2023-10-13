package com.nickdferrara.ui_android_fitnessapp.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nickdferrara.ui_android_fitnessapp.R

@Composable
fun HomeScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Welcome Nicholas",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            FitifyProfileImage(
                drawableResource = R.drawable.profile_image,
                description = "Profile Image"
            )
        }
    }
}

@Composable
fun FitifyProfileImage(
    drawableResource: Int,
    description: String,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
            .clickable {},
        painter = painterResource(id = drawableResource),
        contentDescription = description,
    )
}