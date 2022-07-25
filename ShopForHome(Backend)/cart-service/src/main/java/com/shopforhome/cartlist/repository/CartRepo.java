package com.shopforhome.cartlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopforhome.cartlist.entity.CartEntity;

@Repository
public interface CartRepo extends JpaRepository<CartEntity, Integer> {

}
