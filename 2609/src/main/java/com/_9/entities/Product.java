package com._9.entities;

//uma categoria tem varios produtos
//varios produtos tem uma categoria

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private Long id;
    private String name;
    private Integer amount;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "id_categories")
    private Category category;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategories() {
        return category;
    }

    public void setCategories(Category categories) {
        this.category = categories;
    }

    public Product() {}

    public Product(Long id, String name, Integer amount, BigDecimal price, Category category) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.category = category;
    }
}
