package com.example.android_tutorial_compose_business_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_tutorial_compose_business_card.ui.theme.Android_tutorial_compose_business_cardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_tutorial_compose_business_cardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeApp()
                }
            }
        }
    }
}

@Composable
fun ComposeApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF083041)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Title()
        }
        ContactList()
    }
}

@Composable
fun Title() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        val image = painterResource(id = R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription = "Android Logo",
            modifier = Modifier.width(112.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            stringResource(id = R.string.name_jennifer_doe),
            color = Color.White,
            fontSize = 48.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            stringResource(id = R.string.job_title),
            color = colorResource(id = R.color.green)
        )
    }
}

@Composable
fun ContactList() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
    ) {
        Contact(
            icon = Icons.Filled.Call,
            text = stringResource(id = R.string.phone_number)
        )
        Contact(
            icon = Icons.Filled.Share,
            text = stringResource(id = R.string.telegram)
        )
        Contact(
            icon = Icons.Filled.Email,
            text = stringResource(id = R.string.email)
        )
    }
}

@Composable
fun Contact(icon: ImageVector, text: String) {
    ContactSpacer()
    Row(modifier = Modifier.padding(start = 48.dp, top = 8.dp, bottom = 8.dp)) {
        Icon(
            contentDescription = text,
            imageVector = icon,
            tint = colorResource(id = R.color.green)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            color = Color.White,
            fontSize = 16.sp,
            text = text
        )
    }
}

@Composable
fun ContactSpacer() {
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(3.dp)
        .background(color = Color(0xFF294a5a)))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Android_tutorial_compose_business_cardTheme {
        ComposeApp()
    }
}