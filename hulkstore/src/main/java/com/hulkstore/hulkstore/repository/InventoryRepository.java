package com.hulkstore.hulkstore.repository;

import com.hulkstore.hulkstore.model.Inventory;
import com.hulkstore.hulkstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
