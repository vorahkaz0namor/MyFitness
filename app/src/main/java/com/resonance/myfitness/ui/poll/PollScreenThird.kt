package com.resonance.myfitness.ui.poll

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.resonance.myfitness.navigation.PollScreen
import com.resonance.myfitness.ui.baseviews.BasePollContainer
import com.resonance.myfitness.ui.baseviews.StubScreen

@Preview(showBackground = true)
@Composable
fun ThirdPollPreview() {
    PollScreenThird(1) {}
}

@Composable
fun PollScreenThird(
    currentProgress: Int = 0,
    onBackButtonClick: () -> Unit,
) {
    BasePollContainer(
        currentProgress = currentProgress,
        onBackButtonClick = onBackButtonClick,
    ) {
        Box(
            modifier = Modifier.padding(top = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            StubScreen(caption = PollScreen.THIRD_POLL_SCREEN)
        }
    }
}