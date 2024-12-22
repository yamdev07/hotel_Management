/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Entities.Reservations;
import Views.Reservations.Reservationsviews;
import Models.EntitiesManagers.ReservationsManagers;
import java.util.ArrayList;
import javax.jws.soap.SOAPBinding.Use;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author KOMLA-EBRI
 */
public class ReservationsController {

    public static boolean validate(String idRoom, String idCustomer, String entry_date, String exit_date, String paid) {
        if (idRoom.isEmpty()) {
            JOptionPane.showMessageDialog(null, "l'identifiant chambre ne peut pas etre vide");

        } else if (idCustomer.isEmpty()) {
            JOptionPane.showMessageDialog(null, "l'identifiant client ne peut pas etre vide");

        } else if (entry_date.isEmpty()) {
            JOptionPane.showMessageDialog(null, "la date d'entrer ne peut pas etre vide");

        /*} else if (entry_time.isEmpty()) {
            JOptionPane.showMessageDialog(null, "l'heure d'entrer ne peut pas etre vide");*/

        } else if (exit_date.isEmpty()) {
            JOptionPane.showMessageDialog(null, "la date de sortie ne peut pas etre vide");

        /*} else if (exit_time.isEmpty()) {
            JOptionPane.showMessageDialog(null, "l'heure de sortie ne peut pas etre vide");*/

        } else if (paid.isEmpty()) {
            JOptionPane.showMessageDialog(null, "le paiement ne peut pas etre vide");

        } else {
            return true;
        }

        return false;
    }

    // pour convertir les element de type arraylist en modele tabel(tableau dynamique) 
    public static TableModel toTableModel(ArrayList<Reservations> reservationsList) {
        String[] columns = {"Id_Réservation", "Id_Room", "Id_Customer", "entry_date", "exit_date", "paid"};

        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        for (Reservations reservations : reservationsList) {
            Object obj[] = {reservations.getId(), reservations.getIdRoom(), reservations.getIdCustomer(), reservations.getEntry_date(), reservations.getExit_date(), reservations.getPaid()};
            tableModel.addRow(obj);

        }
        return tableModel;
    }

//transformation des types ArrayListe de UserManager en TableManager
    public static TableModel getAll() {
        return toTableModel(ReservationsManagers.getAll());

    }

    public static TableModel search(String value) {
        return toTableModel(ReservationsManagers.search("%" + value + "%"));
    }

    //Controller pour la methode store
    public static boolean store(String idRoom, String idCustomer, String entry_date, String exit_date, String paid) {

        if (validate(idRoom, idCustomer, entry_date, exit_date, paid)) {
            Reservations reservations = ReservationsManagers.getName(idRoom);
            if (reservations == null) {
                ReservationsManagers.store(new Reservations(idRoom, idCustomer, entry_date, exit_date, paid));
                return true;
                } else {
                JOptionPane.showMessageDialog(null, "La chambre " + idRoom + " est déjà prise");
            }

        }

        return false;

    }

    //Controller pour le méthode update
    public static boolean update(int id, String idRoom, String idCustomer, String entry_date, String exit_date, String paid) {
        if (idRoom.isEmpty()) {
            JOptionPane.showMessageDialog(null, "l'identiant chambre ne peut pas être vide");
            
        }else if (idCustomer.isEmpty()) {
            JOptionPane.showMessageDialog(null, "l'identifiant client ne peut pas être vide");
            
        } else {
            Reservations reservations = ReservationsManagers.getName(idRoom);
            if (reservations == null) {
                reservations = ReservationsManagers.get(id);

                ReservationsManagers.update(id, new Reservations(idRoom, idCustomer, entry_date, exit_date, paid));
                return true;

            } else {
                JOptionPane.showMessageDialog(null, "Une réservation porte déjà sur la chambre " + idRoom + " ");
            }

        }
        return false;
    }

    public static boolean destroy(int id) {
        Reservations reservations = ReservationsManagers.get(id);
        if (reservations == null) {
            JOptionPane.showMessageDialog(null, "la réservation ne fait pas partire de la base de donnée");
        } else {
            if (JOptionPane.showConfirmDialog(null, "voulez-vous suprimez le client ?") == 0) {
                ReservationsManagers.delete(id);
                return true;
            }
        }
        return false;
    }

}
