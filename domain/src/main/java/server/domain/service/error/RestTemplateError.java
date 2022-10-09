package server.domain.service.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class RestTemplateError extends RuntimeException {

    @Getter
    private List<String> errorMessages;

}
