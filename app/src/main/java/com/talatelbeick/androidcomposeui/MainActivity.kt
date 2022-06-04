package com.talatelbeick.androidcomposeui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.talatelbeick.androidcomposeui.birthday.BirthdayActivity
import com.talatelbeick.androidcomposeui.ui.theme.AndroidComposeUiTheme


@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeUiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(
                            text = "Experimental",
                            fontSize = 24.sp,
                            modifier = Modifier.padding(8.dp)
                        )
                        GetCard(
                            targets = listOf(
                                Target(getString(R.string.birthday_activity), BirthdayActivity()),
                            ),
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun GetCard(targets: List<Target>) {
        LazyColumn {
            items(targets) {
                BuildCard(it)
            }
        }

    }

    @Composable
    private fun BuildCard(target: Target) {
        Card(
            onClick = { startActivity(Intent(this, target.activity::class.java)) },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = target.title,
                    fontSize = 28.sp
                )
            }
        }
    }
}

private class Target(val title: String, val activity: Activity)