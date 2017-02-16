package br.com.italocomini.hello.resources;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HelloControllerTests {

    private static final Logger log = LoggerFactory.getLogger(HelloControllerTests.class);
    private HttpUriRequest request;

    @Before
    public void before() {
        this.request = new HttpGet("http://localhost:8080/api/hello/Brasil");
    }

    @Test
    public void testHelloV1() throws IOException {

        final String mimeType = "application/vnd.hello.api.v1+json";
        request.setHeader(HttpHeaders.ACCEPT, mimeType);

        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        log.info(EntityUtils.toString(response.getEntity()));

        String mimeTypeResponse = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertEquals(mimeType, mimeTypeResponse);
    }

    @Test
    public void testHelloV2() throws IOException {

        final String mimeType = "application/vnd.hello.api.v2+json";
        request.setHeader(HttpHeaders.ACCEPT, mimeType);

        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        log.info(EntityUtils.toString(response.getEntity()));

        String mimeTypeResponse = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertEquals(mimeType, mimeTypeResponse);

    }
}
