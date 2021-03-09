package com.hulkstore.hulkstore.services;

import com.hulkstore.hulkstore.model.Product;
import com.hulkstore.hulkstore.model.Stock;
import com.hulkstore.hulkstore.repository.ProductRepository;
import com.hulkstore.hulkstore.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stock create (Stock stock) {
        return stockRepository.save(stock);
    }

    public List<Stock> getAllStock() {

        return stockRepository.findAll();
    }

    public void delete (Stock stock) {

        stockRepository.delete(stock);
    }

    public Optional<Stock> getById (Long id) {

        return stockRepository.findById(id);
    }

    public void deleteById (Long id) {

        stockRepository.deleteById(id);
    }

    public Stock updateSoldStock (Stock stock) {
        Optional<Stock> lastStock = stockRepository.findById(stock.getIdstock());
        Double totalSold = stock.getAvailable() - stock.getPurchased();
        Double total = stock.getSold() + stock.getPurchased();
        stock.setAvailable(totalSold);
        stock.setSold(total);
        stock.setPurchased(0.0);
        return stockRepository.save(stock);
    }
}
