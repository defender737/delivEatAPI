package com.example.delivEatAPI.domain.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/shop/{shop_id}/menu")
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService){ //생성자
        this.menuService = menuService;
    }

    public ResponseEntity<String> addMenu(@PathVariable Long shop_id, @RequestBody MenuDto menuDto) {
        menuService.addMenu(shop_id, menuDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("메뉴가 성공적으로 추가되었습니다.");
    }

    @GetMapping
    public ResponseEntity<List<MenuDto>> getMenuList(@PathVariable Long shop_id) {
        List<MenuDto> menuDtoList = menuService.getMenuList(shop_id);
        return ResponseEntity.ok(menuDtoList);
    }

    @GetMapping("/{menu_id}")
    public ResponseEntity<MenuDto> getMenu(@PathVariable Long shop_id, @PathVariable Long menu_id) {
        MenuDto menu = menuService.getMenu(shop_id, menu_id);
        return ResponseEntity.ok(menu);
    }

    @PostMapping


    @PutMapping("/{menu_id}")
    public ResponseEntity<String> editMenu(@PathVariable Long shop_id, @PathVariable Long menu_id, @RequestBody MenuDto menuDto) {
        menuService.editMenu(shop_id, menu_id, menuDto);
        return ResponseEntity.ok("메뉴가 성공적으로 수정되었습니다.");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllMenu(@PathVariable Long shop_id) {
        menuService.deleteAllMenu(shop_id);
        return ResponseEntity.ok(shop_id + "의 메뉴가 성공적으로 삭제되었습니다.");
    }

    @DeleteMapping("/{menu_id}")
    public ResponseEntity<String> deleteMenu(@PathVariable Long shop_id, @PathVariable Long menu_id) {
        menuService.deleteMenu(shop_id, menu_id);
        return ResponseEntity.ok(menu_id + "의 메뉴가 성공적으로 삭제되었습니다.");
    }
}
