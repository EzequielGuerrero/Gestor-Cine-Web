-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-06-2024 a las 19:12:24
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tucine`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cines`
--

CREATE TABLE `cines` (
  `identificador` int(11) NOT NULL,
  `nombreCine` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cines`
--

INSERT INTO `cines` (`identificador`, `nombreCine`, `direccion`) VALUES
(1, 'Cinepolis Plaza Central', 'Av. Plaza Central 200, Ciudad de México'),
(2, 'CineMark Ciudadela', 'Av. Ciudadela 100, Ciudad de México'),
(3, 'Cinemex Reforma 222', 'Av. Reforma 222, Ciudad de México'),
(4, 'Cinepolis Perisur', 'Av. Perisur 300, Ciudad de México'),
(5, 'Cinemex Insurgentes', 'Av. Insurgentes 400, Ciudad de México'),
(6, 'CineMark Satélite', 'Av. Satélite 500, Ciudad de México'),
(8, 'Cinemex Antara', 'Av. Antara 700, Ciudad de México'),
(9, 'CineMark Polanco', 'Av. Polanco 800, Ciudad de México'),
(10, 'Cinepolis Universidad', 'Av. Universidad 900, Ciudad de México'),
(11, 'Cinemex Toreo', 'Av. Toreo 1000, Ciudad de México'),
(12, 'Cinepolis Santa Fe', 'Av. Santa Fe 1100, Ciudad de México'),
(13, 'CineMark Interlomas', 'Av. Interlomas 1200, Ciudad de México'),
(21, 'Cine de la casa', 'Casita');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `identificador` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `duracionMinutos` int(11) NOT NULL,
  `genero` varchar(50) NOT NULL,
  `director` varchar(255) NOT NULL,
  `clasificacionEdad` int(11) NOT NULL,
  `precio` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`identificador`, `titulo`, `duracionMinutos`, `genero`, `director`, `clasificacionEdad`, `precio`) VALUES
(3, 'The Dark Knight (Batman)', 152, 'Action', 'Christopher Nolan', 14, 10.99),
(4, 'Pulp Fiction', 154, 'Crime', 'Quentin Tarantino', 18, 11.99),
(5, 'The Lord of the Rings: The Return of the King', 201, 'Fantasy', 'Peter Jackson', 12, 14.99),
(6, 'Forrest Gump', 142, 'Drama', 'Robert Zemeckis', 12, 8.99),
(7, 'Inception', 148, 'Sci-Fi', 'Christopher Nolan', 12, 10.99),
(8, 'Fight Club', 139, 'Drama', 'David Fincher', 18, 9.99),
(9, 'The Matrix', 136, 'Sci-Fi', 'Lana Wachowski, Lilly Wachowski', 14, 8.99),
(12, 'Schindler\'s List', 195, 'Biography', 'Steven Spielberg', 15, 12.99),
(13, 'The Lord of the Rings: The Fellowship of the Ring', 178, 'Fantasy', 'Peter Jackson', 12, 14.99);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salas`
--

CREATE TABLE `salas` (
  `identificador` int(11) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `metrosCuadrados` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `salas`
--

INSERT INTO `salas` (`identificador`, `capacidad`, `metrosCuadrados`) VALUES
(6, 50, 66.00),
(8, 66, 66.00),
(11, 130, 190.10),
(12, 253, 115.90),
(14, 101, 151.00);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cines`
--
ALTER TABLE `cines`
  ADD PRIMARY KEY (`identificador`);

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`identificador`);

--
-- Indices de la tabla `salas`
--
ALTER TABLE `salas`
  ADD PRIMARY KEY (`identificador`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cines`
--
ALTER TABLE `cines`
  MODIFY `identificador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  MODIFY `identificador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `salas`
--
ALTER TABLE `salas`
  MODIFY `identificador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
