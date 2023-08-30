package com.appbantu.bulllseye

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appbantu.bulllseye.ui.theme.BulllsEyeTheme
import kotlin.math.abs
import kotlin.random.Random

@Composable
fun GameScreen() {
//    var alertIsVisble: Boolean = false
    //Compose
    var alertIsVisble by rememberSaveable { mutableStateOf(false) }
    var sliderValue by rememberSaveable { mutableStateOf(0.5f) }
    val sliderValueToInt = (sliderValue * 100).toInt()
    var targetValue by remember { mutableStateOf(Random.nextInt(1, 100)) }

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
            GamePrompt(targetValue = targetValue)
            TargetSlider(
                value = sliderValue,
                valueChange = { newValue ->
                sliderValue = newValue
            }
            )
            Button(onClick = {
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
            },
                selection = sliderValueToInt,
                gameScore = gamePointsCalculator(targetValue, sliderValueToInt)
            )
        }
    }
}


fun gamePointsCalculator(targetValue: Int, guessedValue: Int): Int {
    val maxScore = 100
    return maxScore - abs(targetValue - guessedValue)

//    if (targetValue > guessedValue) {
//        return maxScore - (targetValue - guessedValue)
//    } else if (targetValue < guessedValue) {
//        return maxScore - (guessedValue - targetValue)
//    } else {
//        return  maxScore
//    }

//    var difference = targetValue - guessedValue
//    var absoluteDifference = when(difference < 0) {
//        true -> difference * -1
//        false -> difference
//    }
//    return  maxScore - absoluteDifference
}
@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    BulllsEyeTheme {
        GameScreen()
    }
}