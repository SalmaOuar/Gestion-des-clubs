/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.Adhesion;
import beans.Club;
import beans.Etudiant;
import services.AdhesionService;
import services.ClubService;
import services.EtudiantService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Yoga
 */
public class Test {

    public static void main(String[] args) {

        ClubService clubService = new ClubService();
        EtudiantService etudiantService = new EtudiantService();
        AdhesionService adhesionService = new AdhesionService();

        Club club1 = new Club(1, "Club Informatique", "Développement et programmation", new Date());
        Club club2 = new Club(2, "Club Robotique", "Innovation", new Date());

        System.out.println("Ajout des clubs...");
        clubService.create(club1);
        clubService.create(club2);

        System.out.println("\nListe des clubs :");
        List<Club> clubs = clubService.findAll();
        for (Club c : clubs) {
            System.out.println("ID: " + c.getId() + " - Nom: " + c.getNom() + " - Description: " + c.getDescription());
        }

        Etudiant etudiant1 = new Etudiant(1, "Salma", "Ouarrar", "SalmaOuarrar@gmail.com");
        Etudiant etudiant2 = new Etudiant(2, "Israa", "Mountassir", "Israa22@gmail.com");

        System.out.println("\nAjout des étudiants...");
        etudiantService.create(etudiant1);
        etudiantService.create(etudiant2);

        System.out.println("\nListe des étudiants :");
        List<Etudiant> etudiants = etudiantService.findAll();
        for (Etudiant e : etudiants) {
            System.out.println("ID: " + e.getId() + " - Nom: " + e.getNom() + " - Prénom: " + e.getPrenom() + " - Email: " + e.getEmail());
        }

        Adhesion adhesion1 = new Adhesion(club1, etudiant1, new Date());
        Adhesion adhesion2 = new Adhesion(club2, etudiant2, new Date());

        System.out.println("\nAjout des adhésions...");
        adhesionService.create(adhesion1);
        adhesionService.create(adhesion2);

        System.out.println("\nListe des adhésions :");
        List<Adhesion> adhesions = adhesionService.findAll();
        for (Adhesion a : adhesions) {
            System.out.println("Club: " + a.getClub().getNom() + " - Étudiant: " + a.getEtudiant().getNom() + " " + a.getEtudiant().getPrenom());
        }

        System.out.println("\nMise à jour du Club Informatique...");
        club1.setDescription("Nouvelles technologies et IA");
        clubService.update(club1);

        System.out.println("\nListe des clubs après mise à jour :");
        clubs = clubService.findAll();
        for (Club c : clubs) {
            System.out.println("ID: " + c.getId() + " - Nom: " + c.getNom() + " - Description: " + c.getDescription());
        }

        System.out.println("\nSuppression d'une adhésion...");
        adhesionService.delete(adhesion1);

        System.out.println("\nListe des adhésions après suppression :");
        adhesions = adhesionService.findAll();
        for (Adhesion a : adhesions) {
            System.out.println("Club: " + a.getClub().getNom() + " - Étudiant: " + a.getEtudiant().getNom() + " " + a.getEtudiant().getPrenom());
        }

    }
}
