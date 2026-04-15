
package org.example.soaprecord;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.soaprecord package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetSaleById_QNAME = new QName("http://soap.recordstore.hccis.info/", "getSaleById");
    private final static QName _GetTransactions_QNAME = new QName("http://soap.recordstore.hccis.info/", "getTransactions");
    private final static QName _GetAllSales_QNAME = new QName("http://soap.recordstore.hccis.info/", "getAllSales");
    private final static QName _GetTransactionsResponse_QNAME = new QName("http://soap.recordstore.hccis.info/", "getTransactionsResponse");
    private final static QName _GetSaleByIdResponse_QNAME = new QName("http://soap.recordstore.hccis.info/", "getSaleByIdResponse");
    private final static QName _GetAllSalesResponse_QNAME = new QName("http://soap.recordstore.hccis.info/", "getAllSalesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.soaprecord
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllSales }
     * 
     */
    public GetAllSales createGetAllSales() {
        return new GetAllSales();
    }

    /**
     * Create an instance of {@link GetSaleById }
     * 
     */
    public GetSaleById createGetSaleById() {
        return new GetSaleById();
    }

    /**
     * Create an instance of {@link GetTransactions }
     * 
     */
    public GetTransactions createGetTransactions() {
        return new GetTransactions();
    }

    /**
     * Create an instance of {@link GetSaleByIdResponse }
     * 
     */
    public GetSaleByIdResponse createGetSaleByIdResponse() {
        return new GetSaleByIdResponse();
    }

    /**
     * Create an instance of {@link GetTransactionsResponse }
     * 
     */
    public GetTransactionsResponse createGetTransactionsResponse() {
        return new GetTransactionsResponse();
    }

    /**
     * Create an instance of {@link GetAllSalesResponse }
     * 
     */
    public GetAllSalesResponse createGetAllSalesResponse() {
        return new GetAllSalesResponse();
    }

    /**
     * Create an instance of {@link ArtistSaleList }
     * 
     */
    public ArtistSaleList createArtistSaleList() {
        return new ArtistSaleList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSaleById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.recordstore.hccis.info/", name = "getSaleById")
    public JAXBElement<GetSaleById> createGetSaleById(GetSaleById value) {
        return new JAXBElement<GetSaleById>(_GetSaleById_QNAME, GetSaleById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.recordstore.hccis.info/", name = "getTransactions")
    public JAXBElement<GetTransactions> createGetTransactions(GetTransactions value) {
        return new JAXBElement<GetTransactions>(_GetTransactions_QNAME, GetTransactions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSales }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.recordstore.hccis.info/", name = "getAllSales")
    public JAXBElement<GetAllSales> createGetAllSales(GetAllSales value) {
        return new JAXBElement<GetAllSales>(_GetAllSales_QNAME, GetAllSales.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.recordstore.hccis.info/", name = "getTransactionsResponse")
    public JAXBElement<GetTransactionsResponse> createGetTransactionsResponse(GetTransactionsResponse value) {
        return new JAXBElement<GetTransactionsResponse>(_GetTransactionsResponse_QNAME, GetTransactionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSaleByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.recordstore.hccis.info/", name = "getSaleByIdResponse")
    public JAXBElement<GetSaleByIdResponse> createGetSaleByIdResponse(GetSaleByIdResponse value) {
        return new JAXBElement<GetSaleByIdResponse>(_GetSaleByIdResponse_QNAME, GetSaleByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSalesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.recordstore.hccis.info/", name = "getAllSalesResponse")
    public JAXBElement<GetAllSalesResponse> createGetAllSalesResponse(GetAllSalesResponse value) {
        return new JAXBElement<GetAllSalesResponse>(_GetAllSalesResponse_QNAME, GetAllSalesResponse.class, null, value);
    }

}
