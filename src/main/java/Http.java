import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Http {
    public static void main(String[] args) {
        try {
            URI uri = new URIBuilder("website")
                    .setParameter("parameter", "value")
                    .build();
            HttpGet httpGet = new HttpGet(uri); //Could be HttpPost
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(httpGet);
            String myResponse = EntityUtils.toString(response.getEntity());
            Response responseObject = new ObjectMapper().readValue(myResponse, Response.class);

        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
