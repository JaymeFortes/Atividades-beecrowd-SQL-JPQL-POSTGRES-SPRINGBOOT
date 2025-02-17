package com._1.repositories;

import com._1.dto.ProductMinDTO;
import com._1.entities.Product;
import com._1.projections.ProductMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "SELECT products.name " +
            "FROM products " +
            "INNER JOIN providers ON products.id_providers = providers.id " +
            "WHERE products.amount BETWEEN :min AND :max " +
            "AND LOWER(providers.name) LIKE LOWER(CONCAT(:beginName, '%'))")
    List<ProductMinProjection> search1(Integer min, Integer max, String beginName);

    @Query("SELECT new com._1.dto.ProductMinDTO(obj.name)"
            + "FROM Product obj "
            + "WHERE obj.amount BETWEEN :min AND :max "
            + "AND obj.provider.name LIKE CONCAT(:beginName, '%')")
    List<ProductMinDTO> search2(Integer min, Integer max, String beginName);
}
