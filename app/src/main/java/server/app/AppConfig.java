package server.app;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.DispatcherServlet;
import server.domain.service.GovServiceImpl;
import server.domain.service.LocationServiceImpl;
import server.domain.service.ports.GovPersistencePort;
import server.domain.service.ports.GovServicePort;
import server.domain.service.ports.LocationPersistencePort;
import server.domain.service.ports.LocationServicePort;
import server.infrastructure.location.LocationConfiguration;
import server.infrastructure.restTemplate.GovConfiguration;

@Configuration
@Import({GovConfiguration.class, LocationConfiguration.class})
public class AppConfig {

    private final GovPersistencePort govPersistencePort;
    private final LocationPersistencePort locationPersistencePort;


    public AppConfig(GovPersistencePort govPersistencePort,
                      LocationPersistencePort locationPersistencePort) {
        this.govPersistencePort = govPersistencePort;
        this.locationPersistencePort = locationPersistencePort;
    }

    @Bean
    public GovServicePort govService(){
        return new GovServiceImpl(govPersistencePort);
    }

    @Bean
    public LocationServicePort locationService(){
        return new LocationServiceImpl(locationPersistencePort);
    }

    @Bean
    public ServletRegistrationBean dispatcherRegistration() {
        return new ServletRegistrationBean(dispatcherServlet());
    }

    @Bean(name = DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet dispatcherServlet() {
        return new LoggingServlet();
    }
}
