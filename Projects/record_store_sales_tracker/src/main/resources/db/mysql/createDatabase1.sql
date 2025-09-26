DROP DATABASE IF EXISTS cis2232_record_store_sales_tracker;
CREATE DATABASE cis2232_record_store_sales_tracker;
use cis2232_record_store_sales_tracker;

CREATE TABLE RecordStoreSalesTracker
(
    id                int(5),
    transactionDate    varchar(10) NOT NULL COMMENT 'yyyy-MM-dd',
    customerName       varchar(50) NOT NULL COMMENT 'Athletes name',
    artistName      varchar(50) NOT NULL COMMENT 'Name of artist or band associated with the album',
    formatType varchar(10) COMMENT 'Media format (Vinyl, CD, or Cassette)',
    albumPrice float(10) COMMENT 'Sum of forehand volleys',
    /* giftWrapped boolean(2) COMMENT 'Does the customer want it gift wrapped?',*/
    giftWrapped BOOLEAN COMMENT 'Does the customer want it gift wrapped?',
    subtotal int(50) COMMENT 'Cost of quantity multiplied by unit price',
    totalCost    float(5) COMMENT 'Total cost of transaction including tax'
) COMMENT 'This table tracks the sales in the record store';


ALTER TABLE RecordStoreSalesTracker
    ADD PRIMARY KEY (id);
ALTER TABLE RecordStoreSalesTracker
    MODIFY id int(4) NOT NULL AUTO_INCREMENT COMMENT 'This is the primary key',
    AUTO_INCREMENT = 1;

INSERT INTO RecordStoreSalesTracker (id, transactionDate, customerName, artistName, formatType,
                                     albumPrice, giftWrapped, subtotal, totalCost)

VALUES
    (1, '2022-08-22', 'A', 'Maria Smith', 'Vinyl', 11.00, FALSE, 78, 1085.00),
    (2, '2022-08-11', 'B', 'Rhonda Jones', 'CD', 5.00, TRUE, 36, 622.00),
    (3, '2022-08-07', 'C', 'Chad Collins', 'Vinyl', 8.00, FALSE, 37, 707.00),
    (4, '2022-08-07', 'D', 'Rhonda Jones', 'Vinyl', 12.00, TRUE, 53, 879.00),
    (5, '2022-08-07', 'E', 'Chad Collins', 'Vinyl', 8.00, TRUE, 52, 740.00),
    (6, '2022-08-08', 'F', 'Rhonda Jones', 'Vinyl', 10.00, FALSE, 61, 972.00),
    (7, '2022-08-10', 'G', 'Chad Collins', 'CD', 17.00, FALSE, 70, 1403.00),
    (8, '2022-08-08', 'H', 'Maria Smith', 'CD', 17.00, TRUE, 77, 1385.00),
    (9, '2022-08-22', 'I', 'Chad Collins', 'CD', 14.00, TRUE, 86, 1448.00);




