package com.samutamm.newsreader.spark;

import com.mycompany.hackernewsuutiset.HTTPClient;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.rules.Timeout;

public class ServerTest {
    
    private String serverURL = "http://localhost:4567/hello";
    private Server server;
    
    @Before
    public void setUp() throws Exception {
        server = new Server();
        server.run();
    }
    
    @After
    public void clear() {
       server.closeServer();
    }

    @Test
    public void testRun() {
        
        assertEquals("Hello World", HTTPClient.callURL(serverURL));
    }
    
}
