package com.whiteStudio.Ecommerce_Platform_Spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.whiteStudio.Ecommerce_Platform_Spring.PK.OrderItemPk;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();
    private Integer quantity;
    private Double price;

    public OrderItem(Order order, Product product, Double price, Integer quantity) {
        id.setOrder(order);
        id.setProduct(product);
        this.price = price;
        this.quantity = quantity;
    }
    // para que o subtotal apareça no json, o que vale pro Java é o get, então, não podemos deixar subTotal, mas sim, getSubTotal, para que fique visivel no json.
    public Double getSubTotal() { return this.price * this.quantity; }

    public OrderItem() {}

    @JsonIgnore
    public Order getOrder() {return id.getOrder();}

    public Product getProduct() {return id.getProduct();}

    public void setOrder(Order order) {id.setOrder(order);}

    public void setProduct(Product product) {id.setProduct(product);}

    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public Double getPrice() {return price;}

    public void setPrice(Double price) { this.price = price;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
