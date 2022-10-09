package server.infrastructure.restTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.model.Error;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import server.domain.service.error.RestTemplateError;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
class RestTemplateResponseHandler implements ResponseErrorHandler {

    private record RestResponseErrorBody(LinkedHashMap jsonapi, List<Error> errors) { }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return !response.getStatusCode().is2xxSuccessful();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        RestResponseErrorBody errorResponse = new ObjectMapper().readValue(response.getBody(), RestResponseErrorBody.class);
        log.warn("External service returned error: {}", errorResponse.errors().stream().map(Error::getDetail).toList());
        throw new RestTemplateError(
                errorResponse
                        .errors()
                        .stream()
                        .map(error -> "external service returned: " + error.getDetail())
                        .toList());
    }
}
