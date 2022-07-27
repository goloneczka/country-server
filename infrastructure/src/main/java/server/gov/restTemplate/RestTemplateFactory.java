package server.gov.restTemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateFactory {

    private final RestTemplateResponseHandler responseHandler;
    private final RestTemplateInterceptor restTemplateInterceptor;
    @Value("${gov.url}")
    private String govUrl;

    public RestTemplateFactory() {
        this.responseHandler = new RestTemplateResponseHandler();
        this.restTemplateInterceptor = new RestTemplateInterceptor();
    }

    @Bean
    public RestTemplate restTemplateBean(){
        return new RestTemplateBuilder()
                .rootUri(govUrl)
                .errorHandler(responseHandler)
                .interceptors(restTemplateInterceptor)
                .build();
    }

}
