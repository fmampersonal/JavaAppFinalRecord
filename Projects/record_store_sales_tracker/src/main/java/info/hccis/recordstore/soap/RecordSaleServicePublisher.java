package info.hccis.recordstore.soap;

import info.hccis.recordstore.rest.RecordSaleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.ws.Endpoint;

public class RecordSaleServicePublisher {

    public static void main(String[] args) {
        // Initialize Spring context
        // Your Spring config class

        // Get the bean for RecordSaleServiceSOAPImpl
        // Publish the SOAP service using the Spring-managed bean
        Endpoint.publish(
                "http://0.0.0.0:8083/recordsalesoapservice",
                new RecordSaleServiceSOAPImpl());

        System.out.println("RecordSale SOAP service running at http://localhost:8083/recordsalesoapservice?wsdl");
    }
}
