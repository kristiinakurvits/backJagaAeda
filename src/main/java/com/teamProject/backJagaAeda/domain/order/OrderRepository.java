package com.teamProject.backJagaAeda.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {


    @Query("select o from Order o where o.buyerUser.id = ?1 and o.status = ?2")
    Optional<Order> findOrderByBuyerUserIdAndStatus(Integer buyerUserId, String status);



}