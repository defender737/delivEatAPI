package com.example.delivEatAPI.domain.shop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("v1/shop")
    public ResponseEntity<String>addShop(@RequestBody ShopDto shopDto){
        shopService.addShop(shopDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("매장이 성공적으로 추가되었습니다.");
    }

    @GetMapping("v1/shop/{shop_id}")
    public ResponseEntity<ShopDto>getShop(@PathVariable Long shop_id){
        ShopDto shopDto = shopService.getShop(shop_id);
        return ResponseEntity.ok(shopDto);
    }

    @PatchMapping ("v1/shop/{shop_id}")
    public ResponseEntity<String>addShop(@PathVariable Long shop_id, @RequestBody ShopDto shopDto){
        shopService.editShop(shop_id, shopDto);
        return ResponseEntity.ok("매장 정보가 성공적으로 수정되었습니다.");
    }

    @DeleteMapping("v1/shop/{shop_id}")
    public ResponseEntity<String>deleteShop(@PathVariable Long shop_id){
        shopService.deleteShop(shop_id);
        return ResponseEntity.ok("매장이 성공적으로 삭제되었습니다.");
    }
}
