DROP DATABASE IF EXISTS cis2232_record_store_sales_tracker;
CREATE DATABASE cis2232_record_store;
use cis2232_record_store;

--------------------------------------------------------------------------------
-- Note the table below to hold data associated with your project.  Expect one
-- table with 7-9 fields.
--------------------------------------------------------------------------------

CREATE TABLE RecordStoreSalesTracker
(
    id                int(5),
    transactionDate    varchar(10) NOT NULL COMMENT 'yyyy-MM-dd',
    customerName       varchar(50) NOT NULL COMMENT 'Athletes name',
    artistName      varchar(50) NOT NULL COMMENT 'Name of artist or band associated with the album',
    formatType varchar(10) COMMENT 'Media format (Vinyl, CD, or Cassette)',
    albumPrice double(10) COMMENT 'Sum of forehand volleys',
    giftWrapped boolean(2) COMMENT 'Does the customer want it gift wrapped?',
    subtotal int(50) COMMENT 'Cost of quantity multiplied by unit price',
    totalCost    double(3) COMMENT 'Total cost of transaction including tax'
) COMMENT 'This table tracks the sales in the record store';


ALTER TABLE RecordStoreSalesTracker
    ADD PRIMARY KEY (id);
ALTER TABLE RecordStoreSalesTracker
    MODIFY id int(4) NOT NULL AUTO_INCREMENT COMMENT 'This is the primary key',
    AUTO_INCREMENT = 1;

-- insert into SkillsAssessmentSquashTechnical values(0, '2022-08-22',	'2022-08-20 11:35:15','Maria Smith','BJ MacLean',		11,	5,	14,	78,	6,	59,0);
-- insert into SkillsAssessmentSquashTechnical values(0, '2022-08-11',	'2022-08-11 11:35:15','Rhonda Jones','BJ MacLean',		5,	7,	4,	36,	5,	38,0);
-- insert into SkillsAssessmentSquashTechnical values(0, '2022-08-07', '2022-08-07 11:35:15','Chad Collins','BJ MacLean',		8,	8,	4,	37,	5,	42,0);
-- insert into SkillsAssessmentSquashTechnical values(0, '2022-08-07', '2022-08-07 11:35:15','Rhonda Jones','BJ MacLean',		12,	8,	9,	53,	4,	42,0);
-- insert into SkillsAssessmentSquashTechnical values(0, '2022-08-07', '2022-08-05 11:35:15','Chad Collins','BJ MacLean',		8,	10,	7,	52,	3,	26,0);
-- insert into SkillsAssessmentSquashTechnical values(0, '2022-08-08',	'2022-08-08 11:35:15','Rhonda Jones','BJ MacLean',		10,	8,	8,	61,	6,	57,0);
-- insert into SkillsAssessmentSquashTechnical values(0, '2022-08-10',	'2022-08-10 11:35:15','Chad Collins','BJ MacLean',		17,	14,	8,	70,	13,	84,0);
-- insert into SkillsAssessmentSquashTechnical values(0, '2022-08-08',	'2022-08-08 11:35:15','Maria Smith','BJ MacLean',		17,	18,	12,	77,	8,	63,0);
-- insert into SkillsAssessmentSquashTechnical values(0, '2022-08-22',	'2022-08-20 11:35:15','Chad Collins','BJ MacLean',		14,	11,	10,	86,	16,	87,0);

INSERT INTO RecordStoreSalesTracker (id, transactionDate, customerName, artistName, formatType,
                                             albumPrice, giftWrapped, subtotal, totalCost)

VALUES (1, '2022-08-22', 'A', 'Maria Smith', 'Vinyl', 11, 0, 14, 78, 6, 59, 1085),
       (2, '2022-08-11', 'B', 'Rhonda Jones', 'Cd', 5, 2, 4, 36, 5, 38, 622),
       (3, '2022-08-07', 'C', 'Chad Collins', 'Vinyl', 8, 0, 4, 37, 5, 42, 707),
       (4, '2022-08-07', 'D', 'Rhonda Jones', 'Vinyl', 12, 2, 9, 53, 4, 42, 879),
       (5, '2022-08-07', 'E', 'Chad Collins', 'Vinyl', 8, 2, 7, 52, 3, 26, 740),
       (6, '2022-08-08', 'F', 'Rhonda Jones', 'Vinyl', 10, 0, 8, 61, 6, 57, 972),
       (7, '2022-08-10', 'G', 'Chad Collins', 'Cd', 17, 0, 8, 70, 13, 84, 1403),
       (8, '2022-08-08', 'H', 'Maria Smith', 'Cd', 17, 2, 12, 77, 8, 63, 1385),
       (9, '2022-08-22', 'I', 'Chad Collins', 'Cd', 14, 2, 10, 86, 16, 87, 1448);

