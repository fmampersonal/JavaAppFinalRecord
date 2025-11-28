DROP DATABASE IF EXISTS cis2232_record_store_sales_tracker;
CREATE DATABASE cis2232_record_store_sales_tracker;
USE cis2232_record_store_sales_tracker;

CREATE TABLE RecordStoreSalesTracker
(
    id          INT(5),
    dateOfSale  VARCHAR(10) NOT NULL COMMENT 'yyyy-MM-dd',
    customerName VARCHAR(50) NOT NULL COMMENT 'Customer name',
    artistName  VARCHAR(50) NOT NULL COMMENT 'Name of artist or band associated with the album',
    formatType  VARCHAR(10) COMMENT 'Media format (Vinyl, CD, or Cassette)',
    albumPrice  FLOAT(10) COMMENT 'Price per album',
    giftWrapped BOOLEAN COMMENT 'Does the customer want it gift wrapped?',
    subtotal    INT(50) COMMENT 'Cost of quantity multiplied by unit price',
    totalCost   FLOAT(5) COMMENT 'Total cost of transaction including tax',
    unitsSold   INT COMMENT 'Number of albums sold'
) COMMENT 'This table tracks the sales in the record store';

ALTER TABLE RecordStoreSalesTracker
    ADD PRIMARY KEY (id);

ALTER TABLE RecordStoreSalesTracker
    MODIFY id INT(4) NOT NULL AUTO_INCREMENT COMMENT 'This is the primary key',
    AUTO_INCREMENT = 1;

-- INSERT with unitsSold calculated as subtotal ÷ albumPrice
INSERT INTO RecordStoreSalesTracker
(id, dateOfSale, customerName, artistName, formatType, albumPrice, giftWrapped, subtotal, totalCost, unitsSold)
VALUES
    (1, '2022-08-22', 'A', 'Maria Smith', 'Vinyl', 11.00, FALSE, 858, 1085.00, 78),
    (2, '2022-08-11', 'B', 'Rhonda Jones', 'CD', 5.00, TRUE, 180, 622.00, 36),
    (3, '2022-08-07', 'C', 'Chad Collins', 'Vinyl', 8.00, FALSE, 296, 707.00, 37),
    (4, '2022-08-07', 'D', 'Rhonda Jones', 'Vinyl', 12.00, TRUE, 636, 879.00, 53),
    (5, '2022-08-07', 'E', 'Chad Collins', 'Vinyl', 8.00, TRUE, 416, 740.00, 52),
    (6, '2022-08-08', 'F', 'Rhonda Jones', 'Vinyl', 10.00, FALSE, 610, 972.00, 61),
    (7, '2022-08-10', 'G', 'Chad Collins', 'CD', 17.00, FALSE, 1190, 1403.00, 70),
    (8, '2022-08-08', 'H', 'Maria Smith', 'CD', 17.00, TRUE, 1309, 1385.00, 77),
    (9, '2022-08-22', 'I', 'Chad Collins', 'CD', 14.00, TRUE, 1204, 1448.00, 86);
