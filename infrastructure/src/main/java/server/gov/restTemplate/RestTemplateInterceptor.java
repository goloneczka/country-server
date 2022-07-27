package server.gov.restTemplate;

import ch.qos.logback.core.net.server.Client;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request,
                                        byte[] body, ClientHttpRequestExecution execution) throws IOException {

        //TODO:
        // add some fancy logging
        request.getHeaders().add("accept", MediaType.APPLICATION_JSON_VALUE);
        return execution.execute(request, body);
    }
}
