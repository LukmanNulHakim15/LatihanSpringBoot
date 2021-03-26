-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 26, 2021 at 11:21 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ujianketiga`
--

-- --------------------------------------------------------

--
-- Table structure for table `bonus`
--

CREATE TABLE `bonus` (
  `worker_ref_id` int(50) DEFAULT NULL,
  `bonus_date` datetime(6) DEFAULT NULL,
  `bonus_amount` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bonus`
--

INSERT INTO `bonus` (`worker_ref_id`, `bonus_date`, `bonus_amount`) VALUES
(1, '2016-02-20 00:00:00.000000', 5000),
(2, '2016-06-11 00:00:00.000000', 3000),
(3, '2016-02-20 00:00:00.000000', 4000),
(1, '2016-02-20 00:00:00.000000', 4500),
(2, '2016-06-11 00:00:00.000000', 3500);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `worker_id` int(50) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `salary` int(50) DEFAULT NULL,
  `joining_date` varchar(50) DEFAULT NULL,
  `departement` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`worker_id`, `first_name`, `last_name`, `salary`, `joining_date`, `departement`) VALUES
(1, 'Monica', 'Arora', 100000, '2014-02-20 09:00:00', 'HR'),
(2, 'Niharika', 'Verma', 80000, '2014-06-11 09:00:00', 'Admin'),
(3, 'Vishal', 'Shinghal', 300000, '2014-02-20 09:00:00', 'HR'),
(4, 'Amitabh', 'Singh', 500000, '2014-02-20 09:00:00', 'Admin'),
(5, 'Vivek', 'Bhati', 500000, '2014-06-11 09:00:00', 'Admin'),
(6, 'Vipul', 'Diwan', 200000, '2014-06-11 09:00:00', 'Account'),
(7, 'Satish', 'Kumar', 75000, '2014-01-20 09:00:00', 'Account'),
(8, 'Geetika', 'Chaucan', 90000, '2014-04-11 09:00:00', 'Admin'),
(9, 'Monica', 'Arora', 100000, '2014-02-20 09:00:00', 'HR');

-- --------------------------------------------------------

--
-- Table structure for table `title`
--

CREATE TABLE `title` (
  `worker_ref_id` int(50) DEFAULT NULL,
  `worker_title` varchar(50) DEFAULT NULL,
  `effective_from` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `title`
--

INSERT INTO `title` (`worker_ref_id`, `worker_title`, `effective_from`) VALUES
(1, 'Manager', '2016-02-20 00:00:00.000000'),
(2, 'Executive', '2016-06-11 00:00:00.000000'),
(8, 'Executive', '2016-06-11 00:00:00.000000'),
(5, 'Manager', '2016-06-11 00:00:00.000000'),
(4, 'Asst.Manager', '2016-06-11 00:00:00.000000'),
(7, 'Executive', '2016-06-11 00:00:00.000000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`worker_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
