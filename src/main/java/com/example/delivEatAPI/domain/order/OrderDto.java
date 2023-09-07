package com.example.delivEatAPI.domain.order;

import com.example.delivEatAPI.domain.cart.Cart;
import com.example.delivEatAPI.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderDto {

    public UUID id;

    public String status;

    @NotBlank(message = "필수 입력 사항입니다.")
    public String address;

    public LocalDateTime datetime;

    @NotBlank(message = "필수 입력 사항입니다.")
    public User user;

    private List<Cart> cartList;
}
