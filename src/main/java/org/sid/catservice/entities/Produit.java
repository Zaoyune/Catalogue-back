package org.sid.catservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Produit implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private double price;
    private int quantite;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    /*
    * {
  "id": 10,
  "designation": "Iphone xr",
  "price": 9000,
  "quantite": 5,
	"category":{
      "ref":{
      "id":"1",
     "name": "Gaming Laptop",
      "description": null

  }
 }
}
    * */
}
