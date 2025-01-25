package code.name.monkey.retromusic.extensions

import code.name.monkey.retromusic.helper.MusicPlayerRemote
import java.io.File

fun getSongPath(): String {
    val song = MusicPlayerRemote.currentSong
    val currentSongPath = File(song.data).path
    val currentFolder = currentSongPath.replace(Regex("^/storage/emulated/[^/]+/"), "")
        .substringBeforeLast("/")
        .replace("/", " > ")
    return currentFolder
}