package info.hccis.recordstore.bo;

import info.hccis.recordstore.exception.AllAttributesNeededException;
import info.hccis.recordstore.jpa.entity.ArtistSaleList;
import info.hccis.recordstore.repositories.CodeValueRepository;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * Business logic class for record sales
 *
 * @author BJM
 * @since 20251024
 */
public class RecordSaleBO {

    public static final double COST_PER_UNIT = 10; // default price per unit
    public static final double DISCOUNT_VOLUME_10 = 0.1;
    public static final double DISCOUNT_VOLUME_20 = 0.15;

    /**
     * Process validation for the record sale
     */
    public boolean processValidation(HttpServletRequest request, MessageSource messageSource, ArtistSaleList recordSale) {
        boolean valid = processValidationArtistName(request, messageSource, recordSale)
                && processValidationUnitsSold(request, messageSource, recordSale);
        return valid;
    }

    /**
     * Validate that artist name is provided
     */
    public boolean processValidationArtistName(HttpServletRequest request, MessageSource messageSource, ArtistSaleList recordSale) {
        boolean valid;
        try {
            valid = processValidationArtistName(recordSale);
        } catch (AllAttributesNeededException aane) {
            valid = false;
            request.setAttribute("errorArtistName", aane.getMessage());
        }
        return valid;
    }

    /**
     * Ensure artist name is not empty
     */
    public boolean processValidationArtistName(ArtistSaleList recordSale) throws AllAttributesNeededException {
        String name = recordSale.getArtistName();
        if (name == null || name.trim().isEmpty()) {
            throw new AllAttributesNeededException("Artist name is required");
        }
        return true;
    }

    /**
     * Validate units sold
     */
    public boolean processValidationUnitsSold(HttpServletRequest request, MessageSource messageSource, ArtistSaleList recordSale) {
        boolean valid = true;
        if (recordSale.getUnitsSold() <= 0) {
            request.setAttribute("errorUnitsSold", "Units sold must be greater than 0");
            valid = false;
        }
        return valid;
    }

    /**
     * Calculate and set the sale amount
     */
    public ArtistSaleList processCost(ArtistSaleList recordSale) {
        double cost = calculateSaleAmount(recordSale.getUnitsSold());
        recordSale.setTotalCost((float) cost); // convert double to float
        return recordSale;
    }

    /**
     * Calculate sale amount based on units sold and volume discount
     */
    public double calculateSaleAmount(int unitsSold) {
        double discount = 0;
        if (unitsSold >= 20) {
            discount += DISCOUNT_VOLUME_20;
        } else if (unitsSold >= 10) {
            discount += DISCOUNT_VOLUME_10;
        }
        return unitsSold * COST_PER_UNIT * (1 - discount);
    }

    /**
     * Load record types from the database into session if needed (optional)
     */
    public static void loadRecordTypes(HttpSession session, CodeValueRepository _cvr) {
        if (session.getAttribute("recordTypes") == null) {
            List<?> recordTypes = _cvr.findByCodeTypeId(2); // or adapt as needed
            session.setAttribute("recordTypes", recordTypes);
        }
    }
}
