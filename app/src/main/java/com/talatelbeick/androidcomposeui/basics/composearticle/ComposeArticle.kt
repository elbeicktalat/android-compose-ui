package com.talatelbeick.androidcomposeui.basics.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.talatelbeick.androidcomposeui.R
import com.talatelbeick.androidcomposeui.ui.theme.AndroidComposeUiTheme

class ComposeArticle : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }

    @Composable
    fun Content() {
        AndroidComposeUiTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column {
                    HeaderImage()
                    TextBody()
                }
            }
        }

    }

    @Composable
    fun HeaderImage() {
        val image = painterResource(id = R.drawable.bg_compose_background)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
        )
    }


    @Composable
    fun TextBody() {
        LazyColumn {
            item {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(text = stringResource(R.string.compose_article_title), fontSize = 28.sp)
                    Box(modifier = Modifier.padding(12.dp))
                    Text(text = stringResource(R.string.compose_article_short_description))
                    Box(modifier = Modifier.padding(12.dp))
                    Text(text = stringResource(R.string.compose_article_long_description))
                }
            }

        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Content()
    }
}
