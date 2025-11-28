package info.hccis.recordstore.controllers;

import info.hccis.recordstore.jpa.entity.ArtistSaleList;
import info.hccis.recordstore.repositories.RecordSaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;


@Controller
@RequestMapping("/recordsale")
public class RecordSaleTransactionController {

    private final RecordSaleRepository recordSaleRepository;

    @Autowired
    public RecordSaleTransactionController(RecordSaleRepository recordSaleRepository) {
        this.recordSaleRepository = recordSaleRepository;
    }

    /**
     * LIST: Show all record sale transactions.
     */
    @GetMapping("")
    public String listAll(Model model) {
        Iterable<ArtistSaleList> sales = recordSaleRepository.findAll();
        model.addAttribute("sales", sales);
        return "recordsale/list";  // Thymeleaf page to show all transactions
    }

    /**
     * CREATE: Show form to add a new transaction.
     */
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("sale", new ArtistSaleList());
        return "recordsale/form";  // Thymeleaf page for form
    }

    /**
     * CREATE: Save a new transaction.
     */
    @PostMapping("/add")
    public String addSale(@ModelAttribute ArtistSaleList sale) {
        // Optionally calculate subtotal or totalCost here if needed
        recordSaleRepository.save(sale);
        return "redirect:/recordsale";
    }

    /**
     * READ/EDIT: Show form to edit an existing transaction.
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<ArtistSaleList> sale = recordSaleRepository.findById(id);
        if (sale.isPresent()) {
            model.addAttribute("sale", sale.get());
            return "recordsale/form"; // Thymeleaf page for edit form
        } else {
            return "redirect:/recordsale"; // Sale not found
        }
    }

    /**
     * UPDATE: Save changes to existing transaction.
     */
    @PostMapping("/edit/{id}")
    public String updateSale(@PathVariable("id") Integer id, @ModelAttribute ArtistSaleList sale) {
        sale.setId(id); // make sure the ID is set
        recordSaleRepository.save(sale);
        return "redirect:/recordsale";
    }

    /**
     * DELETE: Delete a transaction.
     */
    @GetMapping("/delete/{id}")
    public String deleteSale(@PathVariable("id") Integer id) {
        recordSaleRepository.deleteById(id);
        return "redirect:/recordsale";
    }

    /**
     * VIEW: Show details of a single transaction.
     */
    @GetMapping("/view/{id}")
    public String viewSale(@PathVariable("id") Integer id, Model model) {
        Optional<ArtistSaleList> sale = recordSaleRepository.findById(id);
        if (sale.isPresent()) {
            model.addAttribute("sale", sale.get());
            return "recordsale/form"; // Thymeleaf page for details
        } else {
            return "redirect:/recordsale";
        }
    }
    @GetMapping("/search")
    public String searchSales(
            @RequestParam(value = "artistName", required = false) String artistName,
            @RequestParam(value = "dateOfSale", required = false) String dateOfSale,
            Model model) {

        List<ArtistSaleList> sales;

        if (artistName != null && !artistName.isEmpty()) {
            sales = recordSaleRepository.findByArtistNameContaining(artistName);
        } else if (dateOfSale != null && !dateOfSale.isEmpty()) {
            sales = recordSaleRepository.findByDateOfSale(dateOfSale);
        } else {
            sales = (List<ArtistSaleList>) recordSaleRepository.findAll();
        }

        model.addAttribute("sales", sales);
        return "recordsale/list"; // reuse the list page
    }
}
