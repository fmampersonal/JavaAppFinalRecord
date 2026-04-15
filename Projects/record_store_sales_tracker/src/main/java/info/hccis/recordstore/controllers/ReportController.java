package info.hccis.recordstore.controllers;

import info.hccis.recordstore.dao.RecordSaleDAO;
import info.hccis.recordstore.entity.ReportRecordStore;
import info.hccis.recordstore.jpa.entity.ArtistSaleList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Controller to handle record store sales reports.
 * Handles report input, output, and file writing.
 *
 * @author BJM
 * @since 20251024
 */
@Controller
@RequestMapping("/report")
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    /**
     * Show main report list page.
     */
    @RequestMapping("")
    public String home(Model model, HttpSession session) {
        logger.info("Running the reports controller base method");
        return "report/list"; // main report menu view
    }

    /**
     * Show artist report input form.
     */
    @RequestMapping("/artist")
    public String reportArtist(Model model) {
        logger.info("Running artist report input method");
        model.addAttribute("reportInput", new ReportRecordStore());
        return "report/reportArtist"; // input form view
    }

    /**
     * Process artist sales report submission.
     */
    @RequestMapping("/artist/submit")
    public String reportArtistSubmit(Model model, @ModelAttribute("reportInput") ReportRecordStore report) {
        logger.info("Artist from input form: " + report.getArtistName());

        // Fetch data from DAO using the updated method
        RecordSaleDAO recordSaleDao = new RecordSaleDAO();
        ArrayList<ArtistSaleList> salesList = recordSaleDao.selectSalesByArtistName(report.getArtistName());
        report.setRecordSales(salesList);

        // Message if no data found
        if (salesList == null || salesList.isEmpty()) {
            model.addAttribute("message", "No sales found for that artist");
            logger.info("No data found for artist: " + report.getArtistName());
        }

        // Write report to file
        writeReportToFile(report);

        // Put report object in model for the view
        model.addAttribute("reportInput", report);

        return "report/reportArtist"; // return to same view showing results
    }

    /**
     * Write the report results to a file in c:\cis2232\
     */
    private void writeReportToFile(ReportRecordStore report) {
        if (report.getRecordSales() == null || report.getRecordSales().isEmpty()) {
            return; // nothing to write
        }

        try {
            File dir = new File("c:\\cis2232\\");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String filename = "ArtistSalesReport_" + timestamp + ".txt";
            File file = new File(dir, filename);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("Sales report for artist: " + report.getArtistName());
                writer.newLine();
                writer.write("--------------------------------------------------");
                writer.newLine();
                for (ArtistSaleList sale : report.getRecordSales()) {
                    writer.write(
                            sale.getDateOfSale() + " | " +
                                    sale.getCustomerName() + " | " +
                                    sale.getArtistName() + " | " +
                                    sale.getFormatType() + " | " +
                                    sale.getAlbumPrice() + " | " +
                                    sale.getGiftWrapped() + " | " +
                                    sale.getSubtotal() + " | " +
                                    sale.getTotalCost()
                    );
                    writer.newLine();
                }
            }

            logger.info("Report written to file: " + file.getAbsolutePath());

        } catch (IOException e) {
            logger.error("Error writing report to file", e);
        }
    }
}
