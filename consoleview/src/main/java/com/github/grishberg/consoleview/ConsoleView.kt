package com.github.grishberg.consoleview

interface Console {
    fun addString(tag: String, message: String)
}

class ConsoleView : Console {
    override fun addString(tag: String, message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}