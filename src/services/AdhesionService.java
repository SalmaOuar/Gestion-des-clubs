/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.Connexion;
import dao.IDao;
import beans.Adhesion;
import beans.Club;
import beans.Etudiant;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Yoga
 */
public class AdhesionService implements IDao<Adhesion> {

    private Connexion connexion;
    private ClubService clubService;
    private EtudiantService etudiantService;

    public AdhesionService() {
        connexion = Connexion.getInstance();
        clubService = new ClubService();
        etudiantService = new EtudiantService();
    }

    @Override
    public boolean create(Adhesion o) {
        String req = "INSERT INTO Adhesion (club_id, etudiant_id, date_adhesion) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getClub().getId());
            ps.setInt(2, o.getEtudiant().getId());
            ps.setDate(3, new Date(o.getDateAdhesion().getTime()));
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'ajout de l'adhésion : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Adhesion o) {
        String req = "DELETE FROM Adhesion WHERE club_id = ? AND etudiant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getClub().getId());
            ps.setInt(2, o.getEtudiant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression de l'adhésion : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Adhesion o) {
        String req = "UPDATE Adhesion SET date_adhesion = ? WHERE club_id = ? AND etudiant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setDate(1, new Date(o.getDateAdhesion().getTime()));
            ps.setInt(2, o.getClub().getId());
            ps.setInt(3, o.getEtudiant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour de l'adhésion : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public Adhesion findById(int id) {
        return null;
    }

    @Override
    public List<Adhesion> findAll() {
        List<Adhesion> adhesions = new ArrayList<>();
        String req = "SELECT * FROM Adhesion";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Club club = clubService.findById(rs.getInt("club_id"));
                Etudiant etudiant = etudiantService.findById(rs.getInt("etudiant_id"));
                adhesions.add(new Adhesion(club, etudiant, rs.getDate("date_adhesion")));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des adhésions : " + ex.getMessage());
        }
        return adhesions;
    }

}
