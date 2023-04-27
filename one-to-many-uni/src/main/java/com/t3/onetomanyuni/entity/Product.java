package com.t3.onetomanyuni.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="products")
@Getter @Setter @NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int price;

    private int quantity;

    @Override
    public String toString() {
        return 
        "Product [id=" + id + 
        ", name=" + name + 
        ", price=" + price + 
        ", quantity=" + quantity + 
        "]";
        
    }

    
    
}