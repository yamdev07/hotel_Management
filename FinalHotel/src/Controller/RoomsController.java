/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Entities.Rooms;
import Views.Rooms.Roomsviews;
import Models.EntitiesManagers.RoomsManagers;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author KOMLA-EBRI
 */
public class RoomsController {

    public static boolean validate(String number, String cleaningStatus, String roomType, String caractéristique, String situation, String price) {
        if (number.isEmpty()) {
            JOptionPane.showMessageDialog(null, " le numéro chambre ne peux pas etre vide");

        } else if (cleaningStatus.isEmpty()) {
            JOptionPane.showMessageDialog(null, "le statut ne peut pas etre vide");

        } else if (roomType.isEmpty()) {
            JOptionPane.showMessageDialog(null, "le type de chambre ne peut pas etre vide");

        } else if (caractéristique.isEmpty()) {
            JOptionPane.showMessageDialog(null, "la caractéristique chambre ne peut pas etre vide");

        } else if (situation.isEmpty()) {
            JOptionPane.showMessageDialog(null, "la situation chambre ne peut pas etre vide");

        } else if (price.isEmpty()) {
            JOptionPane.showMessageDialog(null, "le prix ne peut pas etre vide");

        } else {
            return true;
        }

        return false;
    }

    // pour convertir les element de type arraylist en modele tabel(tableau dynamique) 
    public static TableModel toTableModel(ArrayList<Rooms> roomsList) {
        String[] columns = {"Id", "Num", "Statut", "Type", "Caractéristique", "Situation", "Prix"};

        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        for (Rooms rooms : roomsList) {
            Object obj[] = {rooms.getId(), rooms.getNumber(), rooms.getCleaningStatus(), rooms.getRoomType(), rooms.getCaractéristique(), rooms.getSituation(), rooms.getPrice()};
            tableModel.addRow(obj);

        }
        return tableModel;
    }

//transformation des types ArrayListe de UserManager en TableManager
    public static TableModel getAll() {
        return toTableModel(RoomsManagers.getAll());

    }

    public static TableModel search(String value) {
        return toTableModel(RoomsManagers.search("%" + value + "%"));
    }

    //Controller pour la methode store
    public static boolean store(String number, String cleaningStatus, String roomType, String caractéristique, String situation, String price) {

        if (validate(number, cleaningStatus, roomType, caractéristique, situation, price)) {
            Rooms rooms = RoomsManagers.getName(number);
            if (rooms == null) {
                RoomsManagers.store(new Rooms(number, cleaningStatus, roomType, caractéristique, situation, price));
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "la chambre " + number + " n'existe déja");
            }

        }

        return false;

    }

    //Controller pour le méthode update
    public static boolean update(int id, String number, String cleaningStatus, String roomType, String caractéristique, String situation, String price) {
        if (number.isEmpty()) {
            JOptionPane.showMessageDialog(null, "le numéro chambre ne peut pas être  vide");
        } else {
            Rooms rooms = RoomsManagers.getName(number);
            if (rooms == null) {
                rooms = RoomsManagers.get(id);

                RoomsManagers.update(id, new Rooms(number, cleaningStatus, roomType, caractéristique, situation, price));
                return true;

            } else {
                JOptionPane.showMessageDialog(null, "La chambre " + number + " n'existe pas ");
            }

        }
        return false;
    }

    public static boolean destroy(int id) {
        Rooms rooms = RoomsManagers.get(id);
        if (rooms == null) {
            JOptionPane.showMessageDialog(null, "cette chambre ne fait pas partire de la base de donnée");
        } else {
            if (JOptionPane.showConfirmDialog(null, "voulez-vous suprimez cette chambre ?") == 0) {
                RoomsManagers.delete(id);
                return true;
            }
        }
        return false;
    }

}
