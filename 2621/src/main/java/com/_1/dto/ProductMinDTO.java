package com._1.dto;

import com._1.entities.Product;
import com._1.projections.ProductMinProjection;

public class ProductMinDTO {

    private String name;

    public ProductMinDTO() {}

    public ProductMinDTO(String name) {
        this.name = name;
    }

    public ProductMinDTO(ProductMinProjection projection) {
        name = projection.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductMinDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
