package code.name.monkey.retromusic.extensions

import code.name.monkey.retromusic.helper.MusicPlayerRemote
import java.io.File

fun getCurrentSongFolder(): String {
    return File(MusicPlayerRemote.currentSong.data).path.replace(Regex("^/storage/emulated/[^/]+/"), "")
        .substringBeforeLast("/").replace("/", " > ")
}