package com.github.grishberg.consoleview

interface Logger {
    fun d(tag: String, message: String)
}

class LoggerImpl : Logger {
    override fun d(tag: String, message: String) {

    }
}