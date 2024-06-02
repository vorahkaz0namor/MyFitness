package com.resonance.myfitness.ui.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.resonance.myfitness.ui.baseviews.BaseContainerWithImage
import com.resonance.myfitness.ui.baseviews.BaseMainButton
import com.resonance.myfitness.ui.splash.ImageWithCaptionItem
import com.resonance.myfitness.ui.splash.Logotype
import com.resonance.resources.CreateAccountButtonCaption
import com.resonance.resources.LaterButtonCaption
import com.resonance.resources.TextButtonColor

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}

@Composable
fun WelcomeScreen(
    navigateToCreate: () -> Unit = {},
    navigateToMain: () -> Unit = {}
) {
    ConstraintLayout {
        val (imgWithTxt, logo, crtBtn, ltrBtn) = createRefs()

        Box(
            modifier = Modifier
                .constrainAs(imgWithTxt) {}
        ) {
            BaseContainerWithImage(
                item =
                    ImageWithCaptionItem.welcomeScreenItem()
            )
        }

        Logotype(
            modifier = Modifier
                .scale(0.43f)
                .constrainAs(logo) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        BaseMainButton(
            modifier = Modifier
                .constrainAs(crtBtn) {
                    top.linkTo(imgWithTxt.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(horizontal = 12.dp)
                .padding(top = 48.dp),
            caption = CreateAccountButtonCaption,
            onClick = navigateToCreate
        )

        Text(
            text = LaterButtonCaption,
            modifier = Modifier
                .constrainAs(ltrBtn) {
                    top.linkTo(crtBtn.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(vertical = 12.dp)
                .clickable { navigateToMain() },
            color = TextButtonColor,
            textDecoration = TextDecoration.Underline
        )
    }
}