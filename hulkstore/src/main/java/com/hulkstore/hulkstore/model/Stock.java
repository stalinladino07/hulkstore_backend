package com.hulkstore.hulkstore.model;

import javax.persistence.*;

@Entity
@Table(name = "Stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idstock")
    private Long idstock;

    @Column(name = "idproduct")
    private Long idProduct;

    @Column(name = "code")
    private String code;

    @Column(name = "available")
    private Double available;

    @Column(name = "sold")
    private Double sold;

    @Column(name = "purchased")
    private Double purchased;

    public Long getIdstock() {

        return idstock;
    }

    public void setIdstock(Long idstock) {

        this.idstock = idstock;
    }

    public Double getAvailable() {

        return available;
    }

    public void setAvailable(Double available) {
        this.available = available;
    }

    public Double getSold() {
        return sold;
    }

    public void setSold(Double sold) {

        this.sold = sold;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPurchased() {
        return purchased;
    }

    public void setPurchased(Double purchased) {
        this.purchased = purchased;
    }
}
