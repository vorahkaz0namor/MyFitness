package com.resonance.myfitness.ui.poll

import androidx.lifecycle.ViewModel
import com.resonance.myfitness.application.App

class PollViewModel : ViewModel() {
    private var _progress: Int = 0
    val progress: Int
        get() = _progress

    init {
        App.getAppComponent().inject(this)
    }

    fun toNextPollScreen() {
        _progress += 1
    }

    fun toPreviousPollScreen() {
        _progress -= 1
    }
}