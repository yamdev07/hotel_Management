/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Entities.Customers;
import Views.Customers.Customersviews;
import Models.EntitiesManagers.CustomersManagers;
import java.util.ArrayList;
import javax.jws.soap.SOAPBinding.Use;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author KOMLA-EBRI
 */
public class CustomersController {

    public static boolean validate( String lastName, String firstName, String phoneNumbers, String country, String customerType, String fideletycard) {
        if (lastName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "le nom client ne peut pas etre vide");

        } else if (firstName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "le prénom client ne peut pas etre vide");
        
        } else if (phoneNumbers.isEmpty()) {
            JOptionPane.showMessageDialog(null, "le numéro de téléphone ne peut pas etre vide");
            
        } else if (country.isEmpty()) {
            JOptionPane.showMessageDialog(null, "le pays ne peut pas etre vide");
            
        } else if (customerType.isEmpty()) {
            JOptionPane.showMessageDialog(null, "le type client ne peut pas etre vide");
            
        } else if (fideletycard.isEmpty()) {
            JOptionPane.showMessageDialog(null, "la carte fidélitée ne peut pas etre vide");                
            
        } else {
            return true;
        }

        return false;
    }

    
    // pour convertir les element de type arraylist en modele tabel(tableau dynamique) 
    public static TableModel toTableModel(ArrayList<Customers> customersList) {
        String[] columns = {" Identifiants", "last_name", "first_name", "phone_number", "country", "customer_type", "fideletycard"};

        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
            for (Customers customers : customersList) {
            Object obj[] = {customers.getIdcustomer(), customers.getLastName(), customers.getFirstName(), customers.getPhoneNumbers(), customers.getCountry(), customers.getCustomerType(), customers.getFideletycard()};
            tableModel.addRow(obj);

        }
        return tableModel;
    }

//transformation des types ArrayListe de UserManager en TableManager
    public static TableModel getAll() {
        return toTableModel(CustomersManagers.getAll());

    }

    public static TableModel search(String value) {
        return toTableModel(CustomersManagers.search("%" + value + "%"));
    }

    //Controller pour la methode store
    
    public static boolean store( String lastName, String firstName, String phoneNumbers, String country, String customerType, String fideletycard) {

        if (validate(lastName, firstName, phoneNumbers, country, customerType, fideletycard)) {
            Customers customers = CustomersManagers.getName(lastName);
            if (customers == null) {
                CustomersManagers.store(new Customers(lastName, firstName, phoneNumbers, country, customerType, fideletycard));
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Le client" + lastName + "existe déja");
            }

        }

        return false;

    }

    //Controller pour le méthode update
    
    
    public static boolean update(int id, String lastName, String firstName, String phoneNumbers, String country, String customerType, String fideletycard) {
        if (lastName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "le nom client ne peut pas être  vide");
        } else {
            Customers customers = CustomersManagers.getName(lastName);
            if (customers == null) {
                customers = CustomersManagers.get(id);
                
                
                 CustomersManagers.update(id, new Customers(lastName, firstName, phoneNumbers, country, customerType, fideletycard));
                 return true;
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Client " + lastName +" n'existe pas ");
            }

        }
        return false;
    }
    
    public static boolean destroy(int idCustomer){
        Customers customers = CustomersManagers.get(idCustomer);
        if ( customers == null){
         JOptionPane.showMessageDialog(null, "le client ne fait pas partire de la base de donnée");    
        }else{
            if (JOptionPane.showConfirmDialog(null, "voulez-vous suprimez le client ?") == 0) {
                CustomersManagers.delete(idCustomer);
                return true;
            }
        }
        return false;
    }
    
    
  
}

