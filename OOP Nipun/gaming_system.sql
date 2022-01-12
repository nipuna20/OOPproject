-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2021 at 12:02 PM
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
-- Database: `gaming_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `id` int(11) NOT NULL,
  `game` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `rate` varchar(100) NOT NULL,
  `comment` varchar(100) NOT NULL,
  `date` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`id`, `game`, `name`, `rate`, `comment`, `date`) VALUES
(2, 'Apex Legends', 'Malki', 'Best', '3 Star', '2021-05-11'),
(3, 'Apex Legends', 'Thimira', 'Best2', '3 Star', '2021-05-01');

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE `game` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `version` varchar(100) NOT NULL,
  `date` varchar(100) NOT NULL,
  `developer` varchar(100) NOT NULL,
  `publisher` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`id`, `name`, `version`, `date`, `developer`, `publisher`) VALUES
(1, 'Dota 2', 'Version 7.29', '2021-05-17', 'Malki Cha', 'Thimira'),
(2, 'Dota 2', 'Version 7.28a', '2021-05-20', 'Malki', 'Thimira'),
(3, 'League of Legends', 'Version 7.29', '2021-05-02', 'Rashan', 'Lakshan');

-- --------------------------------------------------------

--
-- Table structure for table `info`
--

CREATE TABLE `info` (
  `id` int(11) NOT NULL,
  `game` varchar(100) NOT NULL,
  `origin` varchar(100) NOT NULL,
  `size` varchar(100) NOT NULL,
  `purpose` varchar(100) NOT NULL,
  `sales` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `info`
--

INSERT INTO `info` (`id`, `game`, `origin`, `size`, `purpose`, `sales`) VALUES
(1, 'League of Legends', '2021-05-13', '1GB', 'deadh', '1000'),
(2, 'Dota 2', '2021-05-13', '1GB', 'dead', '100009');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` int(11) NOT NULL,
  `game` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `card` varchar(100) NOT NULL,
  `cvv` varchar(100) NOT NULL,
  `expire` varchar(100) NOT NULL,
  `amount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`id`, `game`, `name`, `card`, `cvv`, `expire`, `amount`) VALUES
(1, 'League of Legends', 'Thimira', '111111111111111111111', '124', '2021-05-10', 1500);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `age` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `password`, `gender`, `age`, `address`, `phone`) VALUES
(1, 'Thimira', '1111', 'male', '987646832', 'gampaha2', '0987654321'),
(2, 'Malki', '8888', 'male', 'sdcs', 'gampaha2', '0997651234'),
(3, 'aaaaaa', 'mmmm', 'Male', '236', 'Malabe', '0997651234'),
(4, 'aaa', 'aaa', 'Male', 'aa', 'aaaaaaa@gmai.com', '0997651234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `info`
--
ALTER TABLE `info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `game`
--
ALTER TABLE `game`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `info`
--
ALTER TABLE `info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
