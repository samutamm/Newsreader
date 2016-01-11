
package com.samutamm.newsreader.spark;

import static spark.Spark.*;

public class Server {
    public void run() {
        get("/hello", (req, res) -> "Hello World");
        awaitInitialization();
    }
    
    public void closeServer() {
        stop();
    }
}
