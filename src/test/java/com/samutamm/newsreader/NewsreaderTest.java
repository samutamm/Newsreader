package com.samutamm.newsreader;

import com.google.gson.JsonObject;
import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;


public class NewsreaderTest {
    
    @Test
    public void testGetNews() {
        HackerPaivanUutiset uutiset = Mockito.mock(HackerPaivanUutiset.class);
        Mockito.when(uutiset.haeSuosituinUutinen()).thenReturn("Suosituin NEW, url: bolo");
        Mockito.when(uutiset.haeViimeisinUutinen()).thenReturn("Viimeisin NEW, url: molo");
        Newsreader reader = new Newsreader(uutiset);
        JsonObject news = reader.getNews();
        assertTrue(news.get("popularURL").toString().contains("bolo"));
        assertTrue(news.get("latestURL").toString().contains("molo"));
    }
    
}
