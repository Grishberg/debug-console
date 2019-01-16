package com.github.grishberg.consoleview

import android.widget.TextView

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
}