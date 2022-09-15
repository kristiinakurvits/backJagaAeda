package com.teamProject.backJagaAeda.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.sellerUser.id = ?1 order by p.dateAdded DESC, p.isActive DESC")
    List<Product> findProductsByUserId(Integer userId);

    @Query("select p from Product p where p.status = ?1 order by p.dateAdded DESC")
    List<Product> findAllProductsStatus(String status);

    @Query("select p from Product p where p.category.id = ?1 and p.status = ?2 order by p.dateAdded DESC")
    List<Product> findProductsByCategory(Integer categoryId, String status);

    @Query("select p from Product p where p.location.region.id = ?1 and p.status = ?2 order by p.dateAdded DESC")
    List<Product> findProductsByRegionId(Integer id, String status);

}