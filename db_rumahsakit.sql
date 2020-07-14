-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               10.4.6-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for latihanuts
CREATE DATABASE IF NOT EXISTS `latihanuts` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `latihanuts`;

-- Dumping structure for table latihanuts.daftarbarang116
CREATE TABLE IF NOT EXISTS `daftarbarang116` (
  `Kode116` varchar(5) NOT NULL,
  `Nama116` char(25) DEFAULT NULL,
  `Harga116` int(20) DEFAULT NULL,
  PRIMARY KEY (`Kode116`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table latihanuts.daftarbarang116: ~4 rows (approximately)
/*!40000 ALTER TABLE `daftarbarang116` DISABLE KEYS */;
INSERT INTO `daftarbarang116` (`Kode116`, `Nama116`, `Harga116`) VALUES
	('B-01', 'Baju Tangan Pendek', 120000),
	('B-02', 'Baju Tangan Panjang', 150000),
	('J-02', 'Jas Hujan', 15000),
	('K-01', 'Kimono', 60000);
/*!40000 ALTER TABLE `daftarbarang116` ENABLE KEYS */;

-- Dumping structure for table latihanuts.pelanggan116
CREATE TABLE IF NOT EXISTS `pelanggan116` (
  `ID116` varchar(5) NOT NULL,
  `Nama116` char(25) DEFAULT NULL,
  `Kota116` char(15) DEFAULT NULL,
  `Telp/HP116` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID116`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table latihanuts.pelanggan116: ~3 rows (approximately)
/*!40000 ALTER TABLE `pelanggan116` DISABLE KEYS */;
INSERT INTO `pelanggan116` (`ID116`, `Nama116`, `Kota116`, `Telp/HP116`) VALUES
	('D-02', 'Dewi Susanti', 'Jakarta', '08113456'),
	('E-02', 'Ernawati', 'Bogor', '08156667788'),
	('R-01', 'Rahmawati', 'Bandung', '022-234567');
/*!40000 ALTER TABLE `pelanggan116` ENABLE KEYS */;

-- Dumping structure for table latihanuts.sales116
CREATE TABLE IF NOT EXISTS `sales116` (
  `ID116` varchar(5) NOT NULL,
  `Nama116` varchar(25) DEFAULT NULL,
  `P / W116` enum('P','W') DEFAULT NULL,
  `Gender116` enum('Pria','Wanita') DEFAULT NULL,
  PRIMARY KEY (`ID116`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table latihanuts.sales116: ~3 rows (approximately)
/*!40000 ALTER TABLE `sales116` DISABLE KEYS */;
INSERT INTO `sales116` (`ID116`, `Nama116`, `P / W116`, `Gender116`) VALUES
	('B-01', 'Budiman', 'P', 'Pria'),
	('C-02', 'Cyntia', 'W', 'Wanita'),
	('D-03', 'Dani', 'P', 'Pria');
/*!40000 ALTER TABLE `sales116` ENABLE KEYS */;

-- Dumping structure for table latihanuts.transaksi116
CREATE TABLE IF NOT EXISTS `transaksi116` (
  `id116` int(11) NOT NULL,
  `Tanggal116` date DEFAULT NULL,
  `Sales ID116` varchar(5) NOT NULL,
  `Nama Sales116` char(25) DEFAULT NULL,
  `Pelanggan ID116` varchar(5) NOT NULL,
  `Nama Pelanggan116` char(25) DEFAULT NULL,
  PRIMARY KEY (`id116`),
  KEY `FK_transaksi_sales` (`Sales ID116`),
  KEY `FK_transaksi_pelanggan` (`Pelanggan ID116`),
  CONSTRAINT `FK_transaksi_pelanggan` FOREIGN KEY (`Pelanggan ID116`) REFERENCES `pelanggan116` (`ID116`),
  CONSTRAINT `FK_transaksi_sales` FOREIGN KEY (`Sales ID116`) REFERENCES `sales116` (`ID116`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table latihanuts.transaksi116: ~2 rows (approximately)
/*!40000 ALTER TABLE `transaksi116` DISABLE KEYS */;
INSERT INTO `transaksi116` (`id116`, `Tanggal116`, `Sales ID116`, `Nama Sales116`, `Pelanggan ID116`, `Nama Pelanggan116`) VALUES
	(1, '2011-03-03', 'B-01', 'Budiman', 'D-02', 'Dewi Susanti'),
	(2, '2011-04-05', 'C-02', 'Cyntia', 'R-01', 'Rahmawati');
/*!40000 ALTER TABLE `transaksi116` ENABLE KEYS */;

-- Dumping structure for table latihanuts.transaksiitem116
CREATE TABLE IF NOT EXISTS `transaksiitem116` (
  `ID Trans.116` int(11) NOT NULL,
  `Kode116` varchar(5) NOT NULL,
  `Nama Barang116` char(25) DEFAULT NULL,
  `Qty116` int(20) DEFAULT NULL,
  `Jumlah116` int(20) DEFAULT NULL,
  KEY `FK_transaksiitem116_transaksi116` (`ID Trans.116`),
  KEY `FK_transaksiitem116_daftarbarang116` (`Kode116`),
  CONSTRAINT `FK_transaksiitem116_daftarbarang116` FOREIGN KEY (`Kode116`) REFERENCES `daftarbarang116` (`Kode116`),
  CONSTRAINT `FK_transaksiitem116_transaksi116` FOREIGN KEY (`ID Trans.116`) REFERENCES `transaksi116` (`id116`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table latihanuts.transaksiitem116: ~4 rows (approximately)
/*!40000 ALTER TABLE `transaksiitem116` DISABLE KEYS */;
INSERT INTO `transaksiitem116` (`ID Trans.116`, `Kode116`, `Nama Barang116`, `Qty116`, `Jumlah116`) VALUES
	(1, 'B-02', 'Baju Tangan Panjang', 12, NULL),
	(1, 'J-02', 'Jas Hujan', 13, NULL),
	(2, 'K-01', 'Kimono', 7, NULL),
	(2, 'B-01', 'Baju Tangan Pendek', 3, NULL);
/*!40000 ALTER TABLE `transaksiitem116` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
