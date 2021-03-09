package com.hulkstore.hulkstore.services;

import com.hulkstore.hulkstore.mapping.CatalogProduct;
import com.hulkstore.hulkstore.model.Product;
import com.hulkstore.hulkstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product create (Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "idProduct"));
    }

    public void delete (Product product) {
         productRepository.delete(product);
    }

    public Optional<Product> getById (Long id) {
        return productRepository.findById(id);
    }

    public List<CatalogProduct> getCatalogProducts() {
     return productRepository.getCatalogProducts();
    }

    public List<CatalogProduct> getCatalogProductsAll() {
        return productRepository.getCatalogProductsAll();
    }

    public void deleteById (Long id) {
        productRepository.deleteById(id);
    }

}
