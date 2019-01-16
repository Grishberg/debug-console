package com.github.grishberg.consoleview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tagView = view.findViewById<TextView>(R.id.itemTag)
    private val messageView = view.findViewById<TextView>(R.id.itemText)

    fun bind(messagesItem: MessagesItem) {
        messagesItem.writeTag(tagView)
        messagesItem.writeMessage(messageView)
    }

}