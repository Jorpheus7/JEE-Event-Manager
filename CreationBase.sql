DROP TABLE Participants;
DROP TABLE Events;
DROP TABLE Users;
CREATE TABLE Users(
 id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
 mail varchar(255) NOT NULL,
 passwd varchar(100) NOT NULL,
 PRIMARY KEY (id)
);
CREATE TABLE Events(
 id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
 nom varchar(255) NOT NULL,
 adresse varchar(255) NOT NULL,
 idCreateur INTEGER NOT NULL,
 actif INT NOT NULL,
 dateDebut DATE NOT NULL,
 heureDebut TIME NOT NULL,
 dateFin DATE NOT NULL,
 heureFin TIME NOT NULL,
 FOREIGN KEY(idCreateur) REFERENCES Users(id),
 PRIMARY KEY (id)
);
CREATE TABLE Participants(
 idEvent INTEGER NOT NULL,
 nom varchar(100) NOT NULL,
 prenom varchar(100) NOT NULL,
 societe varchar(255) NOT NULL,
 mail varchar(255) NOT NULL,
 FOREIGN KEY(idEvent) REFERENCES Events(id),
 PRIMARY KEY(idEvent,mail)
);
