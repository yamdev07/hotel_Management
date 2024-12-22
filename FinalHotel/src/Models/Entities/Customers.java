/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Entities;

/**
 *
 * @author KOMLA-EBRI
 */
public class Customers {

    private int idcustomer;
    private String lastName;
    private String firstName;
    private String phoneNumbers;
    private String country;
    private String customerType;     
    private String fideletycard;

    public Customers(int idcustomer, String lastName, String firstName, String phoneNumbers, String country, String customerType, String fideletycard) {
        this.idcustomer = idcustomer;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumbers = phoneNumbers;
        this.country = country;
        this.customerType = customerType;
        this.fideletycard = fideletycard;
    }

    public Customers(String lastName, String firstName, String phoneNumbers, String country, String customerType, String fideletycard) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumbers = phoneNumbers;
        this.country = country;
        this.customerType = customerType;
        this.fideletycard = fideletycard;
    }

    public int getIdcustomer() {
        return idcustomer;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getCountry() {
        return country;
    }

    public String getCustomerType() {
        return customerType;
    }

    public String getFideletycard() {
        return fideletycard;
    }

    public void setIdcustomer(int idcustomer) {
        this.idcustomer = idcustomer;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public void setFideletycard(String fideletycard) {
        this.fideletycard = fideletycard;
    }

    

            
            
}
