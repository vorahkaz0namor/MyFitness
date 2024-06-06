package com.resonance.myfitness.ui.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.resonance.data.model.LoginRequest
import com.resonance.myfitness.R
import com.resonance.resources.ConfirmTheEmailAddress
import com.resonance.resources.CreateAnAccount
import com.resonance.resources.Email
import com.resonance.resources.ItWillBeUpdated
import com.resonance.resources.LogInAnonymously
import com.resonance.resources.LoginScreenAdditionalCaption
import com.resonance.resources.LoginScreenMainCaption
import com.resonance.resources.Next
import com.resonance.resources.PleaseOpenTheMailbox
import com.resonance.resources.PrivacyPolicy
import com.resonance.resources.PrivacyPolicySecond
import com.resonance.resources.Resend
import com.resonance.resources.TextBorderStroke
import com.resonance.resources.TextColorGray
import com.resonance.resources.TextOutlinedTextField
import com.resonance.resources.TextPrivacyPolicy

@Preview(showBackground = true)
@Composable
fun VerifyScreenPreview() {
    VerifyScreen(login = {})

}


@Composable
fun VerifyScreen(login: (LoginRequest) -> Unit) {
    var emailText by remember { mutableStateOf(TextFieldValue()) }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                .offset(y = 150.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = ConfirmTheEmailAddress,
                    fontSize = 25.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = PleaseOpenTheMailbox,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextColorGray,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(40.dp))
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    // сюда рисуем квадраты
                    SquareWithNumberInput()
                }

                Spacer(modifier = Modifier.height(15.dp))



                Spacer(modifier = Modifier.width(15.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally // Выравниваем по центру по горизонтали
                ) {
                    Row(
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = ItWillBeUpdated,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = TextColorGray,
                            textAlign = TextAlign.Center,
                        )
                    }



                Row(
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = Resend,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = TextColorGray,
                            textAlign = TextAlign.Center,
                        )
                    }

                }

            }
        }


        Spacer(modifier = Modifier.height(450.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.align(Alignment.TopCenter)
            ) {
                Button(
                    onClick = { /* Действие при нажатии на кнопку */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 15.dp),
                    shape = RoundedCornerShape(size = 12.dp)
                ) {
                    Text(text = CreateAnAccount, style = TextStyle(fontSize = 16.sp))
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SquareWithNumberInput() {
    var numbers by remember { mutableStateOf(List(5) { "" }) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        for (i in 0 until 5) {
            TextField(
                value = numbers[i],
                onValueChange = { newValue ->
                    numbers = numbers.toMutableList().also { it[i] = newValue }
                },
                modifier = Modifier
                    .background(Color.White)
                    .padding(8.dp)
                    .size(50.dp)
                    .border(
                        BorderStroke(1.dp, TextPrivacyPolicy),
                        shape = RoundedCornerShape(16.dp)
                    ),
                textStyle = TextStyle(color = Color.Black),
                placeholder = { Text("") }
            )
        }
    }
}








