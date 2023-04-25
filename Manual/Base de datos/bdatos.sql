-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-04-2023 a las 01:11:29
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: `bdatos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `d_pedido`
--

CREATE TABLE `d_pedido` (
  `ID` int(7) NOT NULL,
  `ID_Folio` int(7) NOT NULL,
  `ID_Pro` int(7) NOT NULL,
  `Cant` int(5) NOT NULL,
  `Precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Tabla de Detalle de Pedido';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `Folio` int(7) NOT NULL,
  `ID_Us` int(7) NOT NULL,
  `cliente` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `can` int(5) NOT NULL,
  `total` float NOT NULL,
  `cam` float NOT NULL,
  `Fecha` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Tabla de Pedido';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `ID` int(7) NOT NULL,
  `Nom` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Can` int(5) NOT NULL,
  `Pre` float NOT NULL,
  `Des` text COLLATE utf8_unicode_ci NOT NULL,
  `Img` mediumblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Tabla de Producto';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID` int(7) NOT NULL,
  `Nom` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ApPa` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ApMa` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Tel` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Nickname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Cont` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Tabla de Usuario';

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID`, `Nom`, `ApPa`, `ApMa`, `Tel`, `Nickname`, `Cont`) VALUES
(1, 'Admin', '', '', '', 'Admin', '123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `d_pedido`
--
ALTER TABLE `d_pedido`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_Pro` (`ID_Pro`),
  ADD UNIQUE KEY `ID_Folio` (`ID_Folio`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`Folio`),
  ADD UNIQUE KEY `ID_Us` (`ID_Us`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `d_pedido`
--
ALTER TABLE `d_pedido`
  MODIFY `ID` int(7) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `Folio` int(7) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `ID` int(7) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `d_pedido`
--
ALTER TABLE `d_pedido`
  ADD CONSTRAINT `d_pedido_ibfk_1` FOREIGN KEY (`ID_Pro`) REFERENCES `producto` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `d_pedido_ibfk_2` FOREIGN KEY (`ID_Folio`) REFERENCES `pedido` (`Folio`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`ID_Us`) REFERENCES `usuario` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;
