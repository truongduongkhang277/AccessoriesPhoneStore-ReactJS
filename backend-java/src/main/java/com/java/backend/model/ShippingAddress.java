package com.java.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shipping_address")
public class ShippingAddress {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(columnDefinition = "nvarchar(200) not null")
	private String fullname;

    @Column(columnDefinition = "nvarchar(200) not null")
	private String address;

    @Column(columnDefinition = "nvarchar(255) not null")
	private String city;

    @Column(columnDefinition = "nvarchar(200) not null")
	private String country;

    @Column(columnDefinition = "nvarchar(10) not null")
	private String postal_code;

    public ShippingAddress(){}

    public ShippingAddress(long id, String fullname, String address, String city, String country, String postal_code){
        super();
        this.id = id;
        this.fullname = fullname;
        this.address = address;
        this.city = city;
        this.country = country;
        this.postal_code = postal_code;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getFullname(){
        return fullname;
    }

    public void setFullname(String fullname){
        this.fullname = fullname;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }
    
    public String getPostal_code(){
        return postal_code;
    }

    public void setPostal_code(String postal_code){
        this.postal_code = postal_code;
    }
}
