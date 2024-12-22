/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Entities.Articles;
import Views.Articles.Articlesviews;
import Models.EntitiesManagers.ArticlesManagers;
import java.util.ArrayList;
import javax.jws.soap.SOAPBinding.Use;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author KOMLA-EBRI
 */
public class ArticlesController {

    public static boolean validate(String articleName, String price) {
        if (articleName.isEmpty()) {
            JOptionPane.showMessageDialog(null, " le nom article ne peux pas etre vide");

        } else if (price.isEmpty()) {
            JOptionPane.showMessageDialog(null, "le prix ne peut pas etre vide");

        } else {
            return true;
        }

        return false;
    }

    
    // pour convertir les element de type arraylist en modele tabel(tableau dynamique) 
    public static TableModel toTableModel(ArrayList<Articles> articlesList) {
        String[] columns = {" Identifiants", "Nom", "Prix"};

        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        for (Articles articles : articlesList) {
            Object obj[] = {articles.getId(), articles.getArticleName(), articles.getPrice()};
            tableModel.addRow(obj);

        }
        return tableModel;
    }

//transformation des types ArrayListe de UserManager en TableManager
    public static TableModel getAll() {
        return toTableModel(ArticlesManagers.getAll());

    }

    public static TableModel search(String value) {
        return toTableModel(ArticlesManagers.search("%" + value + "%"));
    }

    //Controller pour la methode store
    
    public static boolean store(String articleName, String price) {

        if (validate(articleName, price)) {
            Articles articles = ArticlesManagers.getName(articleName);
            if (articles == null) {
                ArticlesManagers.store(new Articles(articleName, price));
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "l'utilisateur " + articleName + " existe déja");
            }

        }

        return false;

    }

    //Controller pour le méthode update
    public static boolean update(int id, String articleName, String price) {
        if (articleName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "le nom article ne peut pas être  vide");
        } else {
            Articles articles = ArticlesManagers.getName(articleName);
            if (articles ==null) {
                articles = ArticlesManagers.get(id);
                
                
                ArticlesManagers.update(id, new Articles(articleName, price));
                return true;
            } else {
                  JOptionPane.showMessageDialog(null, "l'utilisateur" + articleName+ " n'existe pas ");
            }

        }
        return false;
    }
    
    public static boolean destroy(int id){
        Articles articles = ArticlesManagers.get(id);
        if ( articles == null){
         JOptionPane.showMessageDialog(null, "l'article ne fait pas partire de la base de donnée");    
        }else{
            if (JOptionPane.showConfirmDialog(null, "voulez-vous suprimez l'article ?") == 0) {
                ArticlesManagers.delete(id);
                return true;
            }
        }
        return false;
    }
    
    
  
}
