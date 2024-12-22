/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.EntitiesManagers;

import Models.Entities.Reservations;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author KOMLA-EBRI
 */
public class ReservationsManagers extends Manager {
    
    
    
    //-1 methode qui permet de recevoir les information d'un utilisateur en fonction de son id
    public static Reservations get(int id) {
        Reservations reservation = null;
        try {
            String request = "SELECT* FROM Reservations WHERE id = " + id + ";";
            statement = Manager.connection.createStatement();
            resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
            reservation = new Reservations(resultSet.getInt("id"), resultSet.getString("room_id"), resultSet.getString("customer_id"), resultSet.getString("entry_date"), resultSet.getString("exit_date"), resultSet.getString("paid"));
            };

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return reservation;

    }
    
    
    //-2 methode qui permet de recevoir les information d'un utilisateur
    public static Reservations getName(String paid) {

        Reservations reservation = null;
        try {
            String request = "SELECT * FROM Reservations WHERE paid = " + paid + ";";
            statement = Manager.connection.createStatement();
            resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                reservation = new Reservations(resultSet.getInt("id"), resultSet.getString("room_id"), resultSet.getString("customer_id"), resultSet.getString("entry_date"), resultSet.getString("exit_date"), resultSet.getString("paid"));
            };

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return reservation;
    }
    
    //-3 methode qui permet de rechercher un utilisateur dans la base de donnée
    public static ArrayList<Reservations> search(String value) {
        ArrayList<Reservations> reservationList = new ArrayList<Reservations>();
        try {
            String request = "SELECT * FROM Reservations WHERE paid LIKE ?";
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, value);
            resultSet = preparedStatement.executeQuery();
                   
            while ( resultSet.next()){
            reservationList.add(new Reservations(resultSet.getInt("id"), resultSet.getString("room_id"), resultSet.getString("customer_id"), resultSet.getString("entry_date"), resultSet.getString("exit_date"), resultSet.getString("paid")));
            }
                       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return reservationList;
    }
    
    
    //-4 methode qui permet de recevoir la liste de tous les utilisateurs present dans la table
    public static ArrayList<Reservations> getAll(){
        
        ArrayList<Reservations> reservationList = new ArrayList<Reservations>();
        try{
        String request = "SELECT * FROM Reservations;";
        statement = Manager.connection.createStatement( );
        resultSet = statement.executeQuery(request);
        
        while(resultSet.next()){
            reservationList.add(new Reservations(resultSet.getInt("id"), resultSet.getString("room_id"), resultSet.getString("customer_id"), resultSet.getString("entry_date"), resultSet.getString("exit_date"), resultSet.getString("paid")));
        }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());}
        return reservationList;
    } 
    
    

    
    //-5 methode qui permet d'inserer un utilisateur
    public static void store(Reservations reservation) {
        try {
            String request = "INSERT INTO Reservations(room_id,customer_id,entry_date,exit_date,paid) VALUE(?,?,?,?,?);";
            // on utilise preparedStatement pour eviter que l'utilisateur ne modifie la base de donnee
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, reservation.getIdRoom());
            preparedStatement.setString(2, reservation.getIdCustomer()); 
            preparedStatement.setString(3, reservation.getEntry_date());
            //preparedStatement.setString(4, reservation.getEntry_time());
            preparedStatement.setString(4, reservation.getExit_date());
            //preparedStatement.setString(6, reservation.getExit_time());
            preparedStatement.setString(5, reservation.getPaid());
             
            preparedStatement.executeUpdate();
            // fermé la conn

            closeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
    //-6 methode qui permet de modifier un utilisateur
    public static void update(int id, Reservations reservations) {

        try {
            String request = "UPDATE Reservations SET room_id=?,customer_id=?,entry_date=?,exit_date=?,paid=? WHERE id = ?;";
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, reservations.getIdRoom());
            preparedStatement.setString(2, reservations.getIdCustomer());
            preparedStatement.setString(3, reservations.getEntry_date());
            //preparedStatement.setString(4, reservations.getEntry_time());
            preparedStatement.setString(4, reservations.getExit_date());
            //preparedStatement.setString(6, reservations.getExit_time());
            preparedStatement.setString(5, reservations.getPaid());
            
            
            
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();
            closeQuery();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    //-7 methode qui permet de supprimer un utilisateur
    public static void delete(int id) {
        try {
            String query = "DELETE FROM `Reservations` WHERE id = " + id + "";
            statement = Manager.connection.createStatement();
            statement.executeUpdate(query);
            closeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
