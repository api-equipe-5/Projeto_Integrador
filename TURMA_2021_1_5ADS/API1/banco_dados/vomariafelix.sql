-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 18-Jun-2021 às 01:02
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
-- Estrutura da tabela `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `admin`
--

INSERT INTO `admin` (`id`, `email`, `password`, `name`) VALUES
(1, 'vomaria@admin.com', 'admin123', 'Administrador'),
(4, 'teste@teste.com', 'teste', 'Teste');

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
-- Índices para tabela `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `contato_msg`
--
ALTER TABLE `contato_msg`
  ADD PRIMARY KEY (`ID`);

--
-- Índices para tabela `infosite`
--
ALTER TABLE `infosite`
  ADD PRIMARY KEY (`ID`);

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
-- AUTO_INCREMENT de tabela `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `contato_msg`
--
ALTER TABLE `contato_msg`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de tabela `infosite`
--
ALTER TABLE `infosite`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `participantes`
--
ALTER TABLE `participantes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `projetos`
--
ALTER TABLE `projetos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `voluntario_apoio`
--
ALTER TABLE `voluntario_apoio`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `voluntario_especifico`
--
ALTER TABLE `voluntario_especifico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
