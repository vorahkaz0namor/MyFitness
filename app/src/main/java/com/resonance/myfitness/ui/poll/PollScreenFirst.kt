package com.resonance.myfitness.ui.poll

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.resonance.myfitness.ui.baseviews.BasePollContainer
import com.resonance.myfitness.ui.splash.ImageWithCaptionItem
import com.resonance.resources.FirstPollScreenAdditionalCaption
import com.resonance.resources.FirstPollScreenMainCaption
import com.resonance.resources.TextColorGray

@Preview(showBackground = true)
@Composable
fun FirstPollPreview() {
    PollScreenFirst(1) {}
}

@Composable
fun PollScreenFirst(
    currentProgress: Int = 0,
    onBackButtonClick: () -> Unit,
) {
        BasePollContainer(
            currentProgress = currentProgress,
            onBackButtonClick = onBackButtonClick,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 48.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = FirstPollScreenMainCaption,
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
                        text = FirstPollScreenAdditionalCaption,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = TextColorGray,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
}

@Composable
fun PollScreenItem(pollScreenItem: ImageWithCaptionItem) {
    ElevatedCard(onClick = { /*TODO*/ }) {
        
    }
}