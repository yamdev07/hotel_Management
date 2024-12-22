/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.EntitiesManagers;

import Models.Entities.Users;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author KOMLA-EBRI
 */
public class UsersManagers extends Manager {
    
    
    
    //-1 methode qui permet de recevoir les information d'un utilisateur en fonction de son id
    public static Users get(int id) {
        Users user = null;
        try {
            String request = "SELECT* FROM Users WHERE id = " + id + ";";
            statement = Manager.connection.createStatement();
            resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
            user = new Users(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("password"));
            };

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return user;

    }
    
    
    //-2 methode qui permet de recevoir les information d'un utilisateur
    public static Users getName(String username) {

        Users user = null;
        try {
            String request = "SELECT* FROM Users WHERE name = " + username + ";";
            statement = Manager.connection.createStatement();
            resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                user = new Users(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("password"));
            };

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return user;
    }
    
    //-3 methode qui permet de rechercher un utilisateur dans la base de donnée
    public static ArrayList<Users> search(String value) {
        ArrayList<Users> userList = new ArrayList<Users>();
        try {
            String request = "SELECT * FROM Users WHERE name LIKE ?";
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, value);
            resultSet = preparedStatement.executeQuery();
                   
            while ( resultSet.next()){
            userList.add(new Users(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("password")));
            }
                       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return userList;
    }
    
    
    //-4 methode qui permet de recevoir la liste de tous les utilisateurs present dans la table
    public static ArrayList<Users> getAll(){
        
        ArrayList<Users> userList = new ArrayList<Users>();
        try{
        String request = "SELECT * FROM Users;";
        statement = Manager.connection.createStatement( );
        resultSet = statement.executeQuery(request);
        
        while(resultSet.next()){
            userList.add(new Users(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("password")));
        }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());}
        return userList;
    } 
    
    

    
    //-5 methode qui permet d'inserer un utilisateur
    public static void store(Users user) {
        try {
            String request = "INSERT INTO Users(name,password) VALUE(?,?);";
            // on utilise preparedStatement pour eviter que l'utilisateur ne modifie la base de donnee
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword()); 

            preparedStatement.executeUpdate();
            // fermé la conn

            closeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
    //-6 methode qui permet de modifier un utilisateur
    public static void update(int idUser, Users user) {

        try {
            String request = "UPDATE Users SET name=?,password=? WHERE id = ?;";
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, idUser);

            preparedStatement.executeUpdate();
            closeQuery();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    //-7 methode qui permet de supprimer un utilisateur
    public static void delete(int id) {
        try {
            String query = "DELETE FROM `Users` WHERE id = " + id + "";
            statement = Manager.connection.createStatement();
            statement.executeUpdate(query);
            closeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
