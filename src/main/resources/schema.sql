CREATE TABLE Motoreier (
    id INTEGER AUTO_INCREMENT NOT NULL,
    persNr VARCHAR(11) NOT NULL,
    navn VARCHAR (255) NOT NULL,
    adresse VARCHAR(255) NOT NULL,
    kjennetegn VARCHAR(255) NOT NULL,
    bilmerke VARCHAR(255) NOT NULL,
    biltype VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE Bil (
    merke VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    PRIMARY KEY (type)
);
CREATE TABLE Brukere (
    brukernavn VARCHAR(25) NOT NULL,
    passord VARCHAR(255) NOT NULL,
    PRIMARY KEY (brukernavn)
);