package com.teamProject.backJagaAeda.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

    @Query("select p from ProductOrder p where p.order.buyerUser.id = ?1 order by p.order.dateTime DESC")
    List<ProductOrder> findProductsByBuyerId(Integer id);

    @Query("""
            select p from ProductOrder p
            where p.order.id = ?1 and p.order.status = ?2
            order by p.product.location.region.county, p.product.name""")
    List<ProductOrder> findOrderBy(Integer id, String status);

    @Query("select p from ProductOrder p where p.order.id = ?1 order by p.product.location.region.county, p.product.name")
    List<ProductOrder> findProductsByOrderId(Integer id);

}