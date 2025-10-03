package ca.hccis.recordstore.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the calculations done in Record Store Class
 * @author Farhan
 * @since 2025-09
 */

class RecordSaleTest {

    private RecordSale sale;

    @BeforeEach
    void setUp() {
        sale = new RecordSale();
    }

    @Test
    void testVinylNoGiftWrap() {
        saleTestHelper("Vinyl", false, 15.0, 15.0, 17.25);
    }

    @Test
    void testVinylWithGiftWrap() {
        saleTestHelper("Vinyl", true, 15.0, 17.0, 19.55);
    }

    @Test
    void testCdNoGiftWrap() {
        saleTestHelper("CD", false, 10.0, 10.0, 11.50);
    }

    @Test
    void testCdWithGiftWrap() {
        saleTestHelper("CD", true, 10.0, 12.0, 13.80);
    }

    @Test
    void testCassetteNoGiftWrap() {
        saleTestHelper("Cassette", false, 5.0, 5.0, 5.75);
    }

    @Test
    void testCassetteWithGiftWrap() {
        saleTestHelper("Cassette", true, 5.0, 7.0, 8.05);
    }

    @Test
    void testGiftWrapOnlyAddsTwoDollars() {
        sale.setFormatType("CD");
        sale.setGiftWrapped(true);
        sale.calculateTotals();
        assertEquals(12.0, sale.getSubtotal());
    }

    @Test
    void testTaxCalculationIs15Percent() {
        sale.setFormatType("Vinyl");
        sale.setGiftWrapped(false);
        sale.calculateTotals();
        assertEquals(sale.getSubtotal() * 1.15, sale.getTotalCost(), 0.0001);
    }

    @Test
    void testAlbumPriceMatchesFormatCd() {
        sale.setFormatType("CD");
        sale.setGiftWrapped(false);
        sale.calculateTotals();
        assertEquals(10.0, sale.getAlbumPrice());
    }

    @Test
    void testAlbumPriceMatchesFormatVinyl() {
        sale.setFormatType("Vinyl");
        sale.setGiftWrapped(false);
        sale.calculateTotals();
        assertEquals(15.0, sale.getAlbumPrice());
    }

    @Test
    void testSaleObjectIsNotNull() {
        assertNotNull(sale);
    }


    // === Helper Method for Reducing Duplication ===
    private void saleTestHelper(String format, boolean giftWrap,
                                double expectedPrice, double expectedSubtotal, double expectedTotal) {
        sale.setFormatType(format);
        sale.setGiftWrapped(giftWrap);
        sale.calculateTotals();
        assertEquals(expectedPrice, sale.getAlbumPrice());
        assertEquals(expectedSubtotal, sale.getSubtotal());
        assertEquals(expectedTotal, sale.getTotalCost(), 0.001);
    }
}