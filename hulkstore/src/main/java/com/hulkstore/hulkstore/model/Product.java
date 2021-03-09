package com.hulkstore.hulkstore.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduct")
    private Long idProduct;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "unitprice")
    private Double unitPrice;

   /* @OneToMany(mappedBy = "product", cascade = {
            CascadeType.ALL
    })
    private List<Inventory> inventoryList;


*/
  /* @OneToMany(mappedBy = "product", cascade = {
           CascadeType.ALL
   })
   private List<Stock> stockListList;*/

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
/*
    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public List<Stock> getStockListList() {
        return stockListList;
    }

    public void setStockListList(List<Stock> stockListList) {
        this.stockListList = stockListList;
    }

    */
}
