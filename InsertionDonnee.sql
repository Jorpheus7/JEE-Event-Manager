-- Utiliser le script de creation de base du package oneshot

INSERT INTO Users( mail, passwd) VALUES('a@mail.fr', 'azerty1');
INSERT INTO Users( mail, passwd) VALUES('b@mail.fr', 'azerty2');
INSERT INTO Users( mail, passwd) VALUES('c@mail.fr', 'azerty3');

SELECT * FROM Users;

INSERT INTO Events( nom, adresse, idCreateur, actif, dateDebut, heureDebut, dateFin, heureFin)
VALUES( 'a','adresse1',1,0'2014-10-20','15/10/2014','00:00:00','00:00:00');
INSERT INTO Events( nom, adresse, idCreateur, actif, dateDebut, heureDebut, dateFin, heureFin)
VALUES('b','adresse2',1,1'2014-10-28','00:00:00','2014-10-29','00:00:00');
INSERT INTO Events( nom, adresse, idCreateur, actif, dateDebut, heureDebut, dateFin, heureFin)
VALUES('c','adresse3',1,0'2014-10-28','00:00:00','2014-10-29','00:00:00');

SELECT * FROM Events;

INSERT INTO Participants(idEvent, nom, prenom, societe, mail)
VALUES(1,'nom1','prenom1','societea','a@mail.fr');
INSERT INTO Participants(idEvent, nom, prenom, societe, mail)
VALUES(2,'nom2','prenom2','societeb','a@mail.fr');
INSERT INTO Participants(idEvent, nom, prenom, societe, mail)
VALUES(3,'nom3','prenom3','societed','d@mail.fr');