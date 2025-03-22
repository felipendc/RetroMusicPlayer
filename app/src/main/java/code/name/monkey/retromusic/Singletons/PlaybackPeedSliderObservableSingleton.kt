package code.name.monkey.retromusic.Singletons

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


object PlaybackPeedSliderObservableSingleton {
    private val _floatValue = MutableStateFlow(0.0f)
    val floatValue: StateFlow<Float> get() = _floatValue

    fun updateValue(newValue: Float) {
        _floatValue.value = newValue
    }
}