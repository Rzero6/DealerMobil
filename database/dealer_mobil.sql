-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 09, 2023 at 07:08 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dealer_mobil`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `idCustomer` int(11) NOT NULL,
  `namaCustomer` varchar(255) DEFAULT NULL,
  `tanggalLahirCustomer` date DEFAULT NULL,
  `alamatCustomer` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`idCustomer`, `namaCustomer`, `tanggalLahirCustomer`, `alamatCustomer`) VALUES
(1, 'Reynold Kunarto', '1996-06-26', 'Jln. Jalan No.2'),
(2, 'Febiola Ika Putri W.', '2006-01-31', 'Jln. Bareng No.1'),
(4, 'Wisnu', '2001-07-23', 'Jln. apa gaktatu');

-- --------------------------------------------------------

--
-- Table structure for table `kendaraan`
--

CREATE TABLE `kendaraan` (
  `idKendaraan` int(11) NOT NULL,
  `namaKendaraan` varchar(255) DEFAULT NULL,
  `jenisKendaraan` varchar(255) DEFAULT NULL,
  `merkKendaraan` varchar(255) DEFAULT NULL,
  `hargaKendaraan` float DEFAULT NULL,
  `jumlahKendaraan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kendaraan`
--

INSERT INTO `kendaraan` (`idKendaraan`, `namaKendaraan`, `jenisKendaraan`, `merkKendaraan`, `hargaKendaraan`, `jumlahKendaraan`) VALUES
(1, 'Brio RS', 'Hatchback', 'Honda', 200000000, 15),
(2, 'Raize', 'SUV', 'Toyota', 300000000, 10),
(5, 'CR-V', 'Hatchback', 'Honda', 600000000, 5),
(6, 'Aventador', 'Sport', 'Lamborghini', 1000000000, 0),
(7, 'A5 Coupe', 'Coupe', 'Audi', 5000000000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `idPembelian` int(11) NOT NULL,
  `idSuplier` int(11) NOT NULL,
  `idKendaraan` int(11) NOT NULL,
  `totalHargaBeli` float DEFAULT NULL,
  `jumlahSuplai` int(11) DEFAULT NULL,
  `tanggalPembelian` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`idPembelian`, `idSuplier`, `idKendaraan`, `totalHargaBeli`, `jumlahSuplai`, `tanggalPembelian`) VALUES
(3, 1, 1, 2000000000, 10, '2023-06-09 21:01:25'),
(4, 1, 5, 1800000000, 3, '2023-06-09 21:02:08'),
(5, 4, 6, 1000000000, 1, '2023-06-09 21:03:17'),
(6, 1, 5, 1200000000, 2, '2023-06-09 23:52:28'),
(7, 5, 7, 5000000000, 1, '2023-06-09 23:54:06');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `idPenjualan` int(11) NOT NULL,
  `idKendaraan` int(11) DEFAULT NULL,
  `idCustomer` int(11) DEFAULT NULL,
  `idStaff` int(11) DEFAULT NULL,
  `totalHarga` float DEFAULT NULL,
  `jenisPembayaran` varchar(25) DEFAULT NULL,
  `tanggalPenjualan` datetime NOT NULL,
  `jumlahPenjualan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`idPenjualan`, `idKendaraan`, `idCustomer`, `idStaff`, `totalHarga`, `jenisPembayaran`, `tanggalPenjualan`, `jumlahPenjualan`) VALUES
(1, 1, 1, 1, 220000000, 'Cash', '2023-06-08 19:03:34', 1),
(2, 2, 2, 1, 330000000, 'Kredit', '2023-06-08 19:07:10', 1),
(3, 2, 1, 1, 660000000, 'Cash', '2023-06-08 19:12:12', 2),
(4, 2, 1, 1, 660000000, 'Kredit', '2023-06-08 19:12:44', 2),
(5, 1, 1, 1, 440000000, 'Cash', '2023-06-08 19:51:28', 2),
(6, 6, 1, 1, 1100000000, 'Cash', '2023-06-09 23:32:19', 1);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `idStaff` int(11) NOT NULL,
  `namaStaff` varchar(255) DEFAULT NULL,
  `jabatanStaff` varchar(255) DEFAULT NULL,
  `gajiStaff` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`idStaff`, `namaStaff`, `jabatanStaff`, `gajiStaff`) VALUES
(1, 'Axel Nugroho', 'Manager', 10000000),
(2, 'David Wisnu', 'Sales', 5000000),
(4, 'Kevin Wilson', 'Sales', 1000000);

-- --------------------------------------------------------

--
-- Table structure for table `suplier`
--

CREATE TABLE `suplier` (
  `idSuplier` int(11) NOT NULL,
  `namaSuplier` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `suplier`
--

INSERT INTO `suplier` (`idSuplier`, `namaSuplier`) VALUES
(1, 'Honda'),
(2, 'Toyota'),
(4, 'Lamborghini'),
(5, 'Audi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`idCustomer`);

--
-- Indexes for table `kendaraan`
--
ALTER TABLE `kendaraan`
  ADD PRIMARY KEY (`idKendaraan`);

--
-- Indexes for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`idPembelian`),
  ADD KEY `idSuplier` (`idSuplier`),
  ADD KEY `pembelian_ibfk_1` (`idKendaraan`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`idPenjualan`),
  ADD KEY `idKendaraan` (`idKendaraan`),
  ADD KEY `idCustomer` (`idCustomer`),
  ADD KEY `idStaff` (`idStaff`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`idStaff`);

--
-- Indexes for table `suplier`
--
ALTER TABLE `suplier`
  ADD PRIMARY KEY (`idSuplier`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `idCustomer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `kendaraan`
--
ALTER TABLE `kendaraan`
  MODIFY `idKendaraan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `pembelian`
--
ALTER TABLE `pembelian`
  MODIFY `idPembelian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `idPenjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `idStaff` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `suplier`
--
ALTER TABLE `suplier`
  MODIFY `idSuplier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD CONSTRAINT `pembelian_ibfk_1` FOREIGN KEY (`idKendaraan`) REFERENCES `kendaraan` (`idKendaraan`) ON UPDATE CASCADE,
  ADD CONSTRAINT `pembelian_ibfk_2` FOREIGN KEY (`idSuplier`) REFERENCES `suplier` (`idSuplier`) ON UPDATE CASCADE;

--
-- Constraints for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `penjualan_ibfk_1` FOREIGN KEY (`idKendaraan`) REFERENCES `kendaraan` (`idKendaraan`) ON UPDATE CASCADE,
  ADD CONSTRAINT `penjualan_ibfk_2` FOREIGN KEY (`idCustomer`) REFERENCES `customer` (`idCustomer`) ON UPDATE CASCADE,
  ADD CONSTRAINT `penjualan_ibfk_3` FOREIGN KEY (`idStaff`) REFERENCES `staff` (`idStaff`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
