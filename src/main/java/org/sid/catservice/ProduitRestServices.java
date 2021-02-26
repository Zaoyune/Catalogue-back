package org.sid.catservice;

import org.sid.catservice.dao.CategoryRepository;
import org.sid.catservice.dao.ProduitRepository;
import org.sid.catservice.entities.Category;
import org.sid.catservice.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE} )
@RestController
public class ProduitRestServices {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/SPro",method = RequestMethod.GET)
    public Page<Produit> Find(@RequestParam(name = "mc",defaultValue = "") String mc,
                              @RequestParam(name = "page",defaultValue = "0")int page,
                              @RequestParam(name = "size",defaultValue = "5")int size){

        return produitRepository.Search("%"+mc+"%", PageRequest.of(page,size))
                ;}

    @GetMapping(value="/ListProduitss")
    public List<Produit> listProduits(){
        return produitRepository.findAll();
    }


    @GetMapping(value="/ListProduits/{id}")
    public Produit listProduits(@PathVariable(name="id") Long id){
        return produitRepository.findById(id).get();
    }


    @PutMapping(value="/ListProduits/{id}")
    public Produit update(@PathVariable(name="id") Long id,@RequestBody Produit p){
        p.setId(id);
        return produitRepository.save(p);
    }


    @PostMapping(value="/AddPr")
    public Produit save(@RequestBody Produit p){
        return produitRepository.save(p);
    }

    @GetMapping(value="/ListCategories")
    public List<Category> listCategories(){
        return categoryRepository.findAll();
    }



    @DeleteMapping(value="/listProduits/{id}")
    public void delete(@PathVariable(name="id") Long id){

        produitRepository.deleteById(id);
    }


}
