INSERT INTO Users(id, mail, passwd) VALUES(1,'a@mail.fr', 'azerty1');
INSERT INTO Users(id, mail, passwd) VALUES(2,'b@mail.fr', 'azerty2');
INSERT INTO Users(id, mail, passwd) VALUES(3,'c@mail.fr', 'azerty3');

INSERT INTO Events(id, nom, adresse, idCreateur, actif, dateDebut, heureDebut, dateFin, heureFin)
VALUES(1, 'a','adresse1',1,'2014-10-28','00:00:00','2014-10-29','00:00:00');
INSERT INTO Events(id, nom, adresse, idCreateur, actif, dateDebut, heureDebut, dateFin, heureFin)
VALUES(2, 'b','adresse2',1,'2014-10-28','00:00:00','2014-10-29','00:00:00');
INSERT INTO Events(id, nom, adresse, idCreateur, actif, dateDebut, heureDebut, dateFin, heureFin)
VALUES(3, 'c','adresse3',1,'2014-10-28','00:00:00','2014-10-29','00:00:00');

INSERT INTO Participants(idEvent, nom, prenom, societe, mail)
VALUES(1,'nom1','prenom1','societea','a@mail.fr');
INSERT INTO Participants(idEvent, nom, prenom, societe, mail)
VALUES(2,'nom2','prenom2','societeb','a@mail.fr');
INSERT INTO Participants(idEvent, nom, prenom, societe, mail)
VALUES(3,'nom3','prenom3','societed','d@mail.fr');