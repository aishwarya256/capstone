package com.shopforhome.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopforhome.products.entity.ProductsEntity;

@Repository
public interface ProductRepo extends JpaRepository<ProductsEntity, Integer> {

}
