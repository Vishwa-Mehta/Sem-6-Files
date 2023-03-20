-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 03, 2023 at 06:09 AM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory_management_system`
--

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `del_null`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `del_null` ()  BEGIN
	DECLARE vid int;
	DECLARE finished INTEGER DEFAULT 0;
	DECLARE del_null CURSOR FOR
		SELECT DISTINCT vendor.vendor_id FROM vendor INNER JOIN invoice WHERE vendor.vendor_id = invoice.vendor_id and vendor.product_id IS NULL;

	DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET finished = 1; 
    
	OPEN del_null;
		getRows: LOOP
			FETCH del_null INTO vid;
			IF finished THEN
				LEAVE getRows;
			END IF;
			DELETE FROM vendor WHERE vendor.vendor_id = vid AND vendor.product_id IS NULL;
		END LOOP;
	CLOSE del_null;
END$$

DROP PROCEDURE IF EXISTS `insert_invoice`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_invoice` (IN `pqty` INT, IN `pid` INT)  BEGIN
	UPDATE stock SET stock.pqty = stock.pqty - pqty WHERE stock.pid = pid;
END$$

DROP PROCEDURE IF EXISTS `update_qty`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_qty` (IN `qty` INT)  BEGIN
	UPDATE stock SET stock.pqty = qty, stock.purchase_date = CURRENT_DATE WHERE stock.pqty < 50;
END$$

--
-- Functions
--
DROP FUNCTION IF EXISTS `check_stock`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `check_stock` (`qty` INT) RETURNS VARCHAR(50) CHARSET utf8 BEGIN
	DECLARE refill VARCHAR(50);
	IF qty < 50 THEN
    	SET refill = "re-fill needed";
	ELSE
    	SET refill = "no re-fill needed";
    END IF;
   	RETURN refill;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `cust_id` int(10) NOT NULL,
  `phone_no` bigint(10) NOT NULL,
  `cust_email_id` varchar(50) NOT NULL,
  `cust_name` varchar(50) NOT NULL,
  `str_no` int(11) DEFAULT NULL,
  `str_name` varchar(50) DEFAULT NULL,
  `pincode` int(6) DEFAULT NULL,
  PRIMARY KEY (`cust_id`,`phone_no`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cust_id`, `phone_no`, `cust_email_id`, `cust_name`, `str_no`, `str_name`, `pincode`) VALUES
(57317, 5289998172, 'inderpal@gmail.com', 'Inderpal Ravinder', 12, 'Goel Street', 649721),
(26864, 8043894922, 'ishi@gmail.com', 'Ishita Devraj', 14, 'Ramkissoon Street', 427425),
(58462, 8545588678, 'anikp@gmail.com', 'Anik Prabhakar', 56, 'Sekhon Street', 139845),
(63698, 3816889497, 'ninadram@gmail.com', 'Ninad Ram', 37, 'Kari Street', 456639),
(33295, 9489333654, 'devis@yahoo.com', 'Devi Sunder', 28, 'Subramaniam Street', 376921),
(22150, 9056364822, 'rama123@yahoo.com', 'Ramadevi Gopala', 57, 'Sen Street', 758086),
(76443, 7294778333, 'pravinajaya@gmail.com', 'Pravina Jaya', 22, 'Raja Street', 591648),
(45406, 4305436406, 'anilabhi@gmail.com', 'Anil Abhishek', 71, 'Shroff Street', 234740),
(26865, 8145956923, 'nilofara@hotmail.com', 'Nilofar Amardeep', 83, 'Vig Street', 158657),
(43143, 5636459498, 'vinayarvind24@hotmail.com', 'Vinay Aravind', 26, 'Chakraborty Street', 525343),
(13261, 9242192421, 'abc123@gmail.com', 'Niyanta', 204, 'Shobha Classic', 560068),
(57652, 1234567890, 'sunaina@gmail.com', 'Sunaina Mishra', 12, 'Shroff Street', 234740);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
CREATE TABLE IF NOT EXISTS `invoice` (
  `prod_id` int(10) NOT NULL,
  `invoice_no` int(10) NOT NULL,
  `invoice_date` date NOT NULL,
  `selling_price` float NOT NULL,
  `prod_qty` int(11) DEFAULT '0',
  `discount` float DEFAULT NULL,
  `phone_no` bigint(10) DEFAULT NULL,
  `vendor_id` int(11) NOT NULL,
  PRIMARY KEY (`prod_id`,`invoice_no`),
  KEY `phone_no` (`phone_no`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`prod_id`, `invoice_no`, `invoice_date`, `selling_price`, `prod_qty`, `discount`, `phone_no`, `vendor_id`) VALUES
(59854, 38980, '2022-10-22', 15.2, 2, 0.2, 5289998172, 75071),
(59854, 85957, '2022-10-23', 15.2, 2, 0.2, 8043894922, 75071),
(59854, 99454, '2022-10-23', 15.2, 2, 0.2, 8545588678, 40101),
(59854, 20453, '2022-11-18', 15.2, 3, 0.2, 8545588678, 73660),
(59854, 49678, '2022-11-18', 15.2, 3, 0.2, 8545588678, 73660),
(59854, 88070, '2022-11-18', 15.2, 3, 0.2, 8545588678, 73660),
(59854, 69302, '2022-11-18', 15.2, 3, 0.2, 8545588678, 73660),
(59854, 43769, '2022-11-18', 18.43, 3, 0.03, 9242192421, 74044),
(53028, 56489, '2022-11-05', 32.64, 2, 0.04, 1234567890, 73660);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `email_id` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  PRIMARY KEY (`email_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`email_id`, `pass`) VALUES
('harry@gmail.com', 'har1234%'),
('ramesh@gmail.com', 'rameshH234'),
('ram@gmail.com', 'ram135&'),
('ranjeeta@gmail.com', 'ran234%'),
('rakesh@gmail.com', 'rakeshm345'),
('vismaya@gmail.com', 'admin1234'),
('vis@gmail.com', 'user123'),
('vishwa@gmail.com', 'admin123'),
('msm124@yahoo.com', '12345678'),
('vinti@gmail.com', '123'),
('neeta@gmail.com', 'user1234');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int(10) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `cost_price` float NOT NULL,
  `manufacturer` varchar(50) NOT NULL,
  `mrp` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `cost_price`, `manufacturer`, `mrp`) VALUES
(59854, 'milk', 17, 'Amul', 19),
(53028, 'curd', 31, 'Amul', 34),
(56145, 'butter', 25, 'Amul', 28),
(81010, 'cow milk', 15, 'Nandini', 17),
(99016, 'yougurt', 25, 'Nandini', 30),
(15292, 'paneer', 55, 'Milky Mist', 60),
(45124, 'cheese', 85, 'Amul', 90),
(14270, 'ghee', 440, 'Nandini', 450),
(86934, 'ice cream family pack', 180, 'Quality Walls', 200),
(98390, 'ice cream cone', 35, 'Cornetto', 40),
(80811, 'Bread', 45, 'Britania', 55),
(83067, 'Curd', 32, 'Milky Mist', 37),
(90295, 'Chocolate', 60, 'Cadbury', 80);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `pid` int(10) NOT NULL,
  `purchase_date` date NOT NULL,
  `mfg_date` date NOT NULL,
  `pqty` int(11) DEFAULT '0',
  PRIMARY KEY (`pid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`pid`, `purchase_date`, `mfg_date`, `pqty`) VALUES
(59854, '2022-10-21', '2022-10-21', 80),
(53028, '2022-10-18', '2022-10-18', 88),
(56145, '2022-10-12', '2022-10-10', 65),
(81010, '2022-10-21', '2022-10-21', 60),
(99016, '2022-10-17', '2022-10-16', 50),
(15292, '2022-11-24', '2022-10-19', 50),
(45124, '2022-11-24', '2022-09-29', 50),
(14270, '2022-11-17', '2022-09-20', 100);

--
-- Triggers `stock`
--
DROP TRIGGER IF EXISTS `on_insert_stock`;
DELIMITER $$
CREATE TRIGGER `on_insert_stock` BEFORE INSERT ON `stock` FOR EACH ROW BEGIN
	DECLARE err_msg1 varchar(100);
    DECLARE err_msg2 varchar(100);
    DECLARE err_msg3 varchar(100);
    SET err_msg1 = "Mfg/Purchase Date must be before the current date";
    SET err_msg2 = "Mfg Date should be before Purchase Date";
    SET err_msg3 = "Product quantity should be minimum 50";
    IF (new.purchase_date > CURRENT_DATE OR new.mfg_date > CURRENT_DATE) THEN
    	SIGNAL SQLSTATE '45000'
 		SET MESSAGE_TEXT = err_msg1;
	ELSEIF  new.mfg_date > new.purchase_date THEN
    	SIGNAL SQLSTATE '45000'
 		SET MESSAGE_TEXT = err_msg2;
	ELSEIF new.pqty < 50 THEN
    	SIGNAL SQLSTATE '45000'
 		SET MESSAGE_TEXT = err_msg3;
	END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
CREATE TABLE IF NOT EXISTS `vendor` (
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `vendor_id` int(11) NOT NULL,
  `email_id` varchar(50) NOT NULL,
  `product_id` int(10) DEFAULT NULL,
  `cust_id` int(10) DEFAULT NULL,
  KEY `email_id` (`email_id`),
  KEY `cust_id` (`cust_id`),
  KEY `product_id` (`product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vendor`
--

INSERT INTO `vendor` (`fname`, `lname`, `vendor_id`, `email_id`, `product_id`, `cust_id`) VALUES
('harry', 'singh', 75071, 'harry@gmail.com', 59854, 57317),
('harry', 'singh', 75071, 'harry@gmail.com', 59854, 26864),
('harry', 'singh', 75071, 'harry@gmail.com', 59854, 58462),
('harry', 'singh', 75071, 'harry@gmail.com', 53028, 57317),
('harry', 'singh', 75071, 'harry@gmail.com', 14270, 58462),
('harry', 'singh', 75071, 'harry@gmail.com', 59854, 63698),
('harry', 'singh', 75071, 'harry@gmail.com', 98390, 63698),
('ramesh', 'sharma', 40101, 'ramesh@gmail.com', 59854, 33295),
('ramesh', 'sharma', 40101, 'ramesh@gmail.com', 15292, 33295),
('ramesh', 'sharma', 40101, 'ramesh@gmail.com', 59854, 33295),
('ramesh', 'sharma', 40101, 'ramesh@gmail.com', 14270, 22150),
('ramesh', 'sharma', 40101, 'ramesh@gmail.com', 59854, 22150),
('ram', 'c', 70978, 'ram@gmail.com', 53028, 76443),
('ram', 'c', 70978, 'ram@gmail.com', 59854, 76443),
('ranjeeta', 's', 94138, 'ranjeeta@gmail.com', 59854, 45406),
('ranjeeta', 's', 94138, 'ranjeeta@gmail.com', 45124, 26864),
('ranjeeta', 's', 94138, 'ranjeeta@gmail.com', 98390, 45406),
('rakesh', 'sharma', 29690, 'rakesh@gmail.com', 81010, 43143),
('rakesh', 'sharma', 29690, 'rakesh@gmail.com', 15292, 43143),
('vishwa', 'mehta', 73660, 'vis@gmail.com', 59854, 58462),
('vismaya', 'r', 84992, 'vismaya@gmail.com', NULL, NULL),
('neeta', 'sharma', 40226, 'neeta@gmail.com', NULL, NULL),
('Mehul', 'Mehta', 74044, 'msm124@yahoo.com', 59854, 13261),
('vishwa', 'mehta', 73660, 'vis@gmail.com', 53028, 57652),
('vinti', 'agrawal', 91639, 'vinti@gmail.com', NULL, NULL),
('vishwa', 'mehta', 73660, 'vis@gmail.com', 53028, 57652),
('vishwa', 'mehta', 73660, 'vis@gmail.com', 53028, 57652);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
