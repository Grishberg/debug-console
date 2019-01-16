package com.github.grishberg.consoleview

import com.github.grishberg.consoleview.console.Console
import com.github.grishberg.consoleview.console.ConsoleProxy

interface Logger {
    fun d(tag: String, message: String)
}

/**
 * Use this implementation to out messages to console.
 * By default used ConsoleProxy to link with ConsoleView.
 */
class LoggerImpl(private val console: Console) : Logger {
    constructor() : this(ConsoleProxy.getInstance())

    override fun d(tag: String, message: String) {
        console.addString(tag, message)
    }
}