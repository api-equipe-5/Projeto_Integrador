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
-- Estrutura da tabela `contato_msg`
--

CREATE TABLE `contato_msg` (
  `ID` int(11) NOT NULL,
  `nome` varchar(220) NOT NULL,
  `email` varchar(220) NOT NULL,
  `mensagem` text NOT NULL,
  `criado` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `contato_msg`
--

INSERT INTO `contato_msg` (`ID`, `nome`, `email`, `mensagem`, `criado`) VALUES
(1, '2222222', '222@gmail.com', 'aaaaaaaaaaaaaaaaaaaaaaaaa', '0000-00-00 00:00:00'),
(23, 'TESTE SPRINT4', 'TESTE@gmail.com', 'Essa é uma mensagem de teste!', '0000-00-00 00:00:00'),
(24, 'teste', 'teste@teste.com', 'mensagem de teste!', '0000-00-00 00:00:00'),
(25, 'ju', 'ju@gmail.com', '123', '0000-00-00 00:00:00'),
(26, '123', '123@gmail.com', '12345', '0000-00-00 00:00:00'),
(27, 'Teste sprint 4', 'teste@teste.com', 'Gostaria de fazer uma matéria sobre o CECOI. Caso haja interesse, responder o e-mail. Grata!', '0000-00-00 00:00:00');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `contato_msg`
--
ALTER TABLE `contato_msg`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `contato_msg`
--
ALTER TABLE `contato_msg`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
