package com.example.delivEatAPI.domain.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByShop_Id(UUID shopId);

    Menu findByShop_IdAndId(UUID shopId, Long menuId);

    void deleteAllByShop_Id(UUID ShopId);


}


