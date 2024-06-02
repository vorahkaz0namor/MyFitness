package com.resonance.myfitness.ui.splash

import androidx.annotation.DrawableRes
import com.resonance.resources.OtherOnboardingFirstCaption
import com.resonance.resources.OtherOnboardingLatinCaption
import com.resonance.resources.OtherOnboardingSecondCaption
import com.resonance.resources.OtherOnboardingThirdCaptionOne
import com.resonance.resources.OtherOnboardingThirdCaptionTwo
import com.resonance.resources.R
import com.resonance.resources.WelcomeScreenAdditionalCaption
import com.resonance.resources.WelcomeScreenMainCaption

data class ImageWithCaptionItem(
    @DrawableRes
    val image: Int,
    val mainCaption: String,
    val additionalCaption: String? = null
) {
    companion object {
        fun onboardingItems() = listOf(
            ImageWithCaptionItem(
                image = R.drawable.onboarding2_img,
                mainCaption = OtherOnboardingFirstCaption,
                additionalCaption = OtherOnboardingLatinCaption
            ),
            ImageWithCaptionItem(
                image = R.drawable.onboarding3_img,
                mainCaption = OtherOnboardingSecondCaption,
                additionalCaption = OtherOnboardingLatinCaption
            ),
            ImageWithCaptionItem(
                image = R.drawable.onboarding4_img,
                mainCaption = OtherOnboardingThirdCaptionOne,
                additionalCaption = OtherOnboardingThirdCaptionTwo
            ),
        )

        fun welcomeScreenItem() = ImageWithCaptionItem(
            image = R.drawable.welcome_screen_background_photo,
            mainCaption = WelcomeScreenMainCaption,
            additionalCaption = WelcomeScreenAdditionalCaption,
        )
    }
}