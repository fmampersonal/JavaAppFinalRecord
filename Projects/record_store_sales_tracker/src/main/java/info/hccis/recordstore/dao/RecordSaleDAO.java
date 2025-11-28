package info.hccis.recordstore.dao;

import info.hccis.recordstore.jpa.entity.ArtistSaleList;
import java.sql.*;
import java.util.ArrayList;

public class RecordSaleDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/cis2232_record_store_sales_tracker";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    // ----------------- READ -----------------
    public ArrayList<ArtistSaleList> selectTicketOrders(String artistName) {
        ArrayList<ArtistSaleList> salesList = new ArrayList<>();
        String sql = "SELECT * FROM RecordStoreSalesTracker WHERE artistName LIKE ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + artistName + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ArtistSaleList sale = mapResultSetToSale(rs);
                    salesList.add(sale);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesList;
    }

    // ----------------- CREATE -----------------
    public boolean insertSale(ArtistSaleList sale) {
        String sql = "INSERT INTO RecordStoreSalesTracker " +
                "(dateOfSale, customerName, artistName, formatType, albumPrice, giftWrapped, subtotal, totalCost, unitsSold) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sale.getDateOfSale());
            ps.setString(2, sale.getCustomerName());
            ps.setString(3, sale.getArtistName());
            ps.setString(4, sale.getFormatType());
            ps.setFloat(5, sale.getAlbumPrice());
            ps.setBoolean(6, sale.getGiftWrapped());

            ps.setInt(7, sale.getSubtotal());
            ps.setFloat(8, sale.getTotalCost());
            ps.setInt(9, sale.getUnitsSold());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ----------------- UPDATE -----------------
    public boolean updateSale(ArtistSaleList sale) {
        String sql = "UPDATE RecordStoreSalesTracker SET dateOfSale=?, customerName=?, artistName=?, formatType=?, albumPrice=?, giftWrapped=?, subtotal=?, totalCost=?, unitsSold=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sale.getDateOfSale());
            ps.setString(2, sale.getCustomerName());
            ps.setString(3, sale.getArtistName());
            ps.setString(4, sale.getFormatType());
            ps.setFloat(5, sale.getAlbumPrice());
            ps.setBoolean(6, sale.getGiftWrapped());

            ps.setInt(7, sale.getSubtotal());
            ps.setFloat(8, sale.getTotalCost());
            ps.setInt(9, sale.getUnitsSold());
            ps.setInt(10, sale.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ----------------- DELETE -----------------
    public boolean deleteSale(int id) {
        String sql = "DELETE FROM RecordStoreSalesTracker WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ----------------- HELPER -----------------
    private ArtistSaleList mapResultSetToSale(ResultSet rs) throws SQLException {
        ArtistSaleList sale = new ArtistSaleList();
        sale.setId(rs.getInt("id"));
        sale.setDateOfSale(rs.getString("dateOfSale"));
        sale.setCustomerName(rs.getString("customerName"));
        sale.setArtistName(rs.getString("artistName"));
        sale.setFormatType(rs.getString("formatType"));
        sale.setAlbumPrice(rs.getFloat("albumPrice"));
        sale.setGiftWrapped(rs.getBoolean("giftWrapped"));
        sale.setSubtotal(rs.getInt("subtotal"));
        sale.setTotalCost(rs.getFloat("totalCost"));
        sale.setUnitsSold(rs.getInt("unitsSold"));
        return sale;
    }
}
