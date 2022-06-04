package com.talatelbeick.androidcomposeui.birthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.talatelbeick.androidcomposeui.R
import com.talatelbeick.androidcomposeui.ui.theme.AndroidComposeUiTheme

class BirthdayActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeUiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    GreetingWithImage("Sam", "Sara")
                }
            }
        }
    }
}

@Composable
fun GreetingWithImage(senderName: String, receiverName: String) {
    val image = painterResource(id = R.drawable.perceptual_standard)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.Crop,
        )
        Greeting(senderName, receiverName)
    }
}

@Composable
fun Greeting(senderName: String, receiverName: String) {
    val textColor: Color = Color.White
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
    ) {
        Text(
            text = stringResource(id = R.string.happy_birthday) + " " + receiverName,
            fontSize = 36.sp,
            color = textColor,
        )
        Box(modifier = Modifier.padding(vertical = 8.dp))
        Text(
            text = stringResource(R.string.from) + " " + senderName,
            fontSize = 18.sp,
            color = textColor,
            modifier = Modifier.align(Alignment.End)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidComposeUiTheme {
        GreetingWithImage("Sam", "Sara")
    }
}
