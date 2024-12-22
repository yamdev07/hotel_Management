/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.EntitiesManagers;

import Models.Entities.Articles;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author KOMLA-EBRI
 */
public class ArticlesManagers extends Manager {
    
    
    
    //-1 methode qui permet de recevoir les information d'un utilisateur en fonction de son id
    
    public static Articles get(int id) {
        Articles articles = null;
        try {
            String request = "SELECT* FROM Articles WHERE id = " + id + ";";
            statement = Manager.connection.createStatement();
            resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
            articles = new Articles(resultSet.getInt("id"), resultSet.getString("article_name"), resultSet.getString("price"));
            };

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return articles;

    }
    
    
    //-2 methode qui permet de recevoir les information d'un utilisateur
    public static Articles getName(String article_name) {

        Articles articles = null;
        try {
            String request = "SELECT * FROM Articles WHERE article_name = " + article_name + ";";
            statement = Manager.connection.createStatement();
            resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                articles = new Articles(resultSet.getInt("id"), resultSet.getString("article_name"), resultSet.getString("price"));
            };

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return articles;
    }
    
    //-3 methode qui permet de rechercher un utilisateur dans la base de donnée
    public static ArrayList<Articles> search(String value) {
        ArrayList<Articles> articlesList = new ArrayList<Articles>();
        try {
            String request = "SELECT * FROM Articles WHERE article_name LIKE ?";
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, value);
            resultSet = preparedStatement.executeQuery();
                   
            while ( resultSet.next()){
            articlesList.add(new Articles(resultSet.getInt("id"), resultSet.getString("article_name"), resultSet.getString("price")));
            }
                       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return articlesList;
    }
    
    
    //-4 methode qui permet de recevoir la liste de tous les utilisateurs present dans la table
    public static ArrayList<Articles> getAll(){
        
        ArrayList<Articles> articlesList = new ArrayList<Articles>();
        try{
        String request = "SELECT * FROM Articles;";
        statement = Manager.connection.createStatement( );
        resultSet = statement.executeQuery(request);
        
        while(resultSet.next()){
            articlesList.add(new Articles(resultSet.getInt("id"), resultSet.getString("article_name"), resultSet.getString("price")));
        }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());}
        return articlesList;
    } 
    
    

    
    //-5 methode qui permet d'inserer un utilisateur
    
    public static void store(Articles articles) {
        try {
            String request = "INSERT INTO Articles(article_name, price) VALUE(?,?);";
            // on utilise preparedStatement pour eviter que l'utilisateur ne modifie la base de donnee
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, articles.getArticleName());
            preparedStatement.setString(2, articles.getPrice()); 

            preparedStatement.executeUpdate();
            // fermé la conn

            closeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
    //-6 methode qui permet de modifier un utilisateur
    public static void update(int id, Articles articles) {

        try {
            String request = "UPDATE Articles SET article_name=?,price=? WHERE id = ?;";
            preparedStatement = Manager.connection.prepareStatement(request);
            preparedStatement.setString(1, articles.getArticleName());
            preparedStatement.setString(2, articles.getPrice());
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
            closeQuery();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    //-7 methode qui permet de supprimer un utilisateur
    public static void delete(int id) {
        try {
            String query = "DELETE FROM `Articles` WHERE id = " + id + "";
            statement = Manager.connection.createStatement();
            statement.executeUpdate(query);
            closeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
