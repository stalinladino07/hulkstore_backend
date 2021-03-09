package com.hulkstore.hulkstore.repository;

import com.hulkstore.hulkstore.mapping.CatalogProduct;
import com.hulkstore.hulkstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT idProduct, code, name FROM product", nativeQuery = true)
    List<CatalogProduct> getCatalogProductsAll();

    @Query(value = "SELECT idProduct, code, name FROM product WHERE product.idproduct NOT IN (SELECT idproduct FROM stock)", nativeQuery = true)
    List<CatalogProduct> getCatalogProducts();
}
