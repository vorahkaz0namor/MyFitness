package com.resonance.myfitness.ui.splash

import androidx.annotation.DrawableRes
import com.resonance.resources.FirstPollItemAdditionalCaption
import com.resonance.resources.FirstPollItemMainCaption
import com.resonance.resources.ForthPollItemAdditionalCaption
import com.resonance.resources.ForthPollItemMainCaption
import com.resonance.resources.OtherOnboardingFirstCaption
import com.resonance.resources.OtherOnboardingLatinCaption
import com.resonance.resources.OtherOnboardingSecondCaption
import com.resonance.resources.OtherOnboardingThirdCaptionOne
import com.resonance.resources.OtherOnboardingThirdCaptionTwo
import com.resonance.resources.R
import com.resonance.resources.SecondPollItemAdditionalCaption
import com.resonance.resources.SecondPollItemMainCaption
import com.resonance.resources.ThirdPollItemAdditionalCaption
import com.resonance.resources.ThirdPollItemMainCaption
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

        fun firstPollScreenItems() = listOf(
            ImageWithCaptionItem(
                image = R.drawable.ic_weight_loss_48,
                mainCaption = FirstPollItemMainCaption,
                additionalCaption = FirstPollItemAdditionalCaption
            ),
            ImageWithCaptionItem(
                image = R.drawable.ic_stay_in_form_48,
                mainCaption = SecondPollItemMainCaption,
                additionalCaption = SecondPollItemAdditionalCaption
            ),
            ImageWithCaptionItem(
                image = R.drawable.ic_mass_increase_48,
                mainCaption = ThirdPollItemMainCaption,
                additionalCaption = ThirdPollItemAdditionalCaption
            ),
            ImageWithCaptionItem(
                image = R.drawable.ic_dumbbell,
                mainCaption = ForthPollItemMainCaption,
                additionalCaption = ForthPollItemAdditionalCaption
            ),
        )
    }
}