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

    @Column(name = "count_in_stock", nullable = false)
	private int countInStock;

    @Column(nullable = false)
	private double rating;

    @Column(name = "num_reviews", nullable = false)
	private int numReviews;

    @Column(columnDefinition = "nvarchar(255) not null")
	private String description;

    // @Column(nullable = false)
	// private int brand_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    //  @Column(nullable = false)
	//  private int category_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {}

    public Product(long id, String name, double cost, double price, String image, int countInStock, double rating, int numReviews, String description, Brand brand, Category category ) {
        super();
        this.id = id;
        this.name = name;
        this.cost = cost;
        this. price = price;
        this.image = image;
        this.countInStock = countInStock;
        this.rating = rating;
        this.numReviews = numReviews;
        this.description = description;
        this.brand = brand;
        this.category = category;
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

    public int getCountInStock(){
        return countInStock;
    }

    public void setCountInStock(int countInStock){
        this.countInStock = countInStock;
    }

    public double getRating(){
        return rating;
    }

    public void setRating(double rating){
        this.rating = rating;
    }
    public int getNumReviews(){
        return numReviews;
    }

    public void setNumReviews(int numReviews){
        this.numReviews = numReviews;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    // public int getBrand_id(){
    //     return brand_id;
    // }

    // public void setBrand_id(int brand_id){
    //     this.brand_id = brand_id;
    // }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    // public int getCategory_id(){
    //     return category_id;
    // }

    // public void setCategory_id(int category_id){
    //     this.category_id = category_id;
    // }

    public Category getCategory() {
       return category;
    }

    public void setCategory(Category category) {
       this.category = category;
    }
    
}
