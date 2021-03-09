package com.hulkstore.hulkstore.controller;

import com.hulkstore.hulkstore.model.Inventory;
import com.hulkstore.hulkstore.model.Product;
import com.hulkstore.hulkstore.model.Stock;
import com.hulkstore.hulkstore.services.ProductService;
import com.hulkstore.hulkstore.services.StockService;
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
@RequestMapping ("/api/stock")
public class StockApiController {

    @Autowired
    private StockService stockService;

    @PostMapping("/save")
    @ResponseBody
    private ResponseEntity<Stock> saveStock (@RequestBody Stock stock){
        Stock stockCreate = stockService.create(stock);

        try {
            return ResponseEntity.created(new URI("/api/stock/save"+stockCreate.getIdstock())).body(stockCreate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @GetMapping("/listall")
    private ResponseEntity<List<Stock>> listAllStock (){
        List<Stock> stockListAll = stockService.getAllStock();
        try {
            return ResponseEntity.ok(stockListAll);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @DeleteMapping("/delete/{id}")
    private ResponseEntity deleteStock (@PathVariable Long id){
        stockService.deleteById(id);
        try {
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @GetMapping(name="/getbyid/{id}", value = "{id}")
    private ResponseEntity<Optional<Stock>> findById (@PathVariable Long id){
        Optional<Stock> stockResponse = stockService.getById(id);
        try {
            return ResponseEntity.ok(stockResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @PostMapping("/update")
    @ResponseBody
    private ResponseEntity<Stock> updateStock (@RequestBody Stock stock){
        Stock stockCreate = stockService.updateSoldStock(stock);

        try {
            return ResponseEntity.created(new URI("/api/stock/update"+stockCreate.getIdstock())).body(stockCreate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };
}
