package net.rf43.royaleapiwrapperkit.api

object RawPlayerModel {
    data class RawPlayer(val tag: String = "", val name: String = "", val trophies: Int = -1, val rank: Int = -1)
}