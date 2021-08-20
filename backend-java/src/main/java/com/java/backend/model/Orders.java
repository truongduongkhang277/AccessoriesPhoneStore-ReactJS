package com.java.backend.model;

import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "orders")
public class Orders {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    // @Column(nullable = false)
	// private int order_item_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_item_id")
    private OrderItems orderItems;

    // @Column(nullable = false)
	// private int shipping_address_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id")
    private ShippingAddress shippingAddress;

    // @Column(nullable = false)
	// private int payment_method_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    // @Column(nullable = false)
	// private int user_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

	@Column(nullable = false)
	private double itemPrice;

    @Column(nullable = false)
	private double shippingPrice;

    @Column(nullable = false)
	private double taxPrice;

    @Column(nullable = false)
	private double totalPrice;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean isPaid;

	@Temporal(TemporalType.DATE)    
	private Date paidAt;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean isDelivered;

    @Temporal(TemporalType.DATE)
	private Date deliveredAt;

    public Orders() {}

    public Orders(long id, OrderItems orderItems, ShippingAddress shippingAddress, PaymentMethod paymentMethod, User user, double itemPrice, double shippingPrice, double taxPrice, double totalPrice, boolean isPaid, Date paidAt, boolean isDelivered, Date deliveredAt ) {
        super();
        this.id = id;
        this.orderItems = orderItems;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.user = user;
        this.itemPrice = itemPrice;
        this.shippingPrice = shippingPrice;
        this.taxPrice = taxPrice;
        this.totalPrice = totalPrice;
        this.isPaid = isPaid;
        this.paidAt = paidAt;
        this.isDelivered = isDelivered;
        this.deliveredAt = deliveredAt;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    // public int getOrder_item_id(){
    //     return order_item_id;
    // }

    // public void setOrder_item_id(int order_item_id){
    //     this.order_item_id = order_item_id;
    // }

    public OrderItems getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItems orderItems) {
        this.orderItems = orderItems;
    }

    // public int getShipping_address_id(){
    //     return shipping_address_id;
    // }

    // public void setShipping_address_id(int shipping_address_id){
    //     this.shipping_address_id = shipping_address_id;
    // }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    // public int getPayment_method_id(){
    //     return payment_method_id;
    // }

    // public void setPayment_method_id(int payment_method_id){
    //     this.payment_method_id = payment_method_id;
    // }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // public int getUser_id(){
    //     return user_id;
    // }

    // public void setUser_id(int user_id){
    //     this.user_id = user_id;
    // }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getItemPrice(){
        return itemPrice;
    }

    public void setItemPrice(double itemPrice){
        this.itemPrice = itemPrice;
    }

    public double getShippingPrice(){
        return shippingPrice;
    }

    public void setShippingPrice(double shippingPrice){
        this.shippingPrice = shippingPrice;
    }
    public double getTaxPrice(){
        return taxPrice;
    }

    public void setTaxPrice(double taxPrice){
        this.taxPrice = taxPrice;
    }
    public double getTotalPrice(){
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }

    public boolean getIsPaid(){
        return isPaid;
    }

    public void setIsPaid(boolean isPaid){
        this.isPaid = isPaid;
    }

    public Date getPaidAt(){
        return paidAt;
    }

    public void setPaidAt(Date paidAt){
        this.paidAt = paidAt;
    }

    public boolean getIsDelivered(){
        return isDelivered;
    }

    public void setIsDelivered(boolean isDelivered){
        this.isDelivered = isDelivered;
    }

    public Date getDeliveredAt(){
        return deliveredAt;
    }

    public void setDeliveredAt(Date deliveredAt){
        this.deliveredAt = deliveredAt;
    }
}
