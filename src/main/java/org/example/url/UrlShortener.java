package org.example.url;

import org.example.url.db.ShortcutsDatabase;

import java.util.UUID;

public class UrlShortener {

    public static final int BEGIN_INDEX = 0;
    public static final int END_INDEX = 5;
    private final ShortcutsDatabase database;

    public UrlShortener(ShortcutsDatabase database) {
        this.database = database;
    }

    public String shorten(String url) {
        validate(url);
        String shortcut = database.findBy(url);
        if (shortcut != null) {
            return shortcut;
        }
        shortcut = UUID.randomUUID().toString().substring(BEGIN_INDEX, END_INDEX);
        database.save(url, shortcut);
        return shortcut;
    }

    private void validate(String url) {
        if (url.isEmpty()) {
            throw new IllegalArgumentException("Can not process empty string");
        }
    }

}
