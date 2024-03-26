package com.example.orm;

import com.example.orm.entities.Product;
import com.example.orm.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.List;

@SpringBootApplication
public class OrmApplication  implements CommandLineRunner {

     @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(OrmApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //ajout des produit
        productRepository.save(new Product(0, "Computer", 40000, 5));
        productRepository.save(new Product(0, "mouse", 4, 2));
        productRepository.save(new Product(0, "charger", 23, 1));

        //Consulter tous les produits

        List<Product> products = productRepository.findAll();
        products.forEach(p ->
            System.out.println(p.toString()));
        //consulter un produit par son id

        Product product = productRepository.findById(Long.valueOf(1)).get();
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("********************");

        List<Product> productList=productRepository.findByNameContains("C");
            productList.forEach(p-> System.out.println(p));

        System.out.println("******************++++++++++++++");
        List<Product> productList1=productRepository.search("%C%");
        productList1.forEach(p-> System.out.println(p));



        List<Product> productList3=productRepository.findByPriceGreaterThan(23);
        productList3.forEach(p-> System.out.println(p));


        List<Product> productList2=productRepository.searchByPrice(23);
        productList2.forEach(p-> System.out.println(p));


        //mise à jour  d'un produit

      /*Product productList4 =productRepository.updateProductById(Long.valueOf(8));
        productList4.setQuantity(5000);
        productList4.setName("newProduct");
        productList4.setPrice(600000000);
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());

*/

                //remove product
        List<Product> productList5=productRepository.removeProductById(Long.valueOf(5));





    }}
