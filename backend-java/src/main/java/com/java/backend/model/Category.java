package com.java.backend.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "category")
public class Category {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(name="name", length = 100, nullable = false, columnDefinition = "nvarchar(255) not null")
	private String name;

    // khi xóa cate, prod thuộc cate cũng được xóa theo
    //@JsonIgnore
    //@OneToMany(targetEntity = Product.class, mappedBy = "category", cascade = CascadeType.ALL)
	//private Set<Product> products;

    public Category() {}

    public Category(long id, String name) {
        super();
        this.id = id;
        this.name = name;
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

    //public Set<Product> getProduct() {
    //    return this.products;
    //}
}
