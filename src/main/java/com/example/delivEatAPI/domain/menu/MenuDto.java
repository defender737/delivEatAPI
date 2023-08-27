package com.example.delivEatAPI.domain.menu;

import com.example.delivEatAPI.domain.shop.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MenuDto {

    private Long id;

    @NotBlank(message = "필수 입력 사항입니다.")
    private String menuName;

    @NotBlank(message = "필수 입력 사항입니다.")
    private int menuPrice;

    private String category;

    @NotBlank(message = "필수 입력 사항입니다.")
    private Shop shop;

}
