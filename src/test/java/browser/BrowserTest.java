
package browser;

import com.google.gson.JsonObject;
import com.mycompany.hackernewsuutiset.HTTPClient;
import com.samutamm.newsreader.Newsreader;
import com.samutamm.newsreader.spark.Server;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class BrowserTest {
    public WebDriver webDriver = new HtmlUnitDriver();
    
    @Test
    public void test() {
        Newsreader reader = Mockito.mock(Newsreader.class);
        Mockito.when(reader.getNews()).thenReturn(new JsonObject());
        new Server(reader).init();
        String result = HTTPClient.callURL("http://localhost:4567/");
        Assert.assertTrue(result.contains("Newsreader"));
    }
}
