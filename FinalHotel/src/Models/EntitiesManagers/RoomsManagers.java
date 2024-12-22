/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.EntitiesManagers;

import Models.Entities.Rooms;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author KOMLA-EBRI
 */
public class RoomsManagers extends Manager {
    
    
    
    //-1 methode qui permet de recevoir les information d'un utilisateur en fonction de son id
    public static Rooms get(int id) {
        Rooms rooms = null;
        try {
            String request = "SELECT* FROM Rooms WHERE id = " + id + ";";
            statement = Manager.connection.createStatement();
            resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
            rooms = new Rooms(resultSet.getInt("id"), resultSet.getString("number"), resultSet.getString("cleaning_status"),  resultSet.getString("type"),  resultSet.getString("caractéristique"),  resultSet.getString("situation"), resultSet.getString("price"));
            };

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return rooms;

    }
    
    
    //-2 methode qui permet de recevoir les information d'un utilisateur
    public static Rooms getName(String number) {

        Rooms rooms = null;
        try {
            String request = "SELECT * FROM Rooms WHERE number = " + number + ";";
            statement = Manager.connection.createStatement();
            resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                rooms = new Rooms(resultSet.getInt("id"), resultSet.getString("number"), resultSet.getString("cleaning_status"),  resultSet.getString("type"),  resultSet.getString("caractéristique"),  resultSet.getString("situation"), resultSet.getString("price"));
            };

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return rooms;
    }
    
    //-3 methode qui permet de rechercher un utilisateur dans la base de donnée
    public static ArrayList<Rooms> search(String value) {
        ArrayList<Rooms> roomsList = new ArrayList<Rooms>();
        try {
            String request = "SELECT * FROM Rooms WHERE number LIKE ?";
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, value);
            resultSet = preparedStatement.executeQuery();
                   
            while ( resultSet.next()){
            roomsList.add(new Rooms(resultSet.getInt("id"), resultSet.getString("number"), resultSet.getString("cleaning_status"),  resultSet.getString("type"),  resultSet.getString("caractéristique"),  resultSet.getString("situation"), resultSet.getString("price")));
            }
                       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return roomsList;
    }
    
    
    //-4 methode qui permet de recevoir la liste de tous les utilisateurs present dans la table
    public static ArrayList<Rooms> getAll(){
        
        ArrayList<Rooms> roomsList = new ArrayList<Rooms>();
        try{
        String request = "SELECT * FROM Rooms;";
        statement = Manager.connection.createStatement( );
        resultSet = statement.executeQuery(request);
        
        while(resultSet.next()){
            roomsList.add(new Rooms(resultSet.getInt("id"), resultSet.getString("number"), resultSet.getString("cleaning_status"),  resultSet.getString("type"),  resultSet.getString("caractéristique"),  resultSet.getString("situation"), resultSet.getString("price")));
        }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());}
        return roomsList;
    } 
    
    

    
    //-5 methode qui permet d'inserer un utilisateur
    public static void store(Rooms rooms) {
        try {
            String request = "INSERT INTO Rooms(number,cleaning_status,type,caractéristique,situation,price) VALUE(?,?,?,?,?,?);";
            // on utilise preparedStatement pour eviter que l'utilisateur ne modifie la base de donnee
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, rooms.getNumber());
            preparedStatement.setString(2, rooms.getCleaningStatus());
            preparedStatement.setString(3, rooms.getRoomType());
            preparedStatement.setString(4, rooms.getCaractéristique());
            preparedStatement.setString(5, rooms.getSituation());
            preparedStatement.setString(6, rooms.getPrice());

            preparedStatement.executeUpdate();
            // fermé la conn

            closeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
    //-6 methode qui permet de modifier un utilisateur
    
    public static void update(int id, Rooms rooms) {

        try {
            String request = "UPDATE Rooms SET number=?,cleaning_status=?,type=?,caractéristique=?,situation=?,price=? WHERE id = ?;";
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, rooms.getNumber());
            preparedStatement.setString(2, rooms.getCleaningStatus());
            preparedStatement.setString(3, rooms.getRoomType());
            preparedStatement.setString(4, rooms.getCaractéristique());
            preparedStatement.setString(5, rooms.getSituation());
            preparedStatement.setString(6, rooms.getPrice());
            
            preparedStatement.setInt(7, id);

            preparedStatement.executeUpdate();
            closeQuery();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    //-7 methode qui permet de supprimer un utilisateur
    public static void delete(int id) {
        try {
            String query = "DELETE FROM `Rooms` WHERE id = " + id + "";
            statement = Manager.connection.createStatement();
            statement.executeUpdate(query);
            closeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
