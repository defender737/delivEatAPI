package com.example.delivEatAPI.domain.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

    public Long orderId;

    public String status;

    public String address;

    public String dateTime;

    public Long userId;
}
