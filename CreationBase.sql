DROP TABLE Rencontres;
DROP TABLE Users;
DROP TABLE Events;
CREATE TABLE Users(
 id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
 mail varchar(255) NOT NULL,
 passwd varchar(100) NOT NULL,
 nom varchar(100) NOT NULL,
 prenom varchar(100) NOT NULL,
 societe varchar(255) NOT NULL,
 PRIMARY KEY (id)
);
CREATE TABLE Events(
 id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
 url varchar(255) NOT NULL,
 nom varchar(255) NOT NULL,
 idCreateur INTEGER NOT NULL,
 FOREIGN KEY(idCreateur) REFERENCES Users(id),
 PRIMARY KEY (id)
);
CREATE TABLE Rencontres(
 idParticipants INTEGER NOT NULL,
 idEvent INTEGER NOT NULL,
 FOREIGN KEY (idParticipants) REFERENCES Users(id),
 FOREIGN KEY (idEvent) REFERENCES Events(id),
 PRIMARY KEY (idEvent)
);