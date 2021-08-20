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
@Table(name = "brand")
public class Brand {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(name="name", length = 100, nullable = false, columnDefinition = "nvarchar(255) not null")
	private String name;
    
    // khi xóa brand, prod thuộc brand cũng được xóa theo
    // @JsonIgnore
    // @OneToMany(targetEntity = Product.class, mappedBy = "brand", cascade = CascadeType.ALL)
	// private Set<Product> products;

    public Brand() {}

    public Brand(long id, String name) {
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
    
    // public Set<Product> getProduct() {
    //     return this.products;
    // }

}
