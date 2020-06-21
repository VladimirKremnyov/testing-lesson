package org.example.url.db;

import java.util.HashMap;
import java.util.Map;

public class ShortcutsDatabase {

    private final Map<String, String> urlOnShortcut = new HashMap<>();

    public String findBy(String url) {
        return urlOnShortcut.get(url);
    }

    public void save(String url, String shortcut) {
        urlOnShortcut.put(url, shortcut);
    }

}
