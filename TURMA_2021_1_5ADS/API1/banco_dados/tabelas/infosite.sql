-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 18-Jun-2021 às 01:03
-- Versão do servidor: 10.4.19-MariaDB
-- versão do PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `vomariafelix`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `infosite`
--

CREATE TABLE `infosite` (
  `ID` int(11) NOT NULL,
  `saibatexto` text NOT NULL,
  `saibaend` varchar(220) NOT NULL,
  `saibatel` varchar(40) NOT NULL,
  `saibahor` varchar(100) NOT NULL,
  `saibaatend` varchar(200) NOT NULL,
  `projtit1` varchar(60) NOT NULL,
  `projdesc1` text NOT NULL,
  `projtit2` varchar(60) NOT NULL,
  `projdesc2` text NOT NULL,
  `doabanco` varchar(40) NOT NULL,
  `doaagencia` varchar(10) NOT NULL,
  `doaconta` varchar(20) NOT NULL,
  `doacnpj` varchar(20) NOT NULL,
  `doafav` varchar(40) NOT NULL,
  `doapix` varchar(60) NOT NULL,
  `criado` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `infosite`
--

INSERT INTO `infosite` (`ID`, `saibatexto`, `saibaend`, `saibatel`, `saibahor`, `saibaatend`, `projtit1`, `projdesc1`, `projtit2`, `projdesc2`, `doabanco`, `doaagencia`, `doaconta`, `doacnpj`, `doafav`, `doapix`, `criado`) VALUES
(1, 'Texto teste: informações da ong, história, missão, etc.', 'Rua. Carlos Nunes de Paula, 1172\r\n(Prédios contíguos à Rua Dom João VI, nº 151 e 161)\r\nJardim Imperial – São José dos Campos/SP. CEP: 12.234-000', '(12) 3966-2823', 'Segunda a Sexta, das 07:00h às 17:00h', 'Crianças de 0 a 7 anos', 'Projeto 1', 'Descrição do projeto 1', 'Projeto 2', 'Descrição do projeto2', 'Exemplo', '1234', '000000-0', '00.000.000-0000/00', 'Exemplo S.A.', '(email) exemplo@exemplo.com', '0000-00-00 00:00:00');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `infosite`
--
ALTER TABLE `infosite`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `infosite`
--
ALTER TABLE `infosite`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
