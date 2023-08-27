package com.example.delivEatAPI.domain.cart;

import com.example.delivEatAPI.domain.menu.Menu;
import com.example.delivEatAPI.domain.order.Order;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CartDto {

    private Long id;

    @NotBlank(message = "필수 입력 사항입니다.")
    private Order order;

    @NotBlank(message = "필수 입력 사항입니다.")
    private Menu menu;

    @NotBlank(message = "필수 입력 사항입니다.")
    private int quantity;
}
