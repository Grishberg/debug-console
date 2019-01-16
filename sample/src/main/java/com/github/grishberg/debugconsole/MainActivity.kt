package com.github.grishberg.debugconsole

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.grishberg.consoleview.LoggerImpl

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logger = LoggerImpl()
        logger.d("[TEST]", "msg1")
        logger.d("[TEST]", "msg2")
        logger.d("[TEST]", "msg3")
        logger.d("[TEST]", "Some long message 1) 111 222 333 444 555 6666 777 88 9999 10 10 10")
        logger.d("[TEST]", "Some long message 2) 111 222 333 444 555 6666 777 8888 9999 11119191")
    }
}
