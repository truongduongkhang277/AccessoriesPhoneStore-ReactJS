package com.java.backend.model;

import java.util.Date;

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

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(nullable = false)
	private int order_item_id;

    @Column(nullable = false)
	private int shipping_address_id;

    @Column(nullable = false)
	private int payment_method_id;

    @Column(nullable = false)
	private int user_id;

	@Column(nullable = false)
	private double item_price;

    @Column(nullable = false)
	private double shipping_price;

    @Column(nullable = false)
	private double tax_price;

    @Column(nullable = false)
	private double total_price;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean is_paid;

	@Temporal(TemporalType.DATE)    
	private Date paid_at;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean is_delivered;

    @Temporal(TemporalType.DATE)
	private Date delivered_at;

    public Orders() {}

    public Orders(long id, int order_item_id, int shipping_address_id, int payment_method_id, int user_id, double item_price, double shipping_price, double tax_price, double total_price, boolean is_paid, Date paid_at, boolean is_delivered, Date delivered_at ) {
        super();
        this.id = id;
        this.order_item_id = order_item_id;
        this.shipping_address_id = shipping_address_id;
        this.payment_method_id = payment_method_id;
        this.user_id = user_id;
        this.item_price = item_price;
        this.shipping_price = shipping_price;
        this.tax_price = tax_price;
        this.total_price = total_price;
        this.is_paid = is_paid;
        this.paid_at = paid_at;
        this.is_delivered = is_delivered;
        this.delivered_at = delivered_at;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public int getOrder_item_id(){
        return order_item_id;
    }

    public void setOrder_item_id(int order_item_id){
        this.order_item_id = order_item_id;
    }

    public int getShipping_address_id(){
        return shipping_address_id;
    }

    public void setShipping_address_id(int shipping_address_id){
        this.shipping_address_id = shipping_address_id;
    }

    public int getPayment_method_id(){
        return payment_method_id;
    }

    public void setPayment_method_id(int payment_method_id){
        this.payment_method_id = payment_method_id;
    }

    public int getUser_id(){
        return user_id;
    }

    public void setUser_id(int user_id){
        this.user_id = user_id;
    }

    public double getItem_price(){
        return item_price;
    }

    public void setItem_price(double item_price){
        this.item_price = item_price;
    }

    public double getShipping_price(){
        return shipping_price;
    }

    public void setShipping_price(double shipping_price){
        this.shipping_price = shipping_price;
    }
    public double getTax_price(){
        return tax_price;
    }

    public void setTax_price(double tax_price){
        this.tax_price = tax_price;
    }
    public double getTotal_price(){
        return total_price;
    }

    public void setTotal_price(double total_price){
        this.total_price = total_price;
    }

    public boolean getIs_paid(){
        return is_paid;
    }

    public void setIs_paid(boolean is_paid){
        this.is_paid = is_paid;
    }

    public Date getPaid_at(){
        return paid_at;
    }

    public void setPaid_at(Date paid_at){
        this.paid_at = paid_at;
    }

    public boolean getIs_delivered(){
        return is_delivered;
    }

    public void setIs_delivered(boolean is_delivered){
        this.is_delivered = is_delivered;
    }

    public Date getDelivered_at(){
        return delivered_at;
    }

    public void setDelivered_at(Date delivered_at){
        this.delivered_at = delivered_at;
    }
}
