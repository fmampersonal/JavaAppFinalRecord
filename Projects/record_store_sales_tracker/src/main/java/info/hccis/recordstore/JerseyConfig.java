package info.hccis.recordstore;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import info.hccis.recordstore.rest.RecordSaleService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Jersey configuration to register REST services.
 *
 * This replaces the need to manually map each REST endpoint in web.xml.
 *
 * @author Farhan
 */
@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    @PostConstruct
    private void init() {
        // Register your REST service class
        registerClasses(RecordSaleService.class);
    }
}
