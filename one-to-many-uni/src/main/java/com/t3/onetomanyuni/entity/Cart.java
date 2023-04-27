package com.t3.onetomanyuni.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="shopping_carts")
@Getter @Setter @NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    private String color;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Set<Product> cartProducts = new HashSet<>();

    public void add(Product product){
        if (product != null){
            if(cartProducts == null){
                cartProducts = new HashSet<>();
            }
            cartProducts.add(product);
        }
    }

    @Override
    public String toString() {
        return "Cart [id=" + id + ", color=" + color + "]";
    }

}
