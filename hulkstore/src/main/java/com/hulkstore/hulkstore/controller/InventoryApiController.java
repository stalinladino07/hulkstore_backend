package com.hulkstore.hulkstore.controller;

import com.hulkstore.hulkstore.model.Inventory;
import com.hulkstore.hulkstore.model.Product;
import com.hulkstore.hulkstore.services.InventoryService;
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
@RequestMapping ("/api/inventory")
public class InventoryApiController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/save")
    @ResponseBody
    private ResponseEntity<Inventory> saveProduct (@RequestBody Inventory inventory){
        Inventory inventoryCreate = inventoryService.create(inventory);

        try {
            return ResponseEntity.created(new URI("/api/hulkstore/save"+inventoryCreate.getIdInventory())).body(inventoryCreate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @GetMapping("/listall")
    private ResponseEntity<List<Inventory>> saveProduct (){
        List<Inventory> inventoryListAll = inventoryService.getAllInventory();
        try {
            return ResponseEntity.ok(inventoryListAll);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @DeleteMapping("/delete/{id}")
    private ResponseEntity deleteInventory (@PathVariable Long id){
        inventoryService.deleteById(id);
        try {
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @GetMapping(name="/getbyid/{id}", value = "{id}")
    private ResponseEntity<Optional<Inventory>> findById (@PathVariable Long id){
        Optional<Inventory> inventoryResponse = inventoryService.getById(id);
        try {
            return ResponseEntity.ok(inventoryResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

    @PostMapping("/update")
    @ResponseBody
    private ResponseEntity<Inventory> updateInventory (@RequestBody Inventory inventory){
        Inventory inventoryCreate = inventoryService.updateSold(inventory);

        try {
            return ResponseEntity.created(new URI("/api/hulkstore/save"+inventoryCreate.getIdInventory())).body(inventoryCreate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };
}
