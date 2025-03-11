# Gestion des Clubs Étudiants

Ce projet est une application de gestion des clubs étudiants. Elle permet de gérer les clubs, les étudiants et leurs adhésions. L'application est développée en Java avec une base de données MySQL pour la persistance des données. L'interface graphique est construite avec Swing.

## Fonctionnalités

- **Créer un club** : Permet de créer un nouveau club avec un nom, une description et une date de création.
- **Gérer les adhésions** : Permet d'ajouter des adhésions pour les étudiants aux clubs existants.
- **Filtrer les membres par club** : Permet de lister les étudiants inscrits dans un club donné.
- **Rechercher un club par nom** : Permet de rechercher un club en utilisant son nom.

## Structure de la Base de Données

La base de données MySQL est composée des tables suivantes :

### Tables

- **Club** : Contient les informations sur les clubs.
- **Étudiant** : Contient les informations sur les étudiants.
- **Adhésion** : Contient les informations sur les adhésions des étudiants aux clubs.

### Schéma de la Base de Données

```sql
CREATE TABLE Club (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    description TEXT,
    date_creation DATE NOT NULL
);

CREATE TABLE Étudiant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prénom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE Adhésion (
    CREATE TABLE Adhésion (
    club_id INT NOT NULL,
    etudiant_id INT NOT NULL,
    date_adhesion DATE NOT NULL,
    PRIMARY KEY (club_id, etudiant_id),
    FOREIGN KEY (club_id) REFERENCES Club(id) ON DELETE CASCADE,
    FOREIGN KEY (etudiant_id) REFERENCES Étudiant(id) ON DELETE CASCADE

);
