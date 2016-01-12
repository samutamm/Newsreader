
package com.samutamm.newsreader.spark;

import com.samutamm.newsreader.Newsreader;
import static spark.Spark.*;

public class Server {
    
    private Newsreader reader;

    public Server(Newsreader reader) {
        this.reader = reader;
    }
    
    public void run() {
        configureServer();
        createRoutes();
        awaitInitialization();
    }

    private void configureServer() {
      String port = System.getenv("PORT");
      System.out.println(port);
      if(port != null) {
          System.out.println(port);
          port(Integer.parseInt(port));
      }
      staticFileLocation("/public");
    }

    private void createRoutes() {
      get("/hello", (req, res) -> "Hello World");
      get("/news", (req, res) -> this.reader.getNews());
    }

    public void closeServer() {
        stop();
    }
}
