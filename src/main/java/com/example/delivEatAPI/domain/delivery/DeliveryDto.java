package com.example.delivEatAPI.domain.delivery;

import com.example.delivEatAPI.domain.order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeliveryDto {

    private UUID id;

    @NotBlank(message = "필수 입력 사항입니다.")
    private String riderName;

    private LocalDateTime pickupTime;

    private String status;

    @NotBlank(message = "필수 입력 사항입니다.")
    private Order order;
}
