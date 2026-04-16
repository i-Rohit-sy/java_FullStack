package com.example.SimpleWebApp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Product {
    @Id
    private int prodId;

    public Product(){

    }

    public Product(int price, String prodName,int prodId) {
        this.price = price;
        this.prodName = prodName;
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    private String prodName;
    private int price;

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", price=" + price +
                '}';
    }
}
