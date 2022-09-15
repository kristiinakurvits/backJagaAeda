package com.teamProject.backJagaAeda.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.category.id = ?1 order by p.dateAdded DESC, p.isActive DESC")
    List<Product> findProductsBy(Integer categoryId);

    @Query("select p from Product p where upper(p.name) = upper(?1) order by p.dateAdded DESC")
    List<Product> findProductByDate(String name);

    @Query("select p from Product p where p.location.region.id = ?1 order by p.dateAdded DESC, p.isActive DESC")
    List<Product> findProductsByRegionId(Integer regionId);

    @Query("select p from Product p where p.sellerUser.id = ?1 order by p.dateAdded DESC, p.isActive DESC")
    List<Product> findProductsByUserId(Integer userId);

    @Query("select p from Product p order by p.dateAdded DESC, p.isActive DESC")
    List<Product> findAllProducts();


}