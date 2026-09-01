package com.example.ca1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ca1.ui.theme.CA1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TravelExplorer()

        }
    }
}

data class Place(
    val name: String,
    val description: String,
    val location: String,
    val rating: Double
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TravelExplorer() {

    val place = Place(
        name = "Manali",
        description = "Beautiful mountain destination",
        location = "Himachal Pradesh, India",
        rating = 4.7
    )

    var showSheet by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.padding(16.dp).statusBarsPadding()
    ) {


        Text(place.name)

        Button(
            onClick = {
                showSheet = true
            }
        ) {
            Text("View Details")
        }
    }

    if (showSheet) {

        ModalBottomSheet(
            onDismissRequest = {
                showSheet = false
            }
        ) {
            Text("📍 ${place.location}")
            Text("⭐ ${place.rating}")
            Text("📝 ${place.description}")
        }
    }
}