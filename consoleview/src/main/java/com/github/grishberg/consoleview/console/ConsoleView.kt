package com.github.grishberg.consoleview.console

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import com.github.grishberg.consoleview.MessagesAdapter

interface Console {
    fun addString(tag: String, message: String)
}

/**
 * Use this view to out log events on screen
 * */
class ConsoleView : RecyclerView, Console {
    private val consoleProxy: ConsoleProxy
    private val adapter = MessagesAdapter()

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : this(
        context,
        attrs,
        defStyle,
        ConsoleProxy.getInstance()
    )

    constructor(
        context: Context,
        attrs: AttributeSet?,
        style: Int,
        console: ConsoleProxy
    ) : super(
        context, attrs, style
    ) {
        consoleProxy = console
        setAdapter(adapter)
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        setLayoutManager(layoutManager)
    }

    override fun addString(tag: String, message: String) {
        adapter.addMessage(tag, message)
        scrollToPosition(adapter.itemCount - 1)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        consoleProxy.attachConsoleView(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        consoleProxy.deattachConsoleView()
    }
}