package com.teamProject.backJagaAeda.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
    @Query("select p from ProductOrder p where p.order.buyerUser.id = ?1 order by p.order.dateTime DESC")
    List<ProductOrder> findProductsByBuyerId(Integer id);

}