package com.hulkstore.hulkstore.controller;

import com.hulkstore.hulkstore.mapping.CatalogProduct;
import com.hulkstore.hulkstore.model.Product;
import com.hulkstore.hulkstore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.OPTIONS,RequestMethod.GET,
        RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping ("/api/product")
public class ProductApiController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    @ResponseBody
    private ResponseEntity<Product> saveProduct (@RequestBody Product product){
        Product productCreate = productService.create(product);

        try {
            return ResponseEntity.created(new URI("/api/hulkstore/save"+productCreate.getIdProduct())).body(productCreate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @GetMapping("/listall")
    private ResponseEntity<List<Product>> getAllProducts (){
        List<Product> productListAll = productService.getAllProducts();
        try {
            return ResponseEntity.ok(productListAll);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @DeleteMapping("/delete/{id}")
    private ResponseEntity deleteProduct (@PathVariable Long id){
        productService.deleteById(id);
        try {
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @GetMapping(name="/getbyid/{id}", value = "{id}")
    private ResponseEntity<Optional<Product>> findById (@PathVariable Long id){
        Optional<Product> productResponse = productService.getById(id);
        try {
            return ResponseEntity.ok(productResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @PostMapping("/update")
    @ResponseBody
    private ResponseEntity<Product> updateProduct (@RequestBody Product product){
        Product productCreate = productService.create(product);

        try {
            return ResponseEntity.created(new URI("/api/hulkstore/save"+productCreate.getIdProduct())).body(productCreate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @GetMapping("/catalog")
    private ResponseEntity<List<CatalogProduct>> catalogProduct (){
        List<CatalogProduct> productListAll = productService.getCatalogProducts();
        try {
            return ResponseEntity.ok(productListAll);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @GetMapping("/catalogAll")
    private ResponseEntity<List<CatalogProduct>> catalogAllProduct (){
        List<CatalogProduct> productListAll = productService.getCatalogProductsAll();
        try {
            return ResponseEntity.ok(productListAll);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };
}
