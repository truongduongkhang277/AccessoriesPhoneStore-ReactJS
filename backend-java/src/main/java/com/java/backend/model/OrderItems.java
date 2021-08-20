package com.java.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItems {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(columnDefinition = "nvarchar(255) not null")
	private String name;

    @Column(nullable = false)
	private int quantity;

    // @Column(length = 255)
	// private String image;

	// @Column(nullable = false)
	// private double price;

	// @Column(nullable = false)
	// private int product_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderItems() {}

    public OrderItems(long id, String name, int quantity, Product product) {
        super();
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        //this.image = image;
        //this.price = price;
        this.product = product;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    // public String getImage(){
    //     return image;
    // }

    // public void setImage(String image){
    //     this.image = image;
    // }

    // public double getPrice(){
    //     return price;
    // }

    // public void setPrice(double price){
    //     this.price = price;
    // }

    // public int getProduct_id(){
    //     return product_id;
    // }

    // public void setProduct_id(int product_id){
    //     this.product_id = product_id;
    // }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
