package com.sparta.group3.northwindtask.northwindtask.controllers;

import com.sparta.group3.northwindtask.northwindtask.entities.Product;
import com.sparta.group3.northwindtask.northwindtask.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}/")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        var p = productRepository.findById(id);
        if(p.isPresent()){
            return new ResponseEntity<>(p.get(),HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/productsByName/{name}/")
    public Product getProductById(@PathVariable String name){
        return productRepository.findByProductName(name);
    }

    @PostMapping("/products/new")
    public void addProduct(@RequestBody Product newProduct){
        if(productRepository.findById(newProduct.getId()).isPresent()){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }else productRepository.save(newProduct);
    }

    @PutMapping("/products/update")
    public void updateProduct(@RequestBody Product updateProduct){
        productRepository.save(updateProduct);
    }

    @PatchMapping("/products/patch")
    public ResponseEntity<Product> patchProduct(@RequestBody Product updateProduct){
        var p = productRepository.findById(updateProduct.getId());
        if(p.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Product patchProduct = p.get();
        if(patchProduct != null) {
            if(patchProduct.getId() != null){
                patchProduct.setId(updateProduct.getId());
            }
            if(patchProduct.getProductName() != null){
                patchProduct.setProductName(updateProduct.getProductName());
            }
            if(patchProduct.getQuantityPerUnit() != null){
                patchProduct.setQuantityPerUnit(updateProduct.getQuantityPerUnit());
            }
            if(patchProduct.getUnitPrice() != null){
                patchProduct.setUnitPrice(updateProduct.getUnitPrice());
            }
            if(patchProduct.getUnitsInStock() != null){
                patchProduct.setUnitsInStock(updateProduct.getUnitsInStock());
            }
            if(patchProduct.getUnitsOnOrder() != null){
                patchProduct.setUnitsOnOrder(updateProduct.getUnitsOnOrder());
            }
            if(patchProduct.getReorderLevel() != null){
                patchProduct.setReorderLevel(updateProduct.getReorderLevel());
            }
            if(patchProduct.getDiscontinued() != null){
                patchProduct.setDiscontinued(updateProduct.getDiscontinued());
            }
            productRepository.save(patchProduct);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/products/delete/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id){
        productRepository.delete(productRepository.getReferenceById(id));
    }

}
