package code.name.monkey.retromusic.fragments.artists

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Long
import kotlin.jvm.JvmStatic

public data class ArtistDetailsFragmentArgs(
  public val extraArtistId: Long,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putLong("extra_artist_id", this.extraArtistId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("extra_artist_id", this.extraArtistId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): ArtistDetailsFragmentArgs {
      bundle.setClassLoader(ArtistDetailsFragmentArgs::class.java.classLoader)
      val __extraArtistId : Long
      if (bundle.containsKey("extra_artist_id")) {
        __extraArtistId = bundle.getLong("extra_artist_id")
      } else {
        throw IllegalArgumentException("Required argument \"extra_artist_id\" is missing and does not have an android:defaultValue")
      }
      return ArtistDetailsFragmentArgs(__extraArtistId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): ArtistDetailsFragmentArgs {
      val __extraArtistId : Long?
      if (savedStateHandle.contains("extra_artist_id")) {
        __extraArtistId = savedStateHandle["extra_artist_id"]
        if (__extraArtistId == null) {
          throw IllegalArgumentException("Argument \"extra_artist_id\" of type long does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"extra_artist_id\" is missing and does not have an android:defaultValue")
      }
      return ArtistDetailsFragmentArgs(__extraArtistId)
    }
  }
}
