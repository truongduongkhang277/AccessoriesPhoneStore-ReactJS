package com.java.backend.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product")
public class Product {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(columnDefinition = "nvarchar(200) not null")
	private String name;

    @Column(nullable = false)
	private double cost;

    @Column(nullable = false)
	private double price;

    @Column(columnDefinition = "nvarchar(255) not null")
	private String image;

    @Column(nullable = false)
	private int count_in_stock;

    @Column(nullable = false)
	private double rating;

    @Column(nullable = false)
	private int num_reviews;

    @Column(columnDefinition = "nvarchar(255) not null")
	private String description;

    @Column(nullable = false)
	private int brand_id;

    @Column(nullable = false)
	private int category_id;

    public Product() {}

    public Product(long id, String name, double cost, double price, String image, int count_in_stock, double rating, int num_reviews, String description, int brand_id, int category_id ) {
        super();
        this.id = id;
        this.name = name;
        this.cost = cost;
        this. price = price;
        this.image = image;
        this.count_in_stock = count_in_stock;
        this.rating = rating;
        this.num_reviews = num_reviews;
        this.description = description;
        this.brand_id = brand_id;
        this.category_id = category_id;
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

    public double getCost(){
        return cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }
    
    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }

    public int getCount_in_stock(){
        return count_in_stock;
    }

    public void setCount_in_stock(int count_in_stock){
        this.count_in_stock = count_in_stock;
    }

    public double getRating(){
        return rating;
    }

    public void setRating(double rating){
        this.rating = rating;
    }
    public int getNum_reviews(){
        return num_reviews;
    }

    public void setNum_reviews(int num_reviews){
        this.num_reviews = num_reviews;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getBrand_id(){
        return brand_id;
    }

    public void setBrand_id(int brand_id){
        this.brand_id = brand_id;
    }

    public int getCategory_id(){
        return category_id;
    }

    public void setCategory_id(int category_id){
        this.category_id = category_id;
    }
    
}
