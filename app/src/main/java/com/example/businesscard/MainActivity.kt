package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    val name = stringResource(id = R.string.name)
    val title = stringResource(id = R.string.title)
    val number = stringResource(id = R.string.number)
    val mail = stringResource(id = R.string.mail)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)) {
        Spacer(Modifier.weight(1f))
        Card(name = name, title = title, modifier = modifier.weight(1.5f))
        Contacts(number = number, mail = mail, modifier = modifier.weight(1.2f))
    }
}

@Composable
fun Card(
    name: String,
    title: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = R.drawable.ic_launcher_foreground)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.background(Color.Cyan)
        )
        Text(
            text = name,
            fontSize = 32.sp,
            color = Color.White,
            modifier = Modifier.padding(12.dp)
        )
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
        )
    }
}


@Composable
fun Contacts(
    number: String,
    mail: String,
    modifier: Modifier = Modifier
) {
    val phoneIcon = painterResource(id = R.drawable.baseline_phone_black_24dp)
    val mailIcon = painterResource(id = R.drawable.baseline_mail_outline_black_24dp)
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(Modifier.fillMaxWidth(0.6f)) {
            Icon(
                painter = phoneIcon,
                contentDescription = null,
                tint = Color.Cyan,
                modifier = Modifier.padding(8.dp).size(24.dp))
            Text(
                text = number,
                fontSize = 22.sp,
                color = Color.White)
        }
        Row(Modifier.fillMaxWidth(0.6f)) {
            Icon(
                painter = mailIcon,
                contentDescription = null,
                tint = Color.Cyan,
                modifier = Modifier.padding(8.dp).size(24.dp))
            Text(
                text = mail,
                fontSize = 22.sp,
                color = Color.White
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            BusinessCard()
        }
    }
}