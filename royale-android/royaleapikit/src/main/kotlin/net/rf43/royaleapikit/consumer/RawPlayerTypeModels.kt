package net.rf43.royaleapikit.consumer

object RawPlayerModel {
    data class RawPlayer(val tag: String? = null, val name: String? = null, val trophies: Int?, val rank: Int?)
}

object RawPopularPlayerModel {
    data class RawPopularPlayer(val tag: String?, val name: String?, val trophies: Int?, val rank: Int?)
}

object RawTopPlayerModel {
    data class RawTopPlayer(val tag: String?, val name: String?, val trophies: Int?, val rank: Int?)
}