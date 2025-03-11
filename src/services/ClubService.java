/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.IDao;
import beans.Club;
import database.Connexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yoga
 */
public class ClubService implements IDao<Club> {

    private Connexion connexion;

    public ClubService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Club o) {
        String req = "INSERT INTO Club (nom, description, date_creation) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getDescription());
            ps.setDate(3, new Date(o.getDateCreation().getTime()));
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'ajout du club : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Club o) {
        String req = "DELETE FROM Club WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression du club : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Club o) {
        String req = "UPDATE Club SET nom = ?, description = ?, date_creation = ? WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getDescription());
            ps.setDate(3, new Date(o.getDateCreation().getTime()));
            ps.setInt(4, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour du club : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public Club findById(int id) {
        String req = "SELECT * FROM Club WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Club(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getDate("date_creation"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la recherche du club : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Club> findAll() {
        List<Club> clubs = new ArrayList<>();
        String req = "SELECT * FROM Club";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clubs.add(new Club(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getDate("date_creation")));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des clubs : " + ex.getMessage());
        }
        return clubs;
    }

}
