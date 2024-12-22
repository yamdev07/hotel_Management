/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.EntitiesManagers;

import Models.Entities.Purshases;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author KOMLA-EBRI
 */
public class PurshasesManagers extends Manager {
    
    
    
    //-1 methode qui permet de recevoir les information d'un utilisateur en fonction de son id
    public static Purshases get(int id) {
        Purshases purshases = null;
        try {
            String request = "SELECT* FROM Purshases WHERE id = " + id + ";";
            statement = Manager.connection.createStatement();
            resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
            purshases = new Purshases(resultSet.getInt("id"), resultSet.getString("article_id"), resultSet.getString("customer_id"), resultSet.getString("quantity"), resultSet.getString("paid"));
            };

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return purshases;

    }
    
    
    //-2 methode qui permet de recevoir les information d'un utilisateur
    public static Purshases getName(String article_id) {

        Purshases purshases = null;
        try {
            String request = "SELECT * FROM Purshases WHERE article_id = " + article_id + ";";
            statement = Manager.connection.createStatement();
            resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                purshases = new Purshases(resultSet.getInt("id"), resultSet.getString("article_id"), resultSet.getString("customer_id"), resultSet.getString("quantity"), resultSet.getString("paid"));
            };

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return purshases;
    }
    
    //-3 methode qui permet de rechercher un utilisateur dans la base de donnée
    public static ArrayList<Purshases> search(String value) {
        ArrayList<Purshases> userList = new ArrayList<Purshases>();
        try {
            String request = "SELECT * FROM Purshases WHERE article_id LIKE ?";
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, value);
            resultSet = preparedStatement.executeQuery();
                   
            while ( resultSet.next()){
            userList.add(new Purshases(resultSet.getInt("id"), resultSet.getString("article_id"), resultSet.getString("customer_id"), resultSet.getString("quantity"), resultSet.getString("paid")));
            }
                       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return userList;
    }
    
    
    //-4 methode qui permet de recevoir la liste de tous les utilisateurs present dans la table
    public static ArrayList<Purshases> getAll(){
        
        ArrayList<Purshases> userList = new ArrayList<Purshases>();
        try{
        String request = "SELECT * FROM Purshases;";
        statement = Manager.connection.createStatement( );
        resultSet = statement.executeQuery(request);
        
        while(resultSet.next()){
            userList.add(new Purshases(resultSet.getInt("id"), resultSet.getString("article_id"), resultSet.getString("customer_id"), resultSet.getString("quantity"), resultSet.getString("paid")));
        }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());}
        return userList;
    } 
    
    

    
    //-5 methode qui permet d'inserer un utilisateur
    public static void store(Purshases user) {
        try {
            String request = "INSERT INTO Purshases(article_id,customer_id,quantity,paid) VALUE(?,?,?,?);";
            // on utilise preparedStatement pour eviter que l'utilisateur ne modifie la base de donnee
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, user.getIdarticle());
            preparedStatement.setString(2, user.getIdcustomer()); 
            preparedStatement.setString(3, user.getQuantity());
            preparedStatement.setString(4, user.getPaid());

            preparedStatement.executeUpdate();
            // fermé la conn

            closeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
    //-6 methode qui permet de modifier un utilisateur
    public static void update(int id, Purshases user) {

        try {
            String request = "UPDATE Purshases SET name=?,password=? WHERE id = ?;";
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, user.getIdarticle());
            preparedStatement.setString(2, user.getIdcustomer()); 
            preparedStatement.setString(3, user.getQuantity());
            preparedStatement.setString(4, user.getPaid());
            
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
            closeQuery();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    //-7 methode qui permet de supprimer un utilisateur
    public static void delete(int id) {
        try {
            String query = "DELETE FROM `Purshases` WHERE id = " + id + "";
            statement = Manager.connection.createStatement();
            statement.executeUpdate(query);
            closeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
