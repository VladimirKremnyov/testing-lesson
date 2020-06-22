package org.example.url.db;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShortcutsDatabaseTest {
    public static final String URL = "url";
    public static final String SHORTCUT = "shortcut";

    @Test
    public void shouldRetrieveSavedValueFromDB () {
        //GIVEN
        ShortcutsDatabase database = new ShortcutsDatabase();
        database.save(URL, SHORTCUT);
        //WHEN
        String actualShortCut = database.findBy(URL);
        //THEN
        assertEquals(SHORTCUT, actualShortCut);
    }


}
