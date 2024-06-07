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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.resonance.data.model.LoginRequest
import com.resonance.myfitness.R
import com.resonance.resources.Email
import com.resonance.resources.LogInAnonymously
import com.resonance.resources.LoginScreenAdditionalCaption
import com.resonance.resources.LoginScreenMainCaption
import com.resonance.resources.Next
import com.resonance.resources.PrivacyPolicy
import com.resonance.resources.PrivacyPolicySecond
import com.resonance.resources.TextBorderStroke
import com.resonance.resources.TextColorGray
import com.resonance.resources.TextOutlinedTextField
import com.resonance.resources.TextPrivacyPolicy

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(login = {})

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(login: (LoginRequest) -> Unit) {
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
                    text = LoginScreenMainCaption,
                    fontSize = 25.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )

                Text(
                    text = LoginScreenAdditionalCaption,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextColorGray,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(40.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, start = 15.dp, end = 15.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .border(
                            BorderStroke(1.dp, TextBorderStroke),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.like_checkbox),
                            contentDescription = "Like Checkbox",
                            modifier = Modifier.size(20.dp)
                        )
                        OutlinedTextField(
                            value = emailText,
                            onValueChange = { emailText = it },
                            placeholder = { Text(text = Email) },
                            singleLine = true,
                            modifier = Modifier.weight(1f),
                            textStyle = TextStyle(color = TextOutlinedTextField),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent,
                                disabledBorderColor = Color.Transparent
                            ),
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
                        )
                    }


                }

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier
                        .padding(start = 15.dp, end = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier
                            .padding(end = 15.dp)
                            .weight(1f, fill = true),
                        verticalAlignment = Alignment.Top
                    ) {
                        Checkbox(
                            checked = false,
                            onCheckedChange = { isChecked ->

                            },
                            modifier = Modifier.size(16.dp)

                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Spacer(modifier = Modifier.width(15.dp))
                        val wordsPrivacyPolicy = PrivacyPolicy.split(" ")
                        val wordsPrivacyPolicySecond = PrivacyPolicySecond.split(" ")

                        Column(
                            modifier = Modifier,
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Row(
                                modifier = Modifier,
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                wordsPrivacyPolicy.forEach { word ->
                                    Text(
                                        text = word,
                                        fontSize = 10.sp,
                                        textDecoration = if (word.equals(
                                                "Политику",
                                                ignoreCase = true
                                            )
                                        ) TextDecoration.Underline else null,
                                        color = TextPrivacyPolicy,
                                        textAlign = TextAlign.Start,
                                        modifier = Modifier
                                    )
                                }
                            }

                            Row(
                                modifier = Modifier,
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                wordsPrivacyPolicySecond.forEach { word ->
                                    Text(
                                        text = word,
                                        fontSize = 10.sp,
                                        textDecoration = if (word.equals(
                                                "и",
                                                ignoreCase = true
                                            )
                                        ) null else TextDecoration.Underline,
                                        color = TextPrivacyPolicy,
                                        textAlign = TextAlign.Start,
                                        modifier = Modifier
                                    )
                                }
                            }

                        }
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
                    Text(text = Next, style = TextStyle(fontSize = 16.sp))
                }

                Text(
                    text = LogInAnonymously, style = TextStyle(fontSize = 16.sp),
                    color = TextColorGray,
                )
            }
        }
    }
}




