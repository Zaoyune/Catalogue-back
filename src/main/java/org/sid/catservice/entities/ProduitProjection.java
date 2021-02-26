package org.sid.catservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "P1",types = Produit.class)
public interface ProduitProjection {
    public Long getId();
    public String  getDesignation();
    public double getPrice();
    public int getQuantite();
    public Category getCategory();
    //http://localhost:8080/produits?projection=P1
}
