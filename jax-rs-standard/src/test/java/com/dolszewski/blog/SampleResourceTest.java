package com.dolszewski.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JaxRsDemoApplication.class)
@WebIntegrationTest
@ActiveProfiles({Profiles.JERSEY})
//@ActiveProfiles({Profiles.RESTEASY}) // This profile failes the test
public class SampleResourceTest {

    RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void shouldReturn304OnSecondRequest() throws Exception {
        ResponseEntity<String> firstResponse = callGetSample(null);

        long lastModified = firstResponse.getHeaders().getLastModified();
        HttpHeaders headers = new HttpHeaders();
        headers.setIfModifiedSince(lastModified);

        ResponseEntity<String> secondResponse = callGetSample(new HttpEntity<>(headers));

        assertEquals(HttpStatus.OK, firstResponse.getStatusCode());
        assertEquals(HttpStatus.NOT_MODIFIED, secondResponse.getStatusCode());
    }

    private ResponseEntity<String> callGetSample(HttpEntity<String> entity) {
        return restTemplate.exchange("http://localhost:8888/api/sample", HttpMethod.GET, entity, String.class);
    }

}