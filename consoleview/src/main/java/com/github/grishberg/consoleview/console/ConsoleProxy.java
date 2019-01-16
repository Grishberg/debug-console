package com.github.grishberg.consoleview.console;


import com.github.grishberg.consoleview.MessagesItem;

import java.util.ArrayList;
import java.util.Iterator;

public class ConsoleProxy implements Console {
    private final ConsoleStub defaultConsole = new ConsoleStub();
    private static ConsoleProxy sInstance;
    private Console console = defaultConsole;

    public static synchronized ConsoleProxy getInstance() {
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
        defaultConsole.resendMessagesToConsole(console);
    }

    public void deattachConsoleView() {
        this.console = defaultConsole;
    }

    private static class ConsoleStub implements Console {
        private ArrayList<MessagesItem> pendingItems = new ArrayList<>();

        @Override
        public void addString(String tag, String message) {
            pendingItems.add(new MessagesItem(tag, message));
        }

        void resendMessagesToConsole(Console console) {
            Iterator<MessagesItem> iterator = pendingItems.iterator();
            while (iterator.hasNext()) {
                MessagesItem item = iterator.next();
                item.delegateToConsole(console);
                iterator.remove();
            }
        }
    }
}
