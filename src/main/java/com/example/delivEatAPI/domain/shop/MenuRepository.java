package com.example.delivEatAPI.domain.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface MenuRepository extends JpaRepository {

    List<MenuDto> findByShopId(Long shopId);


    MenuDto findByShopIdAndMenuId(Long shopId, Long menuId);

    MenuDto insertMenu(MenuDto menuDto);

    void updateMenu(MenuDto existingMenu);
}


