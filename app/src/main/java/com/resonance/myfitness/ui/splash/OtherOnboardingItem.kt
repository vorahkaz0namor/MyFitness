package com.resonance.myfitness.ui.splash

import androidx.annotation.DrawableRes
import com.resonance.resources.OtherOnboardingFirstCaption
import com.resonance.resources.OtherOnboardingSecondCaption
import com.resonance.resources.OtherOnboardingThirdCaptionOne
import com.resonance.resources.R

data class OtherOnboardingItem(
    @DrawableRes
    val image: Int,
    val caption: String,
    val showLatinCaption: Boolean = true
) {
    companion object {
        fun onboardingItems() = listOf(
            OtherOnboardingItem(
                image = R.drawable.onboarding2_img,
                caption = OtherOnboardingFirstCaption
            ),
            OtherOnboardingItem(
                image = R.drawable.onboarding3_img,
                caption = OtherOnboardingSecondCaption
            ),
            OtherOnboardingItem(
                image = R.drawable.onboarding4_img,
                caption = OtherOnboardingThirdCaptionOne,
                showLatinCaption = false
            ),
        )
    }
}