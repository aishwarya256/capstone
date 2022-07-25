package com.shopforhome.wishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shopforhome.wishlist.entity.WishlistEntity;

@Repository
public interface WishlistRepo extends JpaRepository<WishlistEntity, Integer> {

}
