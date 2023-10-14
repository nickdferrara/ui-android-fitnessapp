package com.nickdferrara.ui_android_fitnessapp.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
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
    val state = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            WelcomeMessage("Nicholas")
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
        HealthConnectCard()
        Spacer(modifier = Modifier.height(24.dp))
        UpcomingWorkouts()
    }
}

@Composable
private fun WelcomeMessage(
    name: String
) {
    Text(
        text = "Welcome $name",
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold
    )
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

@Composable
fun HealthConnectCard() {
    Card (
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(225.dp)
    )
    {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Health Connect Icon"
                )
                Text(
                    text = "Get more detailed workouts",
                    modifier = Modifier.padding(start = 8.dp),
                    fontWeight = FontWeight.Bold,
                )
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = "Close Health Connect Icon",
                    modifier = Modifier.weight(100f)
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
}

@Composable
fun UpcomingWorkouts(
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Upcoming Workouts",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "SEE ALL",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.primary,
            textDecoration = TextDecoration.Underline
        )
    }
    Spacer(Modifier.height(16.dp))
    Workouts()
}

@Composable
fun Workouts(

) {
    Card (
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.spin_class),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(Color.Gray, blendMode = BlendMode.Multiply),
                modifier = Modifier.fillMaxSize()
            )
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            )
            {
                Text(
                    text = "Spin + Recovery",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(start = 8.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.clock_icon),
                        contentDescription = "Close Health Connect Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(16.dp)
                    )
                    Text(
                        text = "45 Minutes",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(start = 8.dp),
                        color = Color.White
                    )
                }
            }
        }
    }
}