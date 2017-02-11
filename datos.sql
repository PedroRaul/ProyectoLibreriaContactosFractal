-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-02-2017 a las 18:58:04
-- Versión del servidor: 5.6.20
-- Versión de PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `datos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contacto`
--

CREATE TABLE IF NOT EXISTS `contacto` (
  `IdPersona` int(100) NOT NULL,
  `Profesion` varchar(50) NOT NULL,
  `Contactos` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deportista`
--

CREATE TABLE IF NOT EXISTS `deportista` (
  `Nombre` varchar(50) NOT NULL,
  `ApePa` varchar(50) NOT NULL,
  `ApeMa` varchar(50) DEFAULT NULL,
  `Genero` varchar(50) NOT NULL,
  `FechaNac` varchar(50) DEFAULT NULL,
  `Deporte` varchar(50) NOT NULL,
`IdPersona` int(100) NOT NULL,
  `Profesion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doctor`
--

CREATE TABLE IF NOT EXISTS `doctor` (
  `Nombre` varchar(50) NOT NULL,
  `ApePa` varchar(50) NOT NULL,
  `ApeMa` varchar(50) DEFAULT NULL,
  `FechaNac` varchar(50) NOT NULL,
  `Especialidad` varchar(50) NOT NULL,
  `NombreH` varchar(50) DEFAULT NULL,
  `DireccionH` varchar(50) DEFAULT NULL,
`IdPersona` int(100) NOT NULL,
  `Profesion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE IF NOT EXISTS `estudiante` (
  `Nombre` varchar(50) NOT NULL,
  `ApePa` varchar(50) NOT NULL,
  `ApeMa` varchar(50) DEFAULT NULL,
  `LugarNac` varchar(50) NOT NULL,
  `FechaNac` varchar(50) DEFAULT NULL,
  `Carrera` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
`IdPersona` int(100) NOT NULL,
  `Profesion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `licenciado`
--

CREATE TABLE IF NOT EXISTS `licenciado` (
  `Nombre` varchar(50) NOT NULL,
  `ApePa` varchar(50) NOT NULL,
  `ApeMa` varchar(50) DEFAULT NULL,
  `TelOficina` varchar(50) NOT NULL,
  `HorarioIn` varchar(50) NOT NULL,
  `HorarioFin` varchar(50) NOT NULL,
`IdPersona` int(100) NOT NULL,
  `Profesion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `Nombre` varchar(50) NOT NULL,
  `ApePa` varchar(50) NOT NULL,
  `ApeMa` varchar(50) DEFAULT NULL,
  `Domicilio` varchar(50) NOT NULL,
  `MedioPreferido` varchar(50) DEFAULT NULL,
  `Ocupacion` varchar(50) NOT NULL,
`IdPersona` int(100) NOT NULL,
  `Profesion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `deportista`
--
ALTER TABLE `deportista`
 ADD PRIMARY KEY (`IdPersona`);

--
-- Indices de la tabla `doctor`
--
ALTER TABLE `doctor`
 ADD PRIMARY KEY (`IdPersona`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
 ADD PRIMARY KEY (`IdPersona`);

--
-- Indices de la tabla `licenciado`
--
ALTER TABLE `licenciado`
 ADD PRIMARY KEY (`IdPersona`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
 ADD PRIMARY KEY (`IdPersona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `deportista`
--
ALTER TABLE `deportista`
MODIFY `IdPersona` int(100) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `doctor`
--
ALTER TABLE `doctor`
MODIFY `IdPersona` int(100) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `estudiante`
--
ALTER TABLE `estudiante`
MODIFY `IdPersona` int(100) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `licenciado`
--
ALTER TABLE `licenciado`
MODIFY `IdPersona` int(100) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
MODIFY `IdPersona` int(100) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
