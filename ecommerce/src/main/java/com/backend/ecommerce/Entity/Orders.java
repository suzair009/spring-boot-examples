package com.backend.ecommerce.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="order_id",nullable = false)
    private double orderid;

    @Column(name="customer_id")
    private String customerId;

    @Column(name="status")
    private int status;

    @Column(name="total_amount")
    private double totalamount;

    @Column(name="discount")
    private double discount;

    @Column(name="final_amount")
    private double finalamount;

    @Column(name="created_date")
    @CreatedDate
    private LocalDateTime dateCreated;

    @Column(name="billing_address")
    private String billingAddress;

    @Column(name="shipping_address")
    private String shippingAddress;


}
