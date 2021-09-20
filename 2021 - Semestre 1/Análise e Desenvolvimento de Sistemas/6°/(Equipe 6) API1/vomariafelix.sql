-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 22-Maio-2021 às 03:45
-- Versão do servidor: 10.4.18-MariaDB
-- versão do PHP: 7.4.16

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
  `dt_ascimento` text NOT NULL,
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

INSERT INTO `participantes` (`id`, `nome`, `sexo`, `dt_ascimento`, `deficiencia`, `descreva`, `renda`, `nome_responsavel`, `sexo_responsavel`, `grau_parentesco`, `grau`, `cpf`, `telefone`, `dt_nascimento_responsavel`, `endereco`, `email`, `criado`, `modificado`) VALUES
(1, 'teste 21 de maio', 'Feminino', '2021-05-21', 'sim', 'auditiva', 'Abaixo de um salário', 'pai', 'Masculino', 'Pai', '', 2, 2, '2021-05-21', 'rua estrada 123', 'teste@teste.com', '2021-05-22 01:37:34', NULL);

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
(1, 'teste 21 de maio', 2147483647, 'teste@teste.com', 'Fotógrafa', 'on', 'Registro das atividades e voluntariados da ONG gratuitamente para divulgação', '2021-05-22 01:41:57');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `ID` int(11) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `senha` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`ID`, `cpf`, `senha`) VALUES
(1, '12345678910', '12345678910'),
(2, '123', 'segredo');

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
(1, 'teste 21 de maio', 'Feminino', 222, '2021-05-21', 'aaaa', 'aaa', 222, 'aaaa@teste.com', 'nada', 'manhã e tarde', '2021-05-22 01:39:53');

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
(1, 'teste 21 de maio', 'Feminino', 2222, '', 'rua fatec ads 123', 'sjc', 2147483647, 'teste@teste.com', 'Tarde', 'Fotógrafa', '2021-05-22 01:41:57');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `participantes`
--
ALTER TABLE `participantes`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `projetos`
--
ALTER TABLE `projetos`
  ADD PRIMARY KEY (`ID`);

--
-- Índices para tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`ID`);

--
-- Índices para tabela `voluntario_apoio`
--
ALTER TABLE `voluntario_apoio`
  ADD PRIMARY KEY (`ID`);

--
-- Índices para tabela `voluntario_especifico`
--
ALTER TABLE `voluntario_especifico`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `participantes`
--
ALTER TABLE `participantes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `projetos`
--
ALTER TABLE `projetos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `voluntario_apoio`
--
ALTER TABLE `voluntario_apoio`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `voluntario_especifico`
--
ALTER TABLE `voluntario_especifico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
