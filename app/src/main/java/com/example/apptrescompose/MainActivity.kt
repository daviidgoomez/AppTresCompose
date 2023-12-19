package com.example.apptrescompose

import android.R
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.apptrescompose.ui.theme.AppTresComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTresComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    mainApp()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AppPreview() {
    AppTresComposeTheme {
    mainApp()
    }
}


@Composable
fun mainApp() {
    val images = listOf(
        R.drawable.ic_dialog_alert,
        R.drawable.ic_lock_power_off,
        R.drawable.ic_dialog_map,
        R.drawable.ic_delete,
        R.drawable.ic_dialog_info,
        R.drawable.ic_dialog_email,
        R.drawable.ic_dialog_dialer,
        R.drawable.ic_input_delete
    )

    val imageModifier = Modifier
        .size(60.dp)
        .border(BorderStroke(1.dp, Color.Black))
        .background(Color.Cyan)

    var switchState by remember { mutableStateOf(false) }
    var selectedPageIndex by remember { mutableStateOf(0) }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        val (switch, interruptor, threeLines, pulsado, noPulsado,
            anteriorButton, postButton, imageMap, imagePowerOff, imageAlert) = createRefs()

        Switch(
            checked = switchState,
            onCheckedChange = { isChecked ->
                switchState = isChecked
            },
            modifier = Modifier
                .padding(18.dp)
                .constrainAs(switch) {
                    end.linkTo(interruptor.start)
                    top.linkTo(parent.top)
                }
        )

        Text(
            text = "Interruptor",
            modifier = Modifier
                .padding(30.dp)
                .constrainAs(interruptor) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Text(
            text = "El interruptor del SWITCH ha sido pulsado" +
                    "\nEs una aplicación interesante," +
                    "\nDe desarrollo de Aplicaciones Android",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.alpha(if (switchState) 1f else 0f)
                .constrainAs(threeLines) {
                    top.linkTo(switch.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        if (switchState) {
            Text(
                text = "PULSADO",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(15.dp)
                    .constrainAs(pulsado) {
                        top.linkTo(threeLines.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
        } else {
            Text(
                text = "NO PULSADO",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(15.dp)
                    .constrainAs(noPulsado) {
                        top.linkTo(threeLines.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
        }

        Button(onClick = {
            // Lógica del botón ANTERIOR
            selectedPageIndex = (selectedPageIndex - 1 + images.size) % images.size
        }, modifier = Modifier.constrainAs(anteriorButton) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
        }) {
            Text("ANT")
        }

        Button(onClick = {
            // Lógica del botón POSTERIOR
            selectedPageIndex = (selectedPageIndex + 1) % images.size
        }, modifier = Modifier.constrainAs(postButton) {
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        }) {
            Text("POS")
        }

        Image(
            painter = painterResource(id = images[selectedPageIndex]),
            contentDescription = null,
            modifier = imageModifier.constrainAs(imageMap) {
                start.linkTo(anteriorButton.end)
                end.linkTo(postButton.start)
                bottom.linkTo(parent.bottom)
            }
        )
    }
}








