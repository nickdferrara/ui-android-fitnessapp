package com.nickdferrara.ui_android_fitnessapp.ui.screen.workout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nickdferrara.ui_android_fitnessapp.data.models.Workout
import com.nickdferrara.ui_android_fitnessapp.util.findLastSeveDays
import com.nickdferrara.ui_android_fitnessapp.util.findMockUpcomingWorkouts
import java.time.LocalDate

@Composable
fun WorkoutScreen(
    navController: NavController,
    innerPadding: PaddingValues
) {
    val calendarDays = findLastSeveDays()
    val workouts = findMockUpcomingWorkouts()

    Surface(
        modifier = Modifier
            .padding(innerPadding)
    ) {
        Column {
            TopToolbar()
            DayCarouselSection(calendarDays)
            ScheduledWorkoutSection(workouts)
        }
    }
}

@Composable
fun ScheduledWorkoutSection(
    workouts: List<Workout>
) {
    LazyColumn {
        items(workouts) { message ->

        }
    }
}

@Composable
fun WorkoutItem(workout: Workout) {
    Column {
        Text(text = "${workout.description}")
    }
}

@Composable
fun DayCarouselSection(
    days: List<LocalDate>,
    modifier: Modifier = Modifier.padding(start = 20.dp)
) {
    var selectedIndex by remember {
        mutableStateOf(0)
    }

    LazyRow(
        contentPadding = PaddingValues(
            top = 8.dp,
            end = 24.dp,
            bottom = 24.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        itemsIndexed(days) { index, item ->
            if (index == 0) Spacer(Modifier.width(20.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        }
                    )
                    .height(90.dp)
                    .width(120.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            if (selectedIndex == index) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.surfaceVariant
                        )

                ) {
                    Text(
                        text = "${item.dayOfWeek}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = if (selectedIndex == index)
                            MaterialTheme.colorScheme.surface
                            else MaterialTheme.colorScheme.onSurface

                    )
                    Text(
                        text = "${item.monthValue}/${item.dayOfMonth} ",
                        color = if (selectedIndex == index)
                            MaterialTheme.colorScheme.surface
                            else MaterialTheme.colorScheme.onSurface
                    )
                }
            }

        }
    }
}

@Composable
fun TopToolbar(
    modifier: Modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Text(
            text = "Workouts",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Row {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.Place,
                    contentDescription = "Profile Icon"
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = "Profile Icon"
                )
            }

        }
    }
}
