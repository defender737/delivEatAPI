package com.example.delivEatAPI.domain.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<String> addCart(@Valid @RequestBody CartDto cartDto){
        cartService.addCart(cartDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("카트가 추가되었습니다.");
    }

    @PutMapping("/{cart_id}/{quantity}")
    public ResponseEntity<String> changeQuantity(@PathVariable Long cart_id, @PathVariable int quantity) {
        cartService.changeQuantity(cart_id, quantity);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("수량이 변경되었습니다.");
    }

    @DeleteMapping("/{cart_id}")
    public ResponseEntity<String> deleteCart(@PathVariable Long cart_id){
        cartService.deleteCart(cart_id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("카트가 삭제되었습니다.");
    }
}
