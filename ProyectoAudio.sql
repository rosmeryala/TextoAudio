-- phpMyAdmin SQL Dump
-- version 4.2.6deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-11-2014 a las 13:59:24
-- Versión del servidor: 5.5.40-0ubuntu1
-- Versión de PHP: 5.5.12-2ubuntu4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `ProyectoAudio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Texto`
--

CREATE TABLE IF NOT EXISTS `Texto` (
`idTexto` int(200) NOT NULL,
  `Titulo` varchar(45) DEFAULT NULL,
  `Texto` varchar(800) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=37 ;

--
-- Volcado de datos para la tabla `Texto`
--

INSERT INTO `Texto` (`idTexto`, `Titulo`, `Texto`) VALUES
(1, NULL, 'hola texto de prueba para el audio'),
(2, 'Hola ', 'prueba del texto\r\n                        '),
(3, 'Hola ', 'Prueba del texto a ingresar'),
(4, 'Desarrollo lo mejor del mundo', 'Web Developer                            \r\n                        '),
(5, 'Desarrollo lo mejor del mundo', 'Y veras que no existe el dolor hoy te toca ser feliz'),
(6, 'Desarrollo lo mejor del mundo', 'Hola prueba de sonido 1'),
(7, 'Hola ', 'esta es la prueba '),
(8, 'Hola ', 'I am Danniel Navas'),
(9, 'Desarrollo lo mejor del mundo', 'i like developer'),
(10, 'I am Daniel ', 'My name is danniel i am 24 years old i like pizza                            \r\n                        '),
(11, 'I am Daniel ', 'I like pizza and popatoes'),
(12, 'I am Daniel ', 'I like pizza'),
(13, 'I am Daniel ', 'I am developer '),
(14, 'Proxima parada calle 106', 'Destino portal norte'),
(15, 'I am Daniel ', 'I am developer'),
(16, 'I am Daniel ', 'i am developer'),
(17, 'I am Daniel ', 'i am developer'),
(18, 'I am Daniel ', 'I am developer'),
(19, 'I am Daniel ', 'i like developer'),
(20, 'I am Daniel ', 'i like developer'),
(21, 'I am Daniel ', 'i am developer'),
(22, 'I am Daniel ', 'I am developer'),
(23, 'I am Daniel ', 'i am developer'),
(24, 'I am Daniel ', 'i am developer, i like pizza'),
(25, 'I am Daniel ', 'I like pizza'),
(26, 'I am Daniel ', 'i am developer'),
(27, 'I am Daniel ', 'i am developer'),
(28, 'I am Daniel ', 'i am developer'),
(29, 'hi diana ', 'my name is danniel '),
(30, 'I am Daniel ', 'i like'),
(31, 'I am Daniel ', 'i like'),
(32, 'I am Daniel ', 'i like  dream'),
(33, 'I am Daniel ', 'I love developer'),
(34, 'I am Daniel ', 'i like pizza'),
(35, 'I am Alonzo ', 'developer hero'),
(36, 'I am Daniel ', 'i am developer i am hero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TipoUsuario`
--

CREATE TABLE IF NOT EXISTS `TipoUsuario` (
  `category_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `TipoUsuario`
--

INSERT INTO `TipoUsuario` (`category_id`, `name`) VALUES
(1, 'Administradir'),
(2, 'Usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuarios`
--

CREATE TABLE IF NOT EXISTS `Usuarios` (
  `username` varchar(16) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `TipoUsuario_category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Usuarios`
--

INSERT INTO `Usuarios` (`username`, `email`, `password`, `create_time`, `TipoUsuario_category_id`) VALUES
('Admin', 'admin@proyecto.com.co', '123456', NULL, 1),
('User', 'user@proyecto.com.co', '123456', NULL, 2),
('prueba', 'prueba@proyecto.com.co', 'e10adc3949ba59abbe56e057f20f883e', NULL, 1),
('dante', 'darker13@outlook.com', 'e10adc3949ba59abbe56e057f20f883e', NULL, 2),
('darker', 'darker13@outlook.com', '123456', '2014-11-13 01:29:59', 1),
('dann', 'darker13@outlook.com', '123456', '2014-11-13 01:32:04', 2),
('dann', 'darker13@outlook.com', '123456', '2014-11-13 01:34:15', 2),
('danniel', 'darker13@outlook.com', 'd48e55ead3d8be312520976242275863', '2014-11-17 23:48:10', 2),
('alonzo', 'darker13@outlook.com', '202cb962ac59075b964b07152d234b70', '2014-11-19 04:41:24', 2),
('danniel', 'darker13@outlook.com', 'd48e55ead3d8be312520976242275863', '2014-11-19 17:57:46', 2),
('Andrea', 'darker13@outlook.com', 'd48e55ead3d8be312520976242275863', '2014-11-19 18:57:33', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Texto`
--
ALTER TABLE `Texto`
 ADD PRIMARY KEY (`idTexto`);

--
-- Indices de la tabla `TipoUsuario`
--
ALTER TABLE `TipoUsuario`
 ADD PRIMARY KEY (`category_id`);

--
-- Indices de la tabla `Usuarios`
--
ALTER TABLE `Usuarios`
 ADD KEY `fk_Usuarios_TipoUsuario_idx` (`TipoUsuario_category_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Texto`
--
ALTER TABLE `Texto`
MODIFY `idTexto` int(200) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=37;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Usuarios`
--
ALTER TABLE `Usuarios`
ADD CONSTRAINT `fk_Usuarios_TipoUsuario` FOREIGN KEY (`TipoUsuario_category_id`) REFERENCES `TipoUsuario` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
