package code.name.monkey.retromusic.fragments.settings

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import code.name.monkey.retromusic.R

public class MainSettingsFragmentDirections private constructor() {
  public companion object {
    public fun actionMainSettingsFragmentToThemeSettingsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainSettingsFragment_to_themeSettingsFragment)

    public fun actionMainSettingsFragmentToImageSettingFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainSettingsFragment_to_imageSettingFragment)

    public fun actionMainSettingsFragmentToNowPlayingSettingsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainSettingsFragment_to_nowPlayingSettingsFragment)

    public fun actionMainSettingsFragmentToAudioSettings(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainSettingsFragment_to_audioSettings)

    public fun actionMainSettingsFragmentToOtherSettingsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainSettingsFragment_to_otherSettingsFragment)

    public fun actionMainSettingsFragmentToPersonalizeSettingsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainSettingsFragment_to_personalizeSettingsFragment)

    public fun actionMainSettingsFragmentToNotificationSettingsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainSettingsFragment_to_notificationSettingsFragment)

    public fun actionMainSettingsFragmentToAboutActivity(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainSettingsFragment_to_aboutActivity)

    public fun actionMainSettingsFragmentToBackupFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainSettingsFragment_to_backupFragment)
  }
}
