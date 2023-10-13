package com.nickdferrara.ui_android_fitnessapp.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nickdferrara.ui_android_fitnessapp.R
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
@Composable
fun HomeScreen(
    navController: NavController
) {
    val sdf = SimpleDateFormat("EEEE, LLLL dd")
    val currentDate = sdf.format(Date())

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Welcome Nicholas,",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            FitifyProfileImage(
                drawableResource = R.drawable.profile_image,
                description = "Profile Image"
            )
        }
        Text(
            text = "Today is $currentDate",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.height(32.dp))
        Card (
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
        )
        {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Row {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Health Connect Icon"
                    )
                    Text(
                        text = "Get more detailed workouts",
                        modifier = Modifier.padding(start = 8.dp),
                        fontWeight = FontWeight.Bold

                    )
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "Close Health Connect Icon"
                    )
                }
                Text(
                    text = "Keep Fitify updated with the latest information from your other apps, " +
                            "like your calories, heart rate and body measurements.",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 16.dp)
                )

                TextButton(
                    onClick ={},
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Text(text = "Set Up Health Connect" )
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row {
            Text(
                text = "Upcoming Workouts",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.secondary
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