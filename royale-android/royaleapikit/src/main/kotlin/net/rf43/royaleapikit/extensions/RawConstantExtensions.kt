package net.rf43.royaleapikit.extensions

import net.rf43.royaleapikit.consumer.RawConstantsModel

fun RawConstantsModel.RawConstant?.isValid(): Boolean {
    if (this == null) {
        return false
    }

    return true
}
