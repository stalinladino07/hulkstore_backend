package com.hulkstore.hulkstore.services;

import com.hulkstore.hulkstore.model.Inventory;
import com.hulkstore.hulkstore.model.Product;
import com.hulkstore.hulkstore.model.Stock;
import com.hulkstore.hulkstore.repository.InventoryRepository;
import com.hulkstore.hulkstore.repository.ProductRepository;
import com.hulkstore.hulkstore.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StockRepository stockRepository;

    public Inventory create (Inventory inventory) {
        Stock respStock = this.stockRepository.getProductById(inventory.getIdProduct());
        Double total = respStock.getAvailable() + inventory.getQuantity();
        Double purchased = respStock.getPurchased() + inventory.getQuantity();
        respStock.setAvailable(total);
        respStock.setPurchased(purchased);
        stockRepository.save(respStock);
        inventory.setStatus(true);
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public void delete (Inventory inventory) {
        inventoryRepository.delete(inventory);
    }

    public void deleteById (Long id) {
        inventoryRepository.deleteById(id);
    }

    public Optional<Inventory> getById (Long id) {
        return inventoryRepository.findById(id);
    }

    public Inventory updateSold (Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

}
