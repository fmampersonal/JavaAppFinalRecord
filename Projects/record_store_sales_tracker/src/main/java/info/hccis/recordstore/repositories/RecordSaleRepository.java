package info.hccis.recordstore.repositories;

import info.hccis.recordstore.jpa.entity.ArtistSaleList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for performing CRUD operations on ArtistSaleList entities.
 * Replaces the old TicketOrderRepository for the record store sales tracker project.
 *
 * @since 20251024
 */
@Repository
public interface RecordSaleRepository extends JpaRepository<ArtistSaleList, Integer> {

    /**
     * Find all sales where the artist name contains the given string.
     * Useful for reports filtered by partial artist name.
     *
     * @param artistName partial or full name of artist
     * @return List of matching ArtistSaleList entries
     */
    List<ArtistSaleList> findByArtistNameContaining(String artistName);

    /**
     * Find all sales for a specific artist (exact match).
     *
     * @param artistName exact name of the artist
     * @return List of matching ArtistSaleList entries
     */
    List<ArtistSaleList> findByArtistName(String artistName);

    /**
     * Find all sales on a specific date.
     *
     * @param dateOfSale the sale date in yyyy-MM-dd format
     * @return List of matching ArtistSaleList entries
     */
    List<ArtistSaleList> findByDateOfSale(String dateOfSale);
}

