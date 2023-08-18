package com.example.delivEatAPI.domain.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/v1/shop/{shop_id}/menu")
    public List<MenuDto> getMenuList(@PathVariable Long shop_id) {
        return menuService.getMenuList(shop_id);
    }

    @GetMapping("/v1/shop/{shop_id}/menu/{menu_id}")
    public ResponseEntity<MenuDto> getMenu(@PathVariable Long shop_id, @PathVariable Long menu_id) {
        MenuDto menu = menuService.getMenu(shop_id, menu_id);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @PostMapping("/v1/shop/{shop_id}/menu")
    public void addMenu(@PathVariable Long shop_id, @RequestBody MenuDto menuDto) {
        menuService.addMenu(shop_id, menuDto);
    }

    @PatchMapping("/v1/shop/{shop_id}/menu/{menu_id}")
    public void editMenu(@PathVariable Long shop_id, @PathVariable Long menu_id, @RequestBody MenuDto menuDto) {
        menuService.editMenu(shop_id, menu_id, menuDto);
    }

    @DeleteMapping("/v1/shop/{shop_id}/menu")
    public void deleteAllMenu(@PathVariable Long shop_id) {
        menuService.deleteAllMenu(shop_id);
    }

    @DeleteMapping("/v1/shop/{shop_id}/menu/{menu_id}")
    public void deleteMenu(@PathVariable Long shop_id, @PathVariable Long menu_id) {
        menuService.deleteMenu(shop_id, menu_id);
    }
}
