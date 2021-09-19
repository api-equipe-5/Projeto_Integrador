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
-- Estrutura da tabela `participantes`
--

CREATE TABLE `participantes` (
  `id` int(11) NOT NULL,
  `nome` text NOT NULL,
  `sexo` text NOT NULL,
  `dt_nascimento` text NOT NULL,
  `deficiencia` text NOT NULL,
  `descreva` text NOT NULL,
  `renda` text NOT NULL,
  `nome_responsavel` text NOT NULL,
  `sexo_responsavel` text NOT NULL,
  `grau_parentesco` text NOT NULL,
  `grau` text NOT NULL,
  `cpf` int(20) NOT NULL,
  `telefone` int(50) NOT NULL,
  `dt_nascimento_responsavel` text NOT NULL,
  `endereco` text NOT NULL,
  `email` text NOT NULL,
  `criado` timestamp NOT NULL DEFAULT current_timestamp(),
  `modificado` timestamp NULL DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `participantes`
--

INSERT INTO `participantes` (`id`, `nome`, `sexo`, `dt_nascimento`, `deficiencia`, `descreva`, `renda`, `nome_responsavel`, `sexo_responsavel`, `grau_parentesco`, `grau`, `cpf`, `telefone`, `dt_nascimento_responsavel`, `endereco`, `email`, `criado`, `modificado`) VALUES
(1, 'teste 21 de maio', 'Feminino', '2021-05-21', 'sim', 'auditiva', 'Abaixo de um salário', 'pai', 'Masculino', 'Pai', '', 2, 2, '2021-05-21', 'rua estrada 123', 'teste@teste.com', '2021-05-22 01:37:34', NULL),
(2, 'Luis Junior', 'Feminino', '2021-06-03', 'nao', '', 'Abaixo de um salário', 'Luis Geraldo Silva', 'Masculino', 'Outros', 'Tio', 123456789, 1239488888, '1988-06-22', 'Rua Dos Pinheiros, 123 - SJC', 'testeteste@teste.com', '2021-06-17 22:54:12', NULL);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `participantes`
--
ALTER TABLE `participantes`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `participantes`
--
ALTER TABLE `participantes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
