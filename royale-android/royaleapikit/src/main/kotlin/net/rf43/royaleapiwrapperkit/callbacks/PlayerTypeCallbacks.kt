package net.rf43.royaleapiwrapperkit.callbacks

interface TopPlayerCallback<T> {
    fun onUpdate(playerList: List<T>?)
}