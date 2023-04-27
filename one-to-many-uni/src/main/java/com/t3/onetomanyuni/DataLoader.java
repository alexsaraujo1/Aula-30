package com.t3.onetomanyuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.t3.onetomanyuni.entity.Cart;
import com.t3.onetomanyuni.entity.Product;
import com.t3.onetomanyuni.repository.CartRepository;
import com.t3.onetomanyuni.repository.ProductRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        createCart();
        retrieveCart(1L);
    }

              //Criamos o método

    public void createCart() {

        // Criamos um carrinho
        Cart cart1 = new Cart();
        cart1.setColor("Verde");

        // Criamos o produto 1
        Product product1 = new Product();
        product1.setName("Leite");
        product1.setPrice(5);
        product1.setQuantity(12);

        // Adicionamos o product1 no cart1
        cart1.add(product1);

        // Criamos o produto 2
        Product product2 = new Product();
        product2.setName("Arroz");
        product2.setPrice(12);
        product2.setQuantity(1);

        // Adicionamos o product2 no cart1
        cart1.add(product2);

        // Criamos o produto 3
        Product product3 = new Product();
        product3.setName("Feijão");
        product3.setPrice(6);
        product3.setQuantity(2);

        // Adicionamos o product3 no cart1
        cart1.add(product3);

        //Salvamos no nosso banco
        cartRepository.save(cart1);

    }

    public void retrieveCart(Long id){
        Cart cart = cartRepository.findById(id).get();
        
        //Imprime o carrinho retornado
        System.out.println("Print Cart info: ");
        System.out.println(cart.toString());

        //Imprime cada um dos produtos do carrinho
        System.out.println("Print Products info: ");
        cart.getCartProducts().forEach((product -> {
            System.out.println(product.toString());
        }));
    }

}
