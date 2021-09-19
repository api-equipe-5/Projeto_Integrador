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
-- Estrutura da tabela `voluntario_especifico`
--

CREATE TABLE `voluntario_especifico` (
  `id` int(11) NOT NULL,
  `Nome` text NOT NULL,
  `Sexo` varchar(220) NOT NULL,
  `CPF` int(30) NOT NULL,
  `Data Nascimento` text NOT NULL,
  `Endereço` text NOT NULL,
  `Cidade` text NOT NULL,
  `Telefone` int(30) NOT NULL,
  `Email` text NOT NULL,
  `Disponibilidade` text NOT NULL,
  `Especialização` text NOT NULL,
  `Criado` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `voluntario_especifico`
--

INSERT INTO `voluntario_especifico` (`id`, `Nome`, `Sexo`, `CPF`, `Data Nascimento`, `Endereço`, `Cidade`, `Telefone`, `Email`, `Disponibilidade`, `Especialização`, `Criado`) VALUES
(1, 'teste 21 de maio', 'Feminino', 2222, '29/06/2020', 'rua fatec ads 123', 'sjc', 2147483647, 'teste@teste.com', 'Tarde', 'Fotógrafa', '2021-05-22 01:41:57'),
(2, 'Juliana Teste Ramos', 'Feminino', 123456789, '', 'Rua Fatec Campos,123', 'São José dos Campos', 1239456789, 'testete@teste.com', 'Tarde', 'Design de Roupas', '2021-06-17 22:57:04');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `voluntario_especifico`
--
ALTER TABLE `voluntario_especifico`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `voluntario_especifico`
--
ALTER TABLE `voluntario_especifico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
