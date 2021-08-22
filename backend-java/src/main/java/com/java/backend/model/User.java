package com.java.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @Column(name = "is_admin", nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean isAdmin;

    @Column(name = "is_seller", nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean isSeller;

    public User(){}

    public User(long id, String name, String email, String password, boolean isAdmin, boolean isSeller){
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isSeller = isSeller;
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

    public boolean getIsAdmin(){
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;
    }

    public boolean getIsSeller(){
        return isSeller;
    }

    public void setIsSeller(boolean isSeller){
        this.isSeller = isSeller;
    }
}
