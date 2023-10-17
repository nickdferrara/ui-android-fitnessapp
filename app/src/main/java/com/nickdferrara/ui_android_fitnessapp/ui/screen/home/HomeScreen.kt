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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.nickdferrara.ui_android_fitnessapp.R
import com.nickdferrara.ui_android_fitnessapp.data.models.Workout
import com.nickdferrara.ui_android_fitnessapp.util.findMockUpcomingWorkouts
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
@Composable
fun HomeScreen(
    navController: NavController
) {
    val sdf = SimpleDateFormat("EEEE, LLLL dd")
    val currentDate = sdf.format(Date())
    val upcomingWorkouts = findMockUpcomingWorkouts()
    val openDialog = remember { mutableStateOf(false) }

    Column {
        WelcomeSection("Nicholas", currentDate) {
            openDialog.value = true
        }

        if (openDialog.value) {
            DisplayUserSettingsDialog {
                openDialog.value = false
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        HealthMetricsSection()
        Spacer(modifier = Modifier.height(24.dp))
        UpcomingWorkoutSection(upcomingWorkouts)
    }
}

@Composable
private fun WelcomeSection(
    firstName: String,
    currentDate: String?,
    onUserSettingsRequest: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Welcome $firstName",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        FitifyProfileImage(
            drawableResource = R.drawable.profile_image,
            description = "Profile Image",
            onUserSettingsRequest = { onUserSettingsRequest()}

        )
    }
    Text(
        text = "Today is $currentDate",
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.secondary
    )
}

@Composable
fun FitifyProfileImage(
    drawableResource: Int,
    description: String,
    onUserSettingsRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
            .clickable { onUserSettingsRequest() },
        painter = painterResource(id = drawableResource),
        contentDescription = description,
    )
}

@Composable
fun HealthMetricsSection() {
    HealthConnectCard()

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
fun UpcomingWorkoutSection(
    upcomingWorkouts: List<Workout>
) {
    UpcomingWorkoutsHeader()
    Spacer(Modifier.height(16.dp))
    WorkoutCards(upcomingWorkouts)
}

@Composable
private fun UpcomingWorkoutsHeader() {
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
}

@Composable
fun WorkoutCards(
    upcomingWorkouts: List<Workout>
) {
    UpcomingWorkoutCard(upcomingWorkout = upcomingWorkouts[0])
    Spacer(modifier = Modifier.height(10.dp))
    UpcomingWorkoutCard(upcomingWorkout = upcomingWorkouts[1])
    Spacer(modifier = Modifier.height(10.dp))
    UpcomingWorkoutCard(upcomingWorkout = upcomingWorkouts[2])
}

@Composable
fun UpcomingWorkoutCard(
    upcomingWorkout: Workout
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
                painter = painterResource(upcomingWorkout.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(Color.Gray,
                    blendMode = BlendMode.Multiply
                ),
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
                    text = upcomingWorkout.description,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(start = 8.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.clock_icon),
                        contentDescription = "Time Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(16.dp)
                    )
                    Text(
                        text = "${upcomingWorkout.duration} Minutes",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(start = 8.dp),
                        color = Color.White
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = "Coach Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(16.dp)
                    )
                    Text(
                        text = upcomingWorkout.coach,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(start = 8.dp),
                        color = Color.White
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = "Coach Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(16.dp)
                    )
                    Text(
                        text = "Saturday October 19th",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(start = 8.dp),
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun DisplayUserSettingsDialog(
    onDismissRequest: () -> Unit
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(
                text = "User settings coming soon...",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center,
            )
        }
    }
}