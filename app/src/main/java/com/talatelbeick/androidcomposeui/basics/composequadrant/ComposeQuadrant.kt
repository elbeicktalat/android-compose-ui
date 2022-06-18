package com.talatelbeick.androidcomposeui.basics.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.talatelbeick.androidcomposeui.R
import com.talatelbeick.androidcomposeui.ui.theme.AndroidComposeUiTheme

lateinit var expanded: Modifier

class ComposeQuadrant : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }
}


@Composable
fun Content() {
    AndroidComposeUiTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Build()
        }
    }
}

@Composable
fun Quadrant(color: Color, title: String, description: String) {
    Surface(expanded.fillMaxHeight(), color = color) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp),
                color = Color.Black,
            )
            Text(text = description, textAlign = TextAlign.Justify, color = Color.Black)
        }
    }

}

@Composable
fun Build() {
    Column {
        expanded = Modifier.weight(1f)
        Row(expanded) {
            Quadrant(
                color = Color.Green,
                title = stringResource(R.string.text_composable),
                description = stringResource(R.string.text_composable_description),
            )
            Quadrant(
                color = Color.Yellow,
                title = stringResource(R.string.image_composable),
                description = stringResource(R.string.image_composable_description),
            )
        }
        Row(expanded) {
            Quadrant(
                color = Color.Cyan,
                title = stringResource(R.string.row_composable),
                description = stringResource(R.string.row_composable_description),
            )
            Quadrant(
                color = Color.LightGray,
                title = stringResource(R.string.column_composable),
                description = stringResource(R.string.column_composable_description),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Content()
}