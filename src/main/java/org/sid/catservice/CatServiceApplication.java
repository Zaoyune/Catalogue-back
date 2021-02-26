package org.sid.catservice;

import net.bytebuddy.utility.RandomString;
import org.sid.catservice.dao.CategoryRepository;
import org.sid.catservice.dao.ProduitRepository;
import org.sid.catservice.entities.Category;
import org.sid.catservice.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class CatServiceApplication implements CommandLineRunner {

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;
    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args) {

        SpringApplication.run(CatServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Produit.class);
        restConfiguration.exposeIdsFor(Category.class);

        Category c1 = categoryRepository.save(new Category(null,"Gaming Laptop",null,null));
        Category c2 = categoryRepository.save(new Category(null,"Smart Phones",null,null));
        Category c3 = categoryRepository.save(new Category(null,"Gaming Desktop",null,null));
        Category c4 = categoryRepository.save(new Category(null,"Consoles",null,null));

        produitRepository.save(new Produit(null,"Iphone xr",9000,5,c2));
        produitRepository.save(new Produit(null,"Pc Gamer Asrock",9000,5,c1));
        produitRepository.save(new Produit(null,"MSI A",9000,5,c3));
        produitRepository.save(new Produit(null,"Paystation 5",9000,5,c4));

        /*produitRepository.findAll().forEach(p->{
            System.out.println(p.toString());
        });*/
    }
}
