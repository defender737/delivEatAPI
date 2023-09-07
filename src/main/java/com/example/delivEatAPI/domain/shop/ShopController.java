package com.example.delivEatAPI.domain.shop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(("v1/shop"))
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    public ResponseEntity<String>addShop(@Valid @RequestBody ShopDto shopDto){
        shopService.addShop(shopDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("상점이 추가되었습니다.");
    }

    @GetMapping("/{shop_id}")
    public ResponseEntity<ShopDto>getShop(@PathVariable UUID shop_id){
        ShopDto shopDto = shopService.getShop(shop_id);
        return ResponseEntity.ok(shopDto);
    }

    @PutMapping
    public ResponseEntity<String>editShop(@Valid @RequestBody ShopDto shopDto){
        shopService.editShop(shopDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("상점 정보를 수정하였습니다.");
    }

    @DeleteMapping("/{shop_id}")
    public ResponseEntity<String>deleteShop(@PathVariable UUID shop_id){
        shopService.deleteShop(shop_id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("상점이 삭제되었습니다.");
    }

    @PutMapping("/{shop_id}/{status}")
    public ResponseEntity <String> ChangeOrderStatus(@PathVariable UUID shop_id, @PathVariable String status) {
        shopService.changeStatus(shop_id, status);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(String.format("상점상태가 %s(으)로 변경되었습니다.", status));
    }
}
