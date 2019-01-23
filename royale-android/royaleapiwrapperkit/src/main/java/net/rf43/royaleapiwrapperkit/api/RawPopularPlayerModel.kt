package net.rf43.royaleapiwrapperkit.api

object RawPopularPlayerModel {
    data class RawPopularPlayer(val tag: String = "", val name: String = "", val trophies: Int = -1, val rank: Int = -1)
}