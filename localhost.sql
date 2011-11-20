-- phpMyAdmin SQL Dump
-- version 3.4.5deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 18-11-2011 a las 13:45:45
-- Versión del servidor: 5.1.58
-- Versión de PHP: 5.3.6-13ubuntu3.2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `simple`
--
CREATE DATABASE `simple` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci;
USE `simple`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Curso`
--

DROP TABLE IF EXISTS `Curso`;
CREATE TABLE IF NOT EXISTS `Curso` (
  `numeroExpediente` int(11) NOT NULL,
  `nombreCurso` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `fechaComienzo` date NOT NULL,
  `horas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `Curso`
--

INSERT INTO `Curso` (`numeroExpediente`, `nombreCurso`, `fechaComienzo`, `horas`) VALUES
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200),
(9, 'UML', '2011-02-10', 200);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Evaluacion`
--

DROP TABLE IF EXISTS `Evaluacion`;
CREATE TABLE IF NOT EXISTS `Evaluacion` (
  `dniPersona` int(7) NOT NULL,
  `puntuacion` float NOT NULL,
  `fecha` date NOT NULL,
  `numExpedienteCurso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `Evaluacion`
--

INSERT INTO `Evaluacion` (`dniPersona`, `puntuacion`, `fecha`, `numExpedienteCurso`) VALUES
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9),
(6088863, 7, '2011-02-10', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Persona`
--

DROP TABLE IF EXISTS `Persona`;
CREATE TABLE IF NOT EXISTS `Persona` (
  `dni` int(7) NOT NULL,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `Persona`
--

INSERT INTO `Persona` (`dni`, `nombre`) VALUES
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco'),
(6088863, 'Mirco');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Tabla1`
--

DROP TABLE IF EXISTS `Tabla1`;
CREATE TABLE IF NOT EXISTS `Tabla1` (
  `campoEntero` int(11) NOT NULL,
  `campoTexto` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `campoFloat` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `Tabla1`
--

INSERT INTO `Tabla1` (`campoEntero`, `campoTexto`, `campoFloat`) VALUES
(1, 'texto1', 1.1),
(2, 'texto2', 2.2),
(3, 'texto3', 3.3),
(4, 'texto4', 4.4),
(5, 'texto5', 5.5),
(6, 'texto6', 6.6);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
