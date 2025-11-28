package info.hccis.recordstore.soap;

import javax.xml.ws.Endpoint;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecordSaleServicePublisher {

    public static void main(String[] args) {
        Endpoint.publish(
                "http://localhost:8083/recordsalesoapservice",
                new RecordSaleServiceSOAPImpl(null)
        );
        System.out.println("RecordSale SOAP service running at http://localhost:8083/recordsalesoapservice?wsdl");
    }
}
