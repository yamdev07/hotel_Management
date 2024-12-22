/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Entities;

/**
 *
 * @author 22893
 */
public class Reservations {
    
     private int id;
    private String idRoom;
    private String idCustomer;     
    private String entry_date;
    private String exit_date;
    private String paid;

    public Reservations(int id, String idRoom, String idCustomer, String entry_date, String exit_date, String paid) {
        this.id = id;
        this.idRoom = idRoom;
        this.idCustomer = idCustomer;
        this.entry_date = entry_date;
        this.exit_date = exit_date;
        this.paid = paid;
    }

    public Reservations(String idRoom, String idCustomer, String entry_date, String exit_date, String paid) {
        this.idRoom = idRoom;
        this.idCustomer = idCustomer;
        this.entry_date = entry_date;
        this.exit_date = exit_date;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public String getEntry_date() {
        return entry_date;
    }

    public String getExit_date() {
        return exit_date;
    }

    public String getPaid() {
        return paid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }

    public void setExit_date(String exit_date) {
        this.exit_date = exit_date;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    
    
    
    
    
    
}
