/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Yoga
 */
public class Adhesion {

    private Club club;
    private Etudiant etudiant;
    private Date dateAdhesion;

    public Adhesion(Club club, Etudiant etudiant, Date dateAdhesion) {
        this.club = club;
        this.etudiant = etudiant;
        this.dateAdhesion = dateAdhesion;
    }

    public Club getClub() {
        return club;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Date getDateAdhesion() {
        return dateAdhesion;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public void setDateAdhesion(Date dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    

}
