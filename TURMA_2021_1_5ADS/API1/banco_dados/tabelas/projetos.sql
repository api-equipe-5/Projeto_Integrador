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
-- Estrutura da tabela `projetos`
--

CREATE TABLE `projetos` (
  `ID` int(11) NOT NULL,
  `Nome` varchar(220) NOT NULL,
  `Telefone` int(11) NOT NULL,
  `Email` varchar(220) NOT NULL,
  `Especialização` varchar(220) NOT NULL,
  `Projeto` varchar(220) NOT NULL,
  `Descrição do Projeto` varchar(220) NOT NULL,
  `Criado` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `projetos`
--

INSERT INTO `projetos` (`ID`, `Nome`, `Telefone`, `Email`, `Especialização`, `Projeto`, `Descrição do Projeto`, `Criado`) VALUES
(1, 'teste 21 de maio', 2147483647, 'teste@teste.com', 'Fotógrafa', 'on', 'Registro das atividades e voluntariados da ONG gratuitamente para divulgação', '2021-05-22 01:41:57'),
(2, 'Juliana Teste Ramos', 1239456789, 'testete@teste.com', 'Design de Roupas', 'on', 'Oferecer oficina para a criação de estampas de roupas destinadas a doação para o CECOI.', '2021-06-17 22:57:04');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `projetos`
--
ALTER TABLE `projetos`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `projetos`
--
ALTER TABLE `projetos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
