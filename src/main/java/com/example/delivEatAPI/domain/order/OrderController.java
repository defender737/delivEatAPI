package com.example.delivEatAPI.domain.order;



import com.example.delivEatAPI.domain.cart.CartDto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/order/")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){this. orderService = orderService;}

    @PostMapping("/user/{user_id}")
    public ResponseEntity<String> addOrder(@PathVariable UUID user_id, @Valid @RequestBody OrderDto orderDto){
        orderService.addOrder(user_id, orderDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("주문이 접수되었습니다.");
    }

    @GetMapping("{order_id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable UUID order_id) {
        OrderDto order = orderService.getOrder(order_id);
        return ResponseEntity.ok(order);
    }

    @GetMapping("user/{user_id}/")
    public ResponseEntity <List<OrderDto>> getOrderList(@PathVariable UUID user_id) {
        List<OrderDto> orderList = orderService.getOrderList(user_id);
        return ResponseEntity.ok(orderList);
    }

    @PutMapping("{order_id}/")
    public ResponseEntity<String> addCartToOrder(@PathVariable UUID order_id, @Valid @RequestBody CartDto cartDto) {
        orderService.addCartToOrder(order_id, cartDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("주문에 상품이 추가되었습니다.");
    }

    @PutMapping("{order_id}/{status}")
    public ResponseEntity <String> ChangeOrderStatus(@PathVariable UUID order_id, @PathVariable String status) {
        orderService.changeStatus(order_id, status);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(String.format("주문상태가 %s(으)로 변경되었습니다.", status));
    }
}
