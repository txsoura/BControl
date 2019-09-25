-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 27, 2018 at 02:11 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bcontrol`
--

-- --------------------------------------------------------

--
-- Table structure for table `cesto`
--

CREATE TABLE `cesto` (
  `codigo` varchar(8) NOT NULL,
  `nome` tinytext NOT NULL,
  `quantidade` int(11) NOT NULL,
  `total` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `funcionario`
--

CREATE TABLE `funcionario` (
  `nome` varchar(80) NOT NULL,
  `contacto` bigint(9) NOT NULL,
  `endereco` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `funcionario`
--

INSERT INTO `funcionario` (`nome`, `contacto`, `endereco`) VALUES
('outro3', 844916249, ',nvhjmvh'),
('teste', 123456789, '.k,n,kjnk'),
('xy', 844912345, 'vcxbgfbnf');

-- --------------------------------------------------------

--
-- Table structure for table `produto`
--

CREATE TABLE `produto` (
  `nome` tinytext NOT NULL,
  `preco` double(10,2) NOT NULL,
  `desconto` tinyint(3) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `codigo` varchar(8) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `produto`
--

INSERT INTO `produto` (`nome`, `preco`, `desconto`, `quantidade`, `codigo`, `data`) VALUES
('x', 100.00, 0, 50, 'C100', '2018-11-07 17:37:07'),
('qualquer', 50.00, 0, 285, 'c50', '2018-11-17 18:27:34'),
('artigos de crianca', 50.00, 0, 50, 'C500', '2018-11-03 10:49:20'),
('teste cupom', -5.00, 0, 8, 'D5', '2018-11-17 08:28:11'),
('estranho', 1.00, 0, 6, 'h1', '2018-11-16 08:12:02'),
('teste', 10.00, 5, 5, 'h10', '2018-11-17 08:32:43'),
('ha', 20.00, 0, 20, 'H20', '2018-11-07 17:37:08'),
('h100', 80.00, 10, 5, 'H80', '2018-11-17 18:27:34'),
('outro', 100.00, 0, 980, 'm100', '2018-11-17 18:26:07');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `nome` varchar(80) NOT NULL,
  `senha` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`nome`, `senha`) VALUES
('outro3', '7b52009b64fd0a2a49e6d8a939753077792b0554'),
('teste', '7110eda4d09e062aa5e4a390b0a572ac0d2c0220'),
('xy', '8cb2237d0679ca88db6464eac60da96345513964');

-- --------------------------------------------------------

--
-- Table structure for table `venda`
--

CREATE TABLE `venda` (
  `codigo` varchar(8) NOT NULL,
  `nome` tinytext NOT NULL,
  `quantidade` int(11) NOT NULL,
  `total` double(10,2) NOT NULL,
  `funcionario` varchar(80) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `cliente` tinytext,
  `contacto` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `venda`
--

INSERT INTO `venda` (`codigo`, `nome`, `quantidade`, `total`, `funcionario`, `data`, `cliente`, `contacto`) VALUES
('1', 'estranho', 1, 1.00, 'teste', '2018-10-06', NULL, NULL),
('2', 'outro', 1, 100.00, 'teste', '2018-10-06', NULL, NULL),
('3', 'qualquer', 1, 100.00, 'teste', '2018-10-06', NULL, NULL),
('3', 'qualquer', 2, 100.00, 'outro3', '2018-10-25', 'gh', 258),
('3', 'qualquer', 1, 50.00, 'outro3', '2018-10-25', 'gh', 258),
('3', 'qualquer', 2, 100.00, 'outro3', '2018-10-25', ',jbhk', 258),
('3', 'qualquer', 1, 50.00, 'outro3', '2018-10-25', ',jbhk', 258),
('4', 'teste', 2, 20.00, 'outro3', '2018-10-28', 'dkaras', 258849864),
('c50', 'qualquer', 3, 150.00, 'outro3', '2018-10-28', 'teste', 258),
('c50', 'qualquer', 3, 150.00, 'outro3', '2018-10-28', 'outro3', 258),
('c50', 'qualquer', 2, 100.00, 'Nome', '2018-10-28', 'hkgkyu', 258),
('c50', 'qualquer', 2, 100.00, 'xy', '2018-11-07', 'xy', 25854646);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`nome`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`nome`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
