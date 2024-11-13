package com.backend.ecommerce.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="products",schema = "ecommerce",uniqueConstraints = {
        @UniqueConstraint(
                name="productname",
                columnNames = "ProductName"
        )
})
public class Products{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long Id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="category_id")
    private Long category_id;

    @Column(name="price")
    private double price;

    @Column(name="stock_quantity")
    private Long stock_quantity;

    @Column(name="sku")
    private long sku;

    @Column(name="status")
    private int status;

    @CreatedDate
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

}
