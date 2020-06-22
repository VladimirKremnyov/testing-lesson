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

    private static final String EMPTY_STRING = "";
    private static final String SHORTCUT = "someShortcut";
    private static final String URL = "eiuwqheiuqwiueqoihw";
    private static final int EXPECTED_SHORTCUT_LENGTH = 5;
    public static final String NO_SHORTCUT = null;
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
        when(database.findBy(contains("uwqhe"))).thenReturn(SHORTCUT);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        //WHEN
        urlShortener.shorten(URL);
        //THEN
        verify(database).findBy(captor.capture());
        verifyNoMoreInteractions(database);
        verify(database, times(0)).save(any(), any());
        assertEquals(URL, captor.getValue());
    }
    @Test
    public void shouldReturnFiveSymbolsShortCut() {
        //GIVEN
        when(database.findBy(contains("uwqhe"))).thenReturn(NO_SHORTCUT);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        //WHEN
        String shortcut = urlShortener.shorten(URL);
        //THEN
        verify(database).findBy(captor.capture());
        assertEquals(URL, captor.getValue());
        assertEquals(EXPECTED_SHORTCUT_LENGTH, shortcut.length());
    }

}
