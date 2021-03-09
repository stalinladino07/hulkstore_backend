package com.hulkstore.hulkstore.repository;

import com.hulkstore.hulkstore.mapping.CatalogProduct;
import com.hulkstore.hulkstore.model.Product;
import com.hulkstore.hulkstore.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query(value = "SELECT * FROM stock WHERE idProduct=:idProduct ", nativeQuery = true)
    Stock getProductById(Long idProduct);
}
