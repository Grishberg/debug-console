package com.github.grishberg.consoleview.console;


import org.jetbrains.annotations.NotNull;

public class ConsoleProxy implements Console {
    private static final Console CONSOLE_STUB = new Console() {
        @Override
        public void addString(@NotNull String tag, @NotNull String message) {
            /* stub */
        }
    };
    private static ConsoleProxy sInstance;
    private Console console;

    public synchronized static ConsoleProxy getInstance() {
        if (sInstance == null) {
            sInstance = new ConsoleProxy();
        }
        return sInstance;
    }

    @Override
    public void addString(String tag, String message) {
        console.addString(tag, message);
    }


    public void attachConsoleView(Console console) {
        this.console = console;
    }

    public void deattachConsoleView() {
        this.console = CONSOLE_STUB;
    }

}
