package com._2.repositories;





import com._2.dto.CustomerMinDTO;
import com._2.entities.Customer;
import com._2.projections.CustomerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


    @Query(nativeQuery = true, value = "SELECT name "
            + "FROM customers "
            + "WHERE UPPER(state) = UPPER(:state) ")
    List<CustomerMinProjection> search1(String state);

    @Query("SELECT new com._2.dto.CustomerMinDTO(obj.name) "
            + "FROM Customer obj "
            + "WHERE UPPER(obj.state) = UPPER(:state)")
    List<CustomerMinDTO> search2(String state);
}

