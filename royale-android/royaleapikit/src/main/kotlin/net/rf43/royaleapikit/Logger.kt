package net.rf43.royaleapikit

import android.util.Log

class Logger(private val className: String? = null) {

    fun v(tag: String? = null, message: String, methodName: String? = null, throwable: Throwable?) {
        val logTag = getLogTag(tag)
        val logString = getLogMessage(message, className, methodName)
        if (throwable == null) {
            Log.v(logTag, logString)
        } else {
            Log.v(logTag, logString, throwable)
        }
    }

    fun i(tag: String? = null, message: String, methodName: String? = null, throwable: Throwable? = null) {
        val logTag = getLogTag(tag)
        val logString = getLogMessage(message, className, methodName)
        if (throwable == null) {
            Log.i(logTag, logString)
        } else {
            Log.i(logTag, logString, throwable)
        }
    }

    fun d(tag: String? = null, message: String, methodName: String? = null, throwable: Throwable? = null) {
        val logTag = getLogTag(tag)
        val logString = getLogMessage(message, className, methodName)
        if (throwable == null) {
            Log.d(logTag, logString)
        } else {
            Log.d(logTag, logString, throwable)
        }
    }

    fun w(tag: String? = null, message: String, methodName: String? = null, throwable: Throwable? = null) {
        val logTag = getLogTag(tag)
        val logString = getLogMessage(message, className, methodName)
        if (throwable == null) {
            Log.w(logTag, logString)
        } else {
            Log.w(logTag, logString, throwable)
        }
    }

    fun e(tag: String? = null, message: String, methodName: String? = null, throwable: Throwable? = null) {
        val logTag = getLogTag(tag)
        val logString = getLogMessage(message, className, methodName)
        if (throwable == null) {
            Log.e(logTag, logString)
        } else {
            Log.e(logTag, logString, throwable)
        }
    }

    private fun getLogTag(tag: String?): String {
        // If a tag has been provided, use that
        if (tag != null && tag.isNotEmpty()) {
            return tag
        }

        // If no tag has been provided, check to see if a classname has been provided
        if (className != null && className.isNotEmpty()) {
            return className
        }

        // If neither a tag nor a class name has been provided, default to UNKNOWN
        return "UNKNOWN"
    }

    private fun getLogMessage(message: String, className: String?, methodName: String?): String {
        var logString = message
        if (className != null && className.isNotEmpty() && methodName != null && methodName.isNotEmpty()) {
            logString = "[$className::$methodName] => $message"
        }
        return logString
    }
}