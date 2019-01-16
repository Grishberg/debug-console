package com.github.grishberg.consoleview

import android.widget.TextView
import com.github.grishberg.consoleview.console.Console

class MessagesItem(
    private val tag: String,
    private val message: String
) {
    fun writeTag(tagView: TextView) {
        tagView.text = tag
    }

    fun writeMessage(messageView: TextView) {
        messageView.text = message
    }

    fun delegateToConsole(console: Console) {
        console.addString(tag, message)
    }
}