package com.teamProject.backJagaAeda.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

    @Query("select p from ProductOrder p where p.order.buyerUser.id = ?1 order by p.order.dateTime DESC")
    List<ProductOrder> findProductsByBuyerId(Integer buyerId);

    @Query("select p from ProductOrder p where p.order.id = ?1 order by p.product.location.region.county, p.product.name")
    List<ProductOrder> findProductsByOrderId(Integer orderId);

    @Query("select p from ProductOrder p where p.order.status = ?1 and p.order.buyerUser.id = ?2 order by p.id")
    List<ProductOrder> findProductsByStatusAndBuyerId(String status, Integer buyerId);



}