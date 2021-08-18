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
@Table(name = "user")
public class User {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(columnDefinition = "nvarchar(200) not null")
	private String name;

    @Column(columnDefinition = "nvarchar(200) not null")
	private String email;

    @Column(columnDefinition = "nvarchar(255) not null")
	private String password;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean is_admin;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean is_seller;

    public User(){}

    public User(long id, String name, String email, String password, boolean is_admin, boolean is_seller){
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
        this.is_seller = is_seller;
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

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public boolean getIs_admin(){
        return is_admin;
    }

    public void setIs_admin(boolean is_admin){
        this.is_admin = is_admin;
    }

    public boolean getIs_seller(){
        return is_seller;
    }

    public void setIs_seller(boolean is_seller){
        this.is_seller = is_seller;
    }
}
