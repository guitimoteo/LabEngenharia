-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: Mai 19, 2014 as 12:31 AM
-- Versão do Servidor: 5.1.44
-- Versão do PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `livraria`
--

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
-- Estrutura da tabela `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
  `matricula` int(11) NOT NULL AUTO_INCREMENT,
  `senha` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`matricula`, `senha`, `nome`) VALUES
(1, 999, 'usuario');

-- --------------------------------------------------------

--
-- Estrutura da tabela `livro`
--

CREATE TABLE IF NOT EXISTS `livro` (
  `titulo` int(3) DEFAULT NULL,
  `dataPublicacao` date DEFAULT NULL,
  `editora` varchar(300) NOT NULL,
  `precoVenda` double DEFAULT NULL,
  `resumo` varchar(255) DEFAULT NULL,
  `indice` varchar(255) DEFAULT NULL,
  `precoCusto` double DEFAULT NULL,
  `vendido` tinyint(1) DEFAULT NULL,
  `autor` int(3) DEFAULT NULL,
  `formato` varchar(50) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(20) NOT NULL,
  `quantidade` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `livro`
--

INSERT INTO `livro` (`titulo`, `dataPublicacao`, `editora`, `precoVenda`, `resumo`, `indice`, `precoCusto`, `vendido`, `autor`, `formato`, `id`, `categoria`, `quantidade`) VALUES
(1, '2000-09-10', 'Abril', 345, 'Caique fez merda e agora não fuinciona.', '1', 129, 0, 1, 'brochura', 1, 'Hj-65', 0),
(3, '1999-09-09', 'Abril', 120, 'Resumo', 'Indice', 100, NULL, 1, 'Capa dura', 2, 'Ficção', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE IF NOT EXISTS `pedido` (
  `codItemPedido` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `codPedido` int(11) NOT NULL,
  `codUsuario` int(11) NOT NULL,
  `codLivro` int(11) NOT NULL,
  `qtd` int(11) NOT NULL,
  PRIMARY KEY (`codItemPedido`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Extraindo dados da tabela `pedido`
--

INSERT INTO `pedido` (`codItemPedido`, `data`, `codPedido`, `codUsuario`, `codLivro`, `qtd`) VALUES
(9, '2013-11-22', 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `titulo`
--

CREATE TABLE IF NOT EXISTS `titulo` (
  `titulo` varchar(100) DEFAULT NULL,
  `cod` int(3) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(20) NOT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `titulo`
--

INSERT INTO `titulo` (`titulo`, `cod`, `isbn`) VALUES
('Titulo', 1, ''),
('As memorias de um gigolo', 2, '1234-1234-1235-5321'),
('As cronicas de narnia', 3, '1234-6542-8765-3333');

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
