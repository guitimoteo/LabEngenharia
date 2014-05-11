-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Máquina: 127.0.0.1
-- Data de Criação: 14-Nov-2013 às 16:40
-- Versão do servidor: 5.5.32
-- versão do PHP: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `livraria`
--
CREATE DATABASE IF NOT EXISTS `livraria` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `livraria`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `autor`
--

CREATE TABLE IF NOT EXISTS `autor` (
  `nome` varchar(50) DEFAULT NULL,
  `cod` int(3) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `autor`
--

INSERT INTO `autor` (`nome`, `cod`) VALUES
('Paulo Coelho', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `cod` varchar(20) NOT NULL,
  `nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`cod`, `nome`) VALUES
('Hj-65', 'Ficção horrorifica');

-- --------------------------------------------------------

--
-- Estrutura da tabela `livro`
--

CREATE TABLE IF NOT EXISTS `livro` (
  `titulo` int(3) DEFAULT NULL,
  `dataPublicacao` date DEFAULT NULL,
  `editora` int(3) DEFAULT NULL,
  `precoVenda` double DEFAULT NULL,
  `resumo` varchar(255) DEFAULT NULL,
  `indice` varchar(255) DEFAULT NULL,
  `precoCusto` double DEFAULT NULL,
  `vendido` tinyint(1) DEFAULT NULL,
  `autor` int(3) DEFAULT NULL,
  `formato` varchar(50) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `livro`
--

INSERT INTO `livro` (`titulo`, `dataPublicacao`, `editora`, `precoVenda`, `resumo`, `indice`, `precoCusto`, `vendido`, `autor`, `formato`, `id`, `categoria`) VALUES
(1, '2000-09-10', 0, 345, 'Caique fez merda e agora não fuinciona.', '1', 129, 0, 1, 'brochura', 1, 'Hj-65');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE IF NOT EXISTS `pedido` (
  `codItemPedido` int(11) NOT NULL AUTO_INCREMENT,
  `codPedido` int(11) NOT NULL,
  `codUsuario` int(11) NOT NULL,
  `codLivro` int(11) NOT NULL,
  PRIMARY KEY (`codItemPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `titulo`
--

CREATE TABLE IF NOT EXISTS `titulo` (
  `titulo` varchar(100) DEFAULT NULL,
  `cod` int(3) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(20) NOT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `titulo`
--

INSERT INTO `titulo` (`titulo`, `cod`, `isbn`) VALUES
('Titulo', 1, '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `nome` varchar(50) DEFAULT NULL,
  `dataNasc` date DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `login` varchar(20) DEFAULT NULL,
  `senha` varchar(20) DEFAULT NULL,
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`nome`, `dataNasc`, `cpf`, `endereco`, `login`, `senha`, `cod`) VALUES
('david', '1993-01-01', '12312312340', 'rua paris,45', 'david', 'david', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
