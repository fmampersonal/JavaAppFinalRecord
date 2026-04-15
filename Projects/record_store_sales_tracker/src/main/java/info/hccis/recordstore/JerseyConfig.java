package info.hccis.recordstore;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import info.hccis.recordstore.rest.RecordSaleService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Configuration
@EnableJpaRepositories(basePackages = "info.hccis.recordstore.repositories")
@ComponentScan(basePackages = "info.hccis.recordstore")
@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    @PostConstruct
    private void init() {
        registerClasses(RecordSaleService.class);
    }
}
