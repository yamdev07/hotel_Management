/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Entities.Users;
import Views.Users.Usersviews;
import Models.EntitiesManagers.UsersManagers;
import java.util.ArrayList;
import javax.jws.soap.SOAPBinding.Use;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author KOMLA-EBRI
 */
public class UsersController {

    public static boolean validate(String username, String password) {
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(null, " le nom d'utilisateur ne peux pas etre vide");

        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "le mot de passe ne peut pas etre vide");

        } else {
            return true;
        }

        return false;
    }

    
    // pour convertir les element de type arraylist en modele tabel(tableau dynamique) 
    public static TableModel toTableModel(ArrayList<Users> userList) {
        String[] columns = {" Identifiants", "Nom"};

        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        for (Users user : userList) {
            Object obj[] = {user.getIdUser(), user.getUsername()};
            tableModel.addRow(obj);

        }
        return tableModel;
    }

//transformation des types ArrayListe de UserManager en TableManager
    public static TableModel getAll() {
        return toTableModel(UsersManagers.getAll());

    }

    public static TableModel search(String value) {
        return toTableModel(UsersManagers.search("%" + value + "%"));
    }

    //Controller pour la methode store
    
    public static boolean store(String username, String password) {

        if (validate(username, password)) {
            Users user = UsersManagers.getName(username);
            if (user == null) {
                UsersManagers.store(new Users(username, password));
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "l'utilisateur " + username + " existe déja");
            }

        }

        return false;

    }

    //Controller pour le méthode update
    public static boolean update(int id, String username, String password) {
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "le nom d'utilisateur ne peut pas être  vide");
        } else {
            Users user = UsersManagers.getName(username);
            if (user==null) {
                user = UsersManagers.get(id);
                if (password.equals("")) {
                    password = user.getPassword();
                }
                UsersManagers.update(id, new Users(username, password));
                return true;
            } else {
                  JOptionPane.showMessageDialog(null, "l'utilisateur " + username+" n'existe pas ");
            }

        }
        return false;
    }
    
    public static boolean destroy(int idUser){
        Users user = UsersManagers.get(idUser);
        if ( user == null){
         JOptionPane.showMessageDialog(null, "l'utilisateur ne fait pas partire de la base de donnée");    
        }else{
            if (JOptionPane.showConfirmDialog(null, "voulez-vous suprimez l'utilisateur ?") == 0) {
                UsersManagers.delete(idUser);
                return true;
            }
        }
        return false;
    }
    
    //Controller pour le bouton de connection 
    
    public static boolean login(String username, String password){
        if(validate(username, password)){
            Users user = UsersManagers.getName(username);
            if(user == null){
                JOptionPane.showMessageDialog(null,"l'un de vos champs est incorrect");  
            }else{
              //  new Use();
                
            }
        }
        return false;
    }
    
  
}
