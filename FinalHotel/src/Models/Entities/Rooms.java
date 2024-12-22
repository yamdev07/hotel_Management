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
public class Rooms {
    
     public int id;
    public String number;
    public String cleaningStatus;     
    public String roomType; 
    public String caractéristique;
    public String situation;
    public String  price;

    public Rooms(int id, String number, String cleaningStatus, String roomType, String caractéristique, String situation, String price) {
        this.id = id;
        this.number = number;
        this.cleaningStatus = cleaningStatus;
        this.roomType = roomType;
        this.caractéristique = caractéristique;
        this.situation = situation;
        this.price = price;
    }

    public Rooms(String number, String cleaningStatus, String roomType, String caractéristique, String situation, String price) {
        this.number = number;
        this.cleaningStatus = cleaningStatus;
        this.roomType = roomType;
        this.caractéristique = caractéristique;
        this.situation = situation;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getCleaningStatus() {
        return cleaningStatus;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getCaractéristique() {
        return caractéristique;
    }

    public String getSituation() {
        return situation;
    }

    public String getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCleaningStatus(String cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setCaractéristique(String caractéristique) {
        this.caractéristique = caractéristique;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    
    
    
    
    
    
}
