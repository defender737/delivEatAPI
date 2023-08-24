package com.example.delivEatAPI.domain.menu;


import java.util.List;
import java.util.UUID;


public interface MenuService {

    void addMenu(UUID shopId, MenuDto menuDto);
    List<MenuDto> getMenuList(UUID shopId);

    MenuDto getMenu(UUID shop_id, Long menuId);

    void editMenu(UUID shop_id, MenuDto menuDto);

    void deleteAllMenu(UUID shopId);

    void deleteMenu(UUID shop_id, Long menu_id);
}
