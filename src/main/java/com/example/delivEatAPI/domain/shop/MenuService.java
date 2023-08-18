package com.example.delivEatAPI.domain.shop;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {

    List<MenuDto> getMenuList(Long shopId);

    MenuDto getMenu(Long shop_id, Long menuId);

    void addMenu(Long shopId, MenuDto menuDto);

    void editMenu(Long shop_id, Long menu_id, MenuDto menuDto);

    void deleteAllMenu(Long shopId);

    void deleteMenu(Long shop_id, Long menu_id);
}
