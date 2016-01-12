
package com.samutamm.newsreader.spark;

import static spark.Spark.*;

public class Server {
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
      get("/news", (req, res) -> "News coming!");
    }

    public void closeServer() {
        stop();
    }
}
