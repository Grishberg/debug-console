package com.github.grishberg.consoleview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.util.*

class MessagesAdapter : RecyclerView.Adapter<MessageViewHolder>() {
    private val messages = ArrayList<MessagesItem>()

    fun addMessage(tag: String, message: String) {
        messages.add(MessagesItem(tag, message))
        notifyItemInserted(messages.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false)
        return MessageViewHolder(view)
    }

    override fun getItemCount(): Int = messages.size

    override fun onBindViewHolder(vh: MessageViewHolder, pos: Int) {
        vh.bind(messages[pos])
    }
}