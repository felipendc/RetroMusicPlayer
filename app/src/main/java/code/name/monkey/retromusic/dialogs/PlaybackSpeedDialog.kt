package code.name.monkey.retromusic.dialogs

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import code.name.monkey.retromusic.R
import code.name.monkey.retromusic.databinding.DialogPlaybackSpeedBinding
import code.name.monkey.retromusic.extensions.accent
import code.name.monkey.retromusic.extensions.colorButtons
import code.name.monkey.retromusic.extensions.materialDialog
import code.name.monkey.retromusic.util.PreferenceUtil
import com.google.android.material.slider.Slider
import code.name.monkey.retromusic.Singletons.PlaybackPeedSliderObservableSingleton
import java.util.Locale

class PlaybackSpeedDialog : DialogFragment() {

    private val _floatObserver = PlaybackPeedSliderObservableSingleton

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val lastPlaybackSpeed = PreferenceUtil.playbackSpeed
        val lastPlaybackPitch = PreferenceUtil.playbackPitch

        val binding = DialogPlaybackSpeedBinding.inflate(layoutInflater)
        binding.playbackSpeedSlider.accent()
        binding.playbackPitchSlider.accent()
        PreferenceUtil.playbackSpeed.toString().also { binding.speedValue.text = it }
        PreferenceUtil.playbackPitch.toString().also { binding.pitchValue.text = it }

        binding.playbackSpeedSlider.addOnChangeListener(Slider.OnChangeListener { _, value, _ ->
            // Format as a float with 2 decimal places
            // If the decimal part is "00", format it to 1 decimal place
            // Otherwise, use the 2 decimal places format
            val formattedSpeedValue = String.format(Locale.US, "%.2f", value)
            val finalSpeedValue = if (formattedSpeedValue.endsWith(".00")) {
                String.format(Locale.US, "%.1f", value)
            } else {
                formattedSpeedValue
            }
            binding.speedValue.text = finalSpeedValue
            PreferenceUtil.playbackSpeed = finalSpeedValue.toFloat()
            _floatObserver.updateValue(value)
        })
        binding.playbackPitchSlider.addOnChangeListener(Slider.OnChangeListener { _, value, _ ->
            // Format as a float with 2 decimal places
            // If the decimal part is "00", format it to 1 decimal place
            // Otherwise, use the 2 decimal places format
            val formattedPitchValue = String.format(Locale.US, "%.2f", value)
            val finalPitchValue = if (formattedPitchValue.endsWith(".00")) {
                String.format(Locale.US, "%.1f", value)
            } else {
                formattedPitchValue
            }
            binding.pitchValue.text = finalPitchValue
            PreferenceUtil.playbackPitch = finalPitchValue.toFloat()
        })
        binding.playbackSpeedSlider.value = PreferenceUtil.playbackSpeed
        binding.playbackPitchSlider.value = PreferenceUtil.playbackPitch

        return materialDialog(R.string.playback_settings)
            .setNegativeButton(android.R.string.cancel) { _, _ ->
                PreferenceUtil.playbackSpeed = lastPlaybackSpeed
                PreferenceUtil.playbackPitch = lastPlaybackPitch
                binding.playbackSpeedSlider.value = lastPlaybackSpeed
                binding.playbackPitchSlider.value = lastPlaybackPitch
                _floatObserver.updateValue(lastPlaybackSpeed)
            }
            .setPositiveButton(R.string.save, null)
            .setNeutralButton(R.string.reset_action) {_, _ ->
                updatePlaybackAndPitch(
                    1F,
                    1F
                )
            }
            .setView(binding.root)
            .create()
            .colorButtons()
    }

    private fun updatePlaybackAndPitch(speed: Float, pitch: Float) {
        PreferenceUtil.playbackSpeed = speed
        PreferenceUtil.playbackPitch = pitch
        _floatObserver.updateValue(1F)
    }

    companion object {
        fun newInstance(): PlaybackSpeedDialog {
            return PlaybackSpeedDialog()
        }
    }
}