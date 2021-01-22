SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de données : `gestionmedoc`
--
CREATE DATABASE IF NOT EXISTS `gestionmedoc` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `gestionmedoc`;

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `pays` varchar(255) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `rue` varchar(255) NOT NULL,
  `num` varchar(5) NOT NULL,
  `cp` varchar(5) NOT NULL,
  `actif` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

INSERT INTO `client` (`id`, `nom`, `prenom`, `pays`, `ville`, `rue`, `num`, `cp`, `actif`) VALUES
(1, 'beumier', 'brice', 'belgique', 'mignault', 'rue françois onckelet', '17', '7070', 1),
(2, 'beumier', 'chloe', 'belgique', 'ville-sur-haine', 'chaussée de mons', '208', '7070', 1),
(3, 'beumier', 'françois', 'belgique', 'mignault', 'rue léon polart', '42', '7070', 0);

--
-- Structure de la table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total` float NOT NULL,
  `paye` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0 = non\r\n1 = oui',
  `creation` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `facture` (`id`, `total`, `paye`, `creation`) VALUES
(1, 14650, 1, '2020-10-05'),
(2, 18266.1, 0, '2021-01-01');

--
-- Structure de la table `facture_medic`
--

DROP TABLE IF EXISTS `facture_medic`;
CREATE TABLE IF NOT EXISTS `facture_medic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_facture` int(11) NOT NULL,
  `id_medic` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_facture` (`id_facture`),
  KEY `id_medic` (`id_medic`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

INSERT INTO `facture_medic` (`id`, `id_facture`, `id_medic`, `quantite`) VALUES
(1, 1, 1, 1000),
(2, 1, 2, 3000),
(3, 2, 1, 5601),
(4, 2, 2, 654);

--
-- Structure de la table `medicament`
--

DROP TABLE IF EXISTS `medicament`;
CREATE TABLE IF NOT EXISTS `medicament` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `concentration` int(11) DEFAULT NULL,
  `prix` float NOT NULL,
  `quantite_boite` int(11) NOT NULL,
  `unite` varchar(255) NOT NULL COMMENT 'mg,ml,comprimes,...',
  `type` varchar(255) NOT NULL COMMENT 'sirop,gellule,poudre,...',
  `urlDoc` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `medicament` (`id`, `nom`, `concentration`, `prix`, `quantite_boite`, `unite`, `type`, `urlDoc`) VALUES
(1, 'paracetamol', 1000, 2.8, 30, 'mg', 'comprime', 'shorturl.at/aexA2'),
(2, 'toularync dextromethorphan', NULL, 3.95, 160, 'ml', 'sirop', 'shorturl.at/ciG57');

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(15) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_facture` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_client` (`id_client`),
  KEY `id_facture` (`id_facture`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `utilisateur` (`id`, `username`, `password`, `mail`, `id_client`, `id_facture`) VALUES
(1, 'briceb', '05071995', 'brice.beumier@hotmail.fr', 1, 1),
(2, 'chloeb', '27071987', 'chloe.beumier@hotmail.fr', 2, 2);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `facture_medic`
--
ALTER TABLE `facture_medic`
  ADD CONSTRAINT `fk_facture_medic` FOREIGN KEY (`id_facture`) REFERENCES `facture` (`id`),
  ADD CONSTRAINT `fk_medic_facture` FOREIGN KEY (`id_medic`) REFERENCES `medicament` (`id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `fk_user_client` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `fk_user_facture` FOREIGN KEY (`id_facture`) REFERENCES `facture` (`id`);
COMMIT;