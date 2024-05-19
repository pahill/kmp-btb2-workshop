import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import exampleproject.composeapp.generated.resources.Res
import exampleproject.composeapp.generated.resources.compose_multiplatform

fun calculateValue1(): Int {
    println("Calculating value 1")
    return 101
}

fun calculateValue2(): Int {
    println("Calculating value 2")
    return 202
}

fun calculateValue3(): Int {
    println("Calculating value 3")
    return 303
}


@Composable
fun App() {
    var value1 = calculateValue1()
    var value2 = remember { calculateValue2() }
    var value3 = remember { mutableStateOf(calculateValue3()) }

    Column {
        Row {
            Text(
                style = TextStyle(color = Color.Black, fontSize = 18.sp),
                text = "Values are $value1, $value2 and ${value3.value}"
            )
        }
        Row {
            Button(onClick = { value1++; value2++; value3.value += 1; }) {
                Text("Increment Values")
            }
        }
    }
}