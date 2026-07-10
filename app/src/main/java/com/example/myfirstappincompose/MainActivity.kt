package com.example.myfirstappincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myfirstappincompose.ui.consultant.ConsultantNavComposeView
import com.example.myfirstappincompose.ui.theme.MyFirstAppInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstAppInComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //ConsultantNavComposeView(innerPadding)
                    MyLoader(innerPadding)
                }
            }
        }
    }
}


@Composable
fun MyLoader(padding : PaddingValues) {
    val isVisibleLoader = rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(isVisibleLoader.value) {
            CircularProgressIndicator()
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            isVisibleLoader.value = true
        }) {
            Text(text = "Mostrar loader")
        }
        if(isVisibleLoader.value) {
            Button(onClick = {
                isVisibleLoader.value = false
            }) {
                Text(text = "Ocultar loader")
            }
        }

    }
}