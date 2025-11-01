package info.hccis.recordstore.dao;

import info.hccis.recordstore.jpa.entity.ArtistSaleList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * DAO class to fetch record sales data from the database using JDBC.
 *
 * @author BJM
 * @since 20251024
 */
public class RecordSaleDAO {

    // JDBC connection info (adjust as needed)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/recordstore";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    /**
     * Fetch all sales for a given artist from the database.
     *
     * @param artistName the artist name to filter by
     * @return list of ArtistSaleList objects
     */
    public ArrayList<ArtistSaleList> selectTicketOrders(String artistName) {
        ArrayList<ArtistSaleList> salesList = new ArrayList<>();

        String sql = "SELECT id, artistName, albumName, dateOfSale, unitsSold, saleAmount " +
                "FROM recordsale WHERE artistName LIKE ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + artistName + "%"); // partial match search

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ArtistSaleList sale = new ArtistSaleList();
                    sale.setId(rs.getInt("id"));
                    sale.setArtistName(rs.getString("artistName"));
                    sale.setAlbumName(rs.getString("albumName"));
                    sale.setDateOfSale(rs.getString("dateOfSale"));
                    sale.setUnitsSold(rs.getInt("unitsSold"));
                    sale.setSaleAmount(rs.getBigDecimal("saleAmount"));

                    salesList.add(sale);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // You could log this exception or rethrow as a custom exception
        }

        return salesList;
    }
}
