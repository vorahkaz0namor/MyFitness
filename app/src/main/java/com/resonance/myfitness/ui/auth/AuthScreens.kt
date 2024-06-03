package com.resonance.myfitness.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.resonance.data.model.LoginRequest
import com.resonance.resources.DDXAcronym
import com.resonance.resources.ExclamationPoint
import com.resonance.resources.LoginScreenAdditionalCaption
import com.resonance.resources.LoginScreenMainCaption
import com.resonance.resources.TextColorGray
import com.resonance.resources.TextColorViolet

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(login = {})
}

@Composable
fun LoginScreen(login: (LoginRequest) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(
//                color = Color.White,
//                shape = RoundedCornerShape(
//                    topStart = 16.dp,
//                    topEnd = 16.dp
//                )
//            )
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = LoginScreenMainCaption,
                fontSize = 25.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 186.dp)
            )
        }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = LoginScreenAdditionalCaption,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextColorGray,
                    textAlign = TextAlign.Center,
                )
            }
    }
}

@Composable
fun ConfirmScreen() {

}