package com.example.delivEatAPI.domain.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order/{order_id}/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<String> addCart(@PathVariable Long order_id, @RequestBody CartDto cartDto){
        cartService.addCart(order_id, cartDto);
        return ResponseEntity.ok("카트 추가 완료");
    }

    @DeleteMapping("/{cart_id}")
    public ResponseEntity<String> deleteCart(@PathVariable Long order_id, @PathVariable Long cart_id){
        cartService.deleteCart(order_id, cart_id);
        return ResponseEntity.ok("카트 제거 완료");
    }





}
