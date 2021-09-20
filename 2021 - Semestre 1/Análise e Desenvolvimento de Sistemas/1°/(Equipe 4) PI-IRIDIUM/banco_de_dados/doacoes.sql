-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 15-Maio-2021 às 00:29
-- Versão do servidor: 5.7.31
-- versão do PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `doacoes`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `anonima`
--

DROP TABLE IF EXISTS `anonima`;
CREATE TABLE IF NOT EXISTS `anonima` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `contribuicao` varchar(220) NOT NULL,
  `created` datetime NOT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `doacao`
--

DROP TABLE IF EXISTS `doacao`;
CREATE TABLE IF NOT EXISTS `doacao` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `nome` varchar(220) NOT NULL,
  `sobrenome` varchar(220) NOT NULL,
  `cpf` varchar(220) NOT NULL,
  `email` varchar(220) NOT NULL,
  `celular` varchar(220) NOT NULL,
  `nascimento` varchar(220) NOT NULL,
  `doacao` varchar(220) NOT NULL,
  `created` datetime NOT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
