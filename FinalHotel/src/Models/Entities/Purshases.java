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
public class Purshases {
    
     private int id;
    private String idarticle;
    private String idcustomer;     
    private String quantity;       
    private String paid;

    public Purshases(int id, String idarticle, String idcustomer, String quantity, String paid) {
        this.id = id;
        this.idarticle = idarticle;
        this.idcustomer = idcustomer;
        this.quantity = quantity;
        this.paid = paid;
    }

    public Purshases(String idarticle, String idcustomer, String quantity, String paid) {
        this.idarticle = idarticle;
        this.idcustomer = idcustomer;
        this.quantity = quantity;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public String getIdarticle() {
        return idarticle;
    }

    public String getIdcustomer() {
        return idcustomer;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPaid() {
        return paid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdarticle(String idarticle) {
        this.idarticle = idarticle;
    }

    public void setIdcustomer(String idcustomer) {
        this.idcustomer = idcustomer;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    
    
    
    
    
    
    
}
