
package com.samutamm.newsreader.spark;

import static spark.Spark.*;

public class Server {
    public void run() {
        String port = System.getenv("PORT");
        System.out.println(port);
        if(port != null) {
            System.out.println(port);
            port(Integer.parseInt(port));
        }
        
        get("/hello", (req, res) -> "Hello World");
        get("/", (req, res) -> "Bolobolo");
        awaitInitialization();
    }

    public void closeServer() {
        stop();
    }
}
