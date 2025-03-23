# Gestion des Clubs Étudiants

## 1. Contexte
Les clubs étudiants jouent un rôle crucial dans le développement académique et personnel des étudiants. Ils permettent aux étudiants de s’engager dans des activités extrascolaires, de développer leurs compétences et d’élargir leur réseau social. Cependant, la gestion manuelle des clubs entraîne des problèmes tels que la perte d’informations, la difficulté à suivre les adhésions et un manque de centralisation des données.

## 2. Problématique
L'absence d’un système informatisé pour la gestion des clubs entraîne des inefficacités organisationnelles. Les responsables des clubs ont du mal à suivre les inscriptions, les adhésions et les activités des membres. De plus, l’absence de rapports et de statistiques sur l’adhésion des étudiants complique la prise de décision.

## 3. Objectif
L'objectif du projet est de développer une application de gestion des clubs étudiants qui facilite l'administration des clubs, l'enregistrement des adhésions et l'affichage des membres de chaque club. L’application permettra aussi la visualisation graphique des statistiques à l’aide de JFreeChart.

## 4. Diagramme Use Case
Le diagramme ci-dessous montre les principaux cas d'utilisation de l'application :
![Image](https://github.com/user-attachments/assets/cf4c26b7-6ac5-43a3-b1b7-7ad5c16721b9)

## 5. Diagramme de Classe
![Image](https://github.com/user-attachments/assets/7a2f3fbf-bc9a-4331-992d-271d3acbd530)

## 6. Script Base de Données
```sql
CREATE TABLE Club (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL UNIQUE,
    description TEXT,
    date_creation DATE NOT NULL
);

CREATE TABLE Etudiant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE Adhesion (
    club_id INT NOT NULL,
    etudiant_id INT NOT NULL,
    date_adhesion DATE NOT NULL,
    PRIMARY KEY (club_id, etudiant_id),
    FOREIGN KEY (club_id) REFERENCES Club(id) ON DELETE CASCADE,
    FOREIGN KEY (etudiant_id) REFERENCES Etudiant(id) ON DELETE CASCADE
);

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    login VARCHAR(100) NOT NULL UNIQUE,
    password TEXT NOT NULL,
    salt TEXT NOT NULL,
    question_secrete TEXT,
    reponse_secrete VARCHAR(100),
    verification_code VARCHAR(10)
);
```


## 7. Technologies Utilisées
![Image](https://github.com/user-attachments/assets/8b331c37-d66c-4ccd-8c0f-50fe89ab0502)


## 8. Aechitecture 
![Image](https://github.com/user-attachments/assets/7fbd1842-1bb1-40c8-a9f8-ff61a8443c06)

## 9. Vidéo de démonstration 
https://github.com/user-attachments/assets/36c734b9-34d2-4cb7-b619-f3c2c20e077e
