package net.rf43.royaleapikit.callbacks

interface TopPlayerCallback<T> {
    fun onUpdate(playerList: List<T>?)
}