package com.example.delivEatAPI.domain.menu;


import java.util.List;


public interface MenuService {

    void addMenu(Long shopId, MenuDto menuDto);
    List<MenuDto> getMenuList(Long shopId);

    MenuDto getMenu(Long shop_id, Long menuId);

    void editMenu(Long shop_id, Long menu_id, MenuDto menuDto);

    void deleteAllMenu(Long shopId);

    void deleteMenu(Long shop_id, Long menu_id);
}
