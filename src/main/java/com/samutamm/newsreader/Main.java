
package com.samutamm.newsreader;

import com.samutamm.newsreader.spark.Server;


public class Main {
    public static void main(String[] args) {
        Newsreader reader = new Newsreader();
        new Server(reader).init();
    }
}
