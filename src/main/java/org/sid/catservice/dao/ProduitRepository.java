package org.sid.catservice.dao;

import org.sid.catservice.entities.Category;
import org.sid.catservice.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
//@CrossOrigin(origins = "*")
@CrossOrigin(value = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.PATCH} )
@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    @RestResource(path="/ByDesignation")
    public List<Produit> findByDesignationContains(@Param("des") String des);
    @RestResource(path="/ByDesignationPage")
    public Page<Produit> findByDesignationContains(@Param("des") String des, Pageable pageable);
    //http://localhost:8080/produits/search/ByDesignationPage?des=playstation&page=0&size=5
    //mvn install

    @Query("select p from  Produit p where p.designation like :x")
    public Page<Produit> Search(@Param("x") String mc, Pageable pageable);



    @RestResource(path="/addcategory")
    @Query(value = "INSERT INTO Produit (id,designation,price,quantite,category) VALUES(?1,?2,?3,?4,?5) " +
            "RETURNING id", nativeQuery = true)
    public List<Category> findCategoriesByProduitsOrderById(@Param("des") String des);


}
