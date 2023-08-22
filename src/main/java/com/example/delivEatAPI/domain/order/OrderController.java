package com.example.delivEatAPI.domain.order;



import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){this. orderService = orderService;}

    //메뉴 주문
    @PostMapping("v1/user/{user_id}/order")
    public ResponseEntity<String> addOrder(@PathVariable Long user_id, @RequestBody OrderDto orderDto){
        orderService.addOrder(user_id, orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("주문이 완료되었습니다. 주문ID: " +  orderDto.getOrderId());
    }

    //단일 주문 조회(주문ID)
    @GetMapping("v1/order/{order_id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long order_id) {
        OrderDto gettedorder = orderService.getOrder(order_id);
        return ResponseEntity.ok(gettedorder);
    }

    //유저의 모든 주문 조회
    @GetMapping("v1/user/{user_id}/order")
    public ResponseEntity <List<OrderDto>> getOrderList(@PathVariable Long user_id) {
        List<OrderDto> gettedorderList = orderService.getOrderList(user_id);
        return ResponseEntity.ok(gettedorderList);
    }

    //주문 접수or거절 처리
    @PutMapping("v1/order/{order_id}/{status}")
    public ResponseEntity <String> ChangeOrderStatus(@PathVariable Long order_id, @PathVariable String status) {
        orderService.changeStatus(order_id, status);
        return ResponseEntity.status(HttpStatus.CREATED).body("주문이" + status + "되었습니다. 주문ID: " +  order_id);
    }







}
