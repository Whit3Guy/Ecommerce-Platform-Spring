package com.whiteStudio.Ecommerce_Platform_Spring.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.whiteStudio.Ecommerce_Platform_Spring.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "order_table")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // formatador de horário pra mostrar que o horário é o UTC
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order(){}

    public Order(Long id, Instant moment, User client, OrderStatus orderStatus) {
        this.orderStatus = orderStatus.getCode();
        this.moment = moment;
        this.id = id;
        this.client = client;
    }

    public Double getTotal()
    {
        double temp = 0;
        for(OrderItem x: this.items)
        {
            temp += x.getSubTotal();
        }
        return temp;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    public Payment getPayment() { return payment; }

    public void setPayment(Payment payment) { this.payment = payment; }

    public void setOrderStatus(Integer orderStatus) { this.orderStatus = orderStatus; }

    public Set<OrderItem> getItems() {return this.items;}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Instant getMoment() {return moment;}

    public void setMoment(Instant moment) {this.moment = moment;}

    public OrderStatus getOrderStatus() {return OrderStatus.valueOf(1);}

    public void setOrderStatus(OrderStatus orderStatus) {this.orderStatus = orderStatus.getCode();}

    public User getClient() {return client;}

    public void setClient(User client) {this.client = client;}
}
