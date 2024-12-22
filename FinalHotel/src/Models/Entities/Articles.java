/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Entities;

/**
 *
 * @author KOMLA-EBRI
 */
public class Articles {
    private int id;
    private String articleName;
    private String price;

    public Articles(int id, String articleName, String price) {
        this.id = id;
        this.articleName = articleName;
        this.price = price;
    }

    public Articles(String articleName, String price) {
        this.articleName = articleName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getArticleName() {
        return articleName;
    }

    public String getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    
    
    
}
