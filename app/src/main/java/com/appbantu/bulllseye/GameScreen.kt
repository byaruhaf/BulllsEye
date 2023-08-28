package com.appbantu.bulllseye

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Vertical
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appbantu.bulllseye.ui.theme.BulllsEyeTheme

@Composable
fun GameScreen() {
//    var alertIsVisble: Boolean = false
    //Compose
    var alertIsVisble by remember { mutableStateOf(false) }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        verticalArrangement = Arrangement.Center
        ) {
        Spacer(modifier = Modifier.weight(.5f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.weight(9f)
        ) {
            Text(stringResource(R.string.instruction_text))
            Text(stringResource(R.string.target_value_text), fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    stringResource(R.string.min_value_text),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Slider(value = 0.5f,
                    valueRange = 0.01f..1f,
                    onValueChange = {},
                    modifier = Modifier.weight(1f)
                )
                Text(
                    stringResource(R.string.max_value_text),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
            Button(onClick = {
//                Log.d("Button Click Event", "You Clicked the Hit Me Button");

                Log.d("Alert Is Visblet", alertIsVisble.toString());
                    alertIsVisble = true
            }) {
                Text(text = stringResource(R.string.hit_me_button_text))
            }
        }
        Spacer(modifier = Modifier.weight(.5f))

        if (alertIsVisble) {
            ResultDialog(hideDialog = {
                alertIsVisble = false
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    BulllsEyeTheme {
        GameScreen()
    }
}