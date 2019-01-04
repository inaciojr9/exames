CREATE DATABASE `exames` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `exame` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `descricao` text NOT NULL,
  `cadastro` datetime NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  `obs` text,
  `ultima_atualizacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

