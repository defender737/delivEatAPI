package com.example.delivEatAPI.domain.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByShop_ShopId(Long shopId);

    Menu findByShop_ShopIdAndMenuId(Long shopId, Long menuId);

    void deleteAllByShop_ShopId(Long ShopId);

    void deleteMenuByShop_ShopIdAndMenuId(Long shopId, Long menuId);

}


