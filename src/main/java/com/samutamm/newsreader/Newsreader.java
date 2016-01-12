
package com.samutamm.newsreader;

import com.google.gson.JsonObject;
import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;


public class Newsreader {
    private HackerPaivanUutiset news;
    
    public Newsreader() {
        this.news = new HackerPaivanUutiset();
    }
    public Newsreader(HackerPaivanUutiset mock) {
        this.news = mock;
    }
    
    public JsonObject getNews() {
        JsonObject json = new JsonObject();
        String popularRaw = this.news.haeSuosituinUutinen();
        String[] popular = parse(popularRaw);
        json.addProperty("popularRaw", popularRaw);
        json.addProperty("popular", popular[0]);
        json.addProperty("popularURL", popular[1]);
        String latestRaw = this.news.haeViimeisinUutinen();
        String[] latest = parse(latestRaw);
        json.addProperty("latestRaw", latestRaw);
        json.addProperty("latest", latest[0]);
        json.addProperty("latestURL", latest[1]);
        return json;
    }

    private String[] parse(String input) {
        return input.split("url:");
    }
}
