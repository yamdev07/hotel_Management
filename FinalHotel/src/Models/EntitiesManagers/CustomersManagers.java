/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.EntitiesManagers;

import Models.Entities.Customers;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author KOMLA-EBRI
 */
public class CustomersManagers extends Manager {
    
    
    
    //-1 methode qui permet de recevoir les information d'un utilisateur en fonction de son id
    
    public static Customers get(int id) {
        Customers customers = null;
        try {
            String request = "SELECT* FROM Customers WHERE id = " + id + ";";
            statement = Manager.connection.createStatement();
            resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
            customers = new Customers(resultSet.getInt("id"), resultSet.getString("last_name"), resultSet.getString("first_name"), resultSet.getString("phone_number"), resultSet.getString("country"), resultSet.getString("customer_type"), resultSet.getString("fideletycard"));
            };

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return customers;

    }
    
    
    //-2 methode qui permet de recevoir les information d'un utilisateur
    
    public static Customers getName(String last_name) {

        Customers customers = null;
        try {
            String request = "SELECT * FROM Customers WHERE last_name = " + last_name + ";";
            statement = Manager.connection.createStatement();
            resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                customers = new Customers(resultSet.getInt("id"), resultSet.getString("last_name"), resultSet.getString("first_name"), resultSet.getString("phone_number"), resultSet.getString("country"), resultSet.getString("customer_type"), resultSet.getString("fideletycard"));
            };

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return customers;
    }
    
    //-3 methode qui permet de rechercher un utilisateur dans la base de donnée
    public static ArrayList<Customers> search(String value) {
        ArrayList<Customers> customersList = new ArrayList<Customers>();
        try {
            String request = "SELECT * FROM Customers WHERE last_name LIKE ?";
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, value);
            resultSet = preparedStatement.executeQuery();
                   
            while ( resultSet.next()){
            customersList.add(new Customers(resultSet.getInt("id"), resultSet.getString("last_name"), resultSet.getString("first_name"), resultSet.getString("phone_number"), resultSet.getString("country"), resultSet.getString("customer_type"), resultSet.getString("fideletycard")));
            }
                       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return customersList;
    }
    
    
    //-4 methode qui permet de recevoir la liste de tous les utilisateurs present dans la table
    public static ArrayList<Customers> getAll(){
        
        ArrayList<Customers> customersList = new ArrayList<Customers>();
        try{
        String request = "SELECT * FROM Customers;";
        statement = Manager.connection.createStatement( );
        resultSet = statement.executeQuery(request);
        
        while(resultSet.next()){
            customersList.add(new Customers(resultSet.getInt("id"), resultSet.getString("last_name"), resultSet.getString("first_name"), resultSet.getString("phone_number"), resultSet.getString("country"), resultSet.getString("customer_type"), resultSet.getString("fideletycard")));
        }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());}
        return customersList;
    } 
    
    

    
    //-5 methode qui permet d'inserer un utilisateur
    public static void store(Customers customers) {
        try {
            String request = "INSERT INTO Customers(last_name, first_name, phone_number, country, customer_type, fideletycard) VALUE(?,?,?,?,?,?);";
            // on utilise preparedStatement pour eviter que l'utilisateur ne modifie la base de donnee
            
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, customers.getLastName());
            preparedStatement.setString(2, customers.getFirstName());
            preparedStatement.setString(3, customers.getPhoneNumbers());
            preparedStatement.setString(4, customers.getCountry());
            preparedStatement.setString(5, customers.getCustomerType());
            preparedStatement.setString(6, customers.getFideletycard());
            

            preparedStatement.executeUpdate();
            // fermé la conn

            closeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
    //-6 methode qui permet de modifier un utilisateur
    
    public static void update(int idCustomer, Customers customers) {

        try {
            String request = "UPDATE Customers SET last_name=?, first_name=?, phone_number=?, country=?, customer_type=?, fideletycard=? WHERE id = ?;";
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, customers.getLastName());
            preparedStatement.setString(2, customers.getFirstName());
            preparedStatement.setString(3, customers.getPhoneNumbers());
            preparedStatement.setString(4, customers.getCountry());
            preparedStatement.setString(5, customers.getCustomerType());
            preparedStatement.setString(6, customers.getFideletycard());
            preparedStatement.setInt(7, idCustomer);

            preparedStatement.executeUpdate();
            closeQuery();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    //-7 methode qui permet de supprimer un utilisateur
    public static void delete(int id) {
        try {
            String query = "DELETE FROM `Customers` WHERE id = " + id + "";
            statement = Manager.connection.createStatement();
            statement.executeUpdate(query);
            closeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
