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

        clubService.create(club1);
        clubService.create(club2);

        if (club1 == null || club2 == null) {
            System.out.println("Un des clubs n'existe pas dans la base de données !");
            return;
        }

        Club club = clubService.findById(3);
        if (club != null) {
            System.out.println("Club trouvé : " + club.getNom());
        }
        club.setDescription("Nouvelles technologies et IA");
        clubService.update(club);
        System.out.println("Description du club mise à jour : " + clubService.findById(3).getDescription());

        List<Club> clubs = clubService.findAll();
        System.out.println("Liste des clubs :");
        for (Club c : clubs) {
            System.out.println("ID: " + c.getId() + " - Nom: " + c.getNom() + " - Description: " + c.getDescription());
        }

        Etudiant etudiant1 = new Etudiant(1, "Salma", "Ouarrar", "SalmaOuarrar@gmail.com");
        Etudiant etudiant2 = new Etudiant(2, "Israa", "Mountassir", "Israa22@gmail.com");

        if (etudiant1 == null || etudiant2 == null) {
            System.out.println("Un des étudiants n'existe pas dans la base de données !");
            return;
        }

        if (etudiantService.findByEmail("SalmaOuarrar@gmail.com") == null) {
            etudiantService.create(etudiant1);
        }
        if (etudiantService.findByEmail("Israa22@gmail.com") == null) {
            etudiantService.create(etudiant2);
        }

        Etudiant etudiant = etudiantService.findById(1);
        if (etudiant != null) {
            etudiant.setPrenom("Doha");
            etudiantService.update(etudiant);
            System.out.println("Prénom de l'étudiant mis à jour : " + etudiantService.findById(1).getPrenom());
        } else {
            System.out.println("Aucun étudiant trouvé avec l'ID 1 !");
        }

        List<Etudiant> etudiants = etudiantService.findAll();
        System.out.println("Liste des étudiants :");
        for (Etudiant e : etudiants) {
            System.out.println("ID: " + e.getId() + " - Nom: " + e.getNom() + " - Prénom: " + e.getPrenom() + " - Email: " + e.getEmail());
        }

        clubService.delete(club1);
        System.out.println("Club supprimé, nouvelle liste des clubs :");
        for (Club c : clubService.findAll()) {
            System.out.println("ID: " + c.getId() + " - Nom: " + c.getNom());
        }

        etudiantService.delete(etudiant1);
        System.out.println("Étudiant supprimé, nouvelle liste des étudiants :");
        for (Etudiant e : etudiantService.findAll()) {
            System.out.println("ID: " + e.getId() + " - Nom: " + e.getNom());
        }

        Adhesion adhesion1 = new Adhesion(club1, etudiant1, new Date());
        Adhesion adhesion2 = new Adhesion(club2, etudiant2, new Date());

        //adhesionService.create(adhesion1);
        //adhesionService.create(adhesion2);
        
        if (adhesionService.findById(club1.getId(), etudiant1.getId()) == null) {
            adhesionService.create(new Adhesion(club1, etudiant1, new Date()));
        } else {
            System.out.println("L'adhésion entre " + club1.getNom() + " et " + etudiant1.getNom() + " existe déjà !");
        }

        if (adhesionService.findById(club2.getId(), etudiant2.getId()) == null) {
            adhesionService.create(new Adhesion(club2, etudiant2, new Date()));
        } else {
            System.out.println("L'adhésion entre " + club2.getNom() + " et " + etudiant2.getNom() + " existe déjà !");
        }

        List<Adhesion> adhesions = adhesionService.findAll();
        System.out.println("Liste des adhésions :");
        for (Adhesion a : adhesions) {
            System.out.println("Club: " + a.getClub().getNom() + " - Étudiant: " + a.getEtudiant().getNom() + " " + a.getEtudiant().getPrenom());
        }

        Adhesion adhesionRecherchee = adhesionService.findById(club1.getId(), etudiant1.getId());
        if (adhesionRecherchee != null) {
            System.out.println("Adhésion trouvée : Club " + adhesionRecherchee.getClub().getNom()
                    + " - Étudiant " + adhesionRecherchee.getEtudiant().getNom());
        }

        adhesion1.setDateAdhesion(new Date());
        adhesionService.update(adhesion1);
        System.out.println("Date d'adhésion mise à jour : " + adhesionService.findById(club1.getId(), etudiant1.getId()).getDateAdhesion());

        Adhesion adhesionSupprime = adhesionService.findAll().get(1);
        adhesionService.delete(adhesionSupprime);
        System.out.println("\nAdhésion supprimée : Club " + adhesionSupprime.getClub().getNom()
                + " - Étudiant " + adhesionSupprime.getEtudiant().getNom() + " " + adhesionSupprime.getEtudiant().getPrenom());

        System.out.println("\nListe des adhésions restantes :");
        for (Adhesion a : adhesionService.findAll()) {
            System.out.println("Club: " + a.getClub().getNom() + " - Étudiant: " + a.getEtudiant().getNom() + " " + a.getEtudiant().getPrenom());
        }

    }
}
