/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Entities.Purshases;
import Views.Purshases.Purshasesviews;
import Models.EntitiesManagers.PurshasesManagers;
import java.util.ArrayList;
import javax.jws.soap.SOAPBinding.Use;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author KOMLA-EBRI
 */
public class PurshasesController {

    public static boolean validate(String idarticle, String idcustomer, String quantity, String paid) {
        if (idarticle.isEmpty()) {
            JOptionPane.showMessageDialog(null, " l'identifiant article ne peux pas etre vide");

        } else if (idcustomer.isEmpty()) {
            JOptionPane.showMessageDialog(null, "l'identifiant client ne peut pas etre vide");
            
        } else if (quantity.isEmpty()) {
            JOptionPane.showMessageDialog(null, "la quantité article ne peut pas etre vide");
            
        } else if (paid.isEmpty()) {
            JOptionPane.showMessageDialog(null, "le payement ne peut pas etre vide");    

        } else {
            return true;
        }

        return false;
    }

    
    // pour convertir les element de type arraylist en modele tabel(tableau dynamique) 
    public static TableModel toTableModel(ArrayList<Purshases> userList) {
        String[] columns = {"Identifiant"," Id Article ", " Id Client", "quantité", "payement"};

        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        for (Purshases user : userList) {
            Object obj[] = {user.getId(), user.getIdarticle(), user.getIdcustomer(), user.getQuantity(), user.getPaid()};
            tableModel.addRow(obj);

        }
        return tableModel;
    }

//transformation des types ArrayListe de UserManager en TableManager
    public static TableModel getAll() {
        return toTableModel(PurshasesManagers.getAll());

    }

    public static TableModel search(String value) {
        return toTableModel(PurshasesManagers.search("%" + value + "%"));
    }

    //Controller pour la methode store
    
    public static boolean store(String idarticle, String idcustomer, String quantity, String paid) {

        if (validate(idarticle, idcustomer, quantity, paid)) {
            Purshases user = PurshasesManagers.getName(idarticle);
            if (user == null) {
                PurshasesManagers.store(new Purshases(idarticle, idcustomer, quantity, paid));
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "l'achat " + idarticle + " existe déja");
            }

        }

        return false;

    }

    //Controller pour le méthode update
    public static boolean update(int id, String idarticle, String idcustomer, String quantity, String paid) {
        if (idarticle.isEmpty()) {
            JOptionPane.showMessageDialog(null, "l'identifiant ne peut pas être  vide");
        } else {
            Purshases user = PurshasesManagers.getName(idarticle);
            if (user==null) {
                user = PurshasesManagers.get(id);
                
                PurshasesManagers.update(id, new Purshases(idarticle, idcustomer, quantity, paid));
                return true;
            } else {
                  JOptionPane.showMessageDialog(null, "l'article " + idarticle+" n'existe pas ");
            }

        }
        return false;
    }
    
    public static boolean destroy(int id){
        Purshases user = PurshasesManagers.get(id);
        if ( user == null){
         JOptionPane.showMessageDialog(null, "Cette achat ne figure pas dans la base de donnée");    
        }else{
            if (JOptionPane.showConfirmDialog(null, "voulez-vous suprimez cette achat ?") == 0) {
                PurshasesManagers.delete(id);
                return true;
            }
        }
        return false;
    }
    
    //Controller pour le bouton de connection 
    
  
}
