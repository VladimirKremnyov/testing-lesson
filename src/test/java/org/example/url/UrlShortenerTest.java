package org.example.url;

import org.example.url.db.ShortcutsDatabase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UrlShortenerTest {

    public static final String EMPTY_STRING = "";
    public static final String SHORTCUT = "someShortcut";
    public static final String EMPTY_SHORTCUT = null;
    public static final String URL = "eiuwqheiuqwiueqoihw";
    private static ShortcutsDatabase database;
    private static UrlShortener urlShortener;

    @Before
    public void setup() {
        database = mock(ShortcutsDatabase.class);
        urlShortener = new UrlShortener(database);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenEmptyStringPassed() {
        urlShortener.shorten(EMPTY_STRING);
    }

    @Test
    public void shouldUseValueFromDBWhenItIsPresent() {
        //GIVEN
        when(database.findBy(contains("uwqhe"))).thenReturn(EMPTY_SHORTCUT);

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        //WHEN
        urlShortener.shorten(URL);
        //THEN

        verify(database).findBy(captor.capture());

        verify(database).save(eq(URL), anyString());

        verifyNoMoreInteractions(database);
        assertEquals(URL, captor.getValue());
    }

}
