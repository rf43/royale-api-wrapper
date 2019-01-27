package net.rf43.royaleapiwrapperkit.consumer

object RawPlayerModel {
    data class RawPlayer(val tag: String = "", val name: String = "", val trophies: Int = -1, val rank: Int = -1)
}

object RawPopularPlayerModel {
    data class RawPopularPlayer(val tag: String = "", val name: String = "", val trophies: Int = -1, val rank: Int = -1)
}

object RawTopPlayerModel {
    data class RawTopPlayer(val tag: String = "", val name: String = "", val trophies: Int = -1, val rank: Int = -1)
}