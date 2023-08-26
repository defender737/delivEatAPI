package com.example.delivEatAPI.domain.order;



import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){this. orderService = orderService;}

    @PostMapping("v1/user/{user_id}/order")
    public ResponseEntity<String> addOrder(@PathVariable UUID user_id, @Valid @RequestBody OrderDto orderDto){
        orderService.addOrder(user_id, orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("주문이 완료되었습니다. 주문ID: " +  orderDto.getOrderId());
    }

    @GetMapping("v1/order/{order_id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable UUID order_id) {
        OrderDto gettedorder = orderService.getOrder(order_id);
        return ResponseEntity.ok(gettedorder);
    }

    @GetMapping("v1/user/{user_id}/order")
    public ResponseEntity <List<OrderDto>> getOrderList(@PathVariable UUID user_id) {
        List<OrderDto> gettedorderList = orderService.getOrderList(user_id);
        return ResponseEntity.ok(gettedorderList);
    }

    @PutMapping("v1/order/{order_id}/{status}")
    public ResponseEntity <String> ChangeOrderStatus(@PathVariable UUID order_id, @PathVariable String status) {
        orderService.changeStatus(order_id, status);
        return ResponseEntity.status(HttpStatus.CREATED).body("주문상태가 변경되었습니다. 주문상태: " + status + "주문ID: " +  order_id);
    }







}
