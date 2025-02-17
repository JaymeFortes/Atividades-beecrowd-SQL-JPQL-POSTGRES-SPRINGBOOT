package com._1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private Long id;
    private String name;
    private Integer amount;
    private double price;

    @ManyToOne
    @JoinColumn(name = "id_providers")
    private Provider provider;

    public Product() {}

    public Product(Long id, String name, Integer amount, double price, Provider provider) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.provider = provider;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
