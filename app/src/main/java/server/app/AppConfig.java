package server.app;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.DispatcherServlet;
import server.domain.service.GovServiceImpl;
import server.domain.service.ports.GovPersistencePort;
import server.domain.service.ports.GovServicePort;
import server.gov.BeanConfig;

@Configuration
@Import({BeanConfig.class})
public class AppConfig {

    private final GovPersistencePort govPersistencePort;

    public AppConfig(GovPersistencePort govPersistencePort) {
        this.govPersistencePort = govPersistencePort;
    }

    @Bean
    public GovServicePort govService(){
        return new GovServiceImpl(govPersistencePort);
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
