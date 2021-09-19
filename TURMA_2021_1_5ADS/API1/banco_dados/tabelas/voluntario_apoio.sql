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
-- Estrutura da tabela `voluntario_apoio`
--

CREATE TABLE `voluntario_apoio` (
  `ID` int(11) NOT NULL,
  `Nome` text NOT NULL,
  `Sexo` text NOT NULL,
  `CPF` int(50) NOT NULL,
  `Data de nascimento` text NOT NULL,
  `Endereço` text NOT NULL,
  `Cidade` text NOT NULL,
  `Telefone` int(50) NOT NULL,
  `Email` text NOT NULL,
  `Profissão` text NOT NULL,
  `Disponibilidade` text NOT NULL,
  `Criado` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `voluntario_apoio`
--

INSERT INTO `voluntario_apoio` (`ID`, `Nome`, `Sexo`, `CPF`, `Data de nascimento`, `Endereço`, `Cidade`, `Telefone`, `Email`, `Profissão`, `Disponibilidade`, `Criado`) VALUES
(1, 'teste 21 de maio', 'Feminino', 222, '2021-05-21', 'aaaa', 'aaa', 222, 'aaaa@teste.com', 'nada', 'manhã e tarde', '2021-05-22 01:39:53'),
(4, 'Juliana Maria', 'Feminino', 12345678, '1998-06-29', 'Estrada do Florindo 3149', 'São José dos Campos', 2147483647, 'juliana@teste.com', 'Professora', 'Manhã', '2021-06-17 22:55:20');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `voluntario_apoio`
--
ALTER TABLE `voluntario_apoio`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `voluntario_apoio`
--
ALTER TABLE `voluntario_apoio`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
