package com.example.delivEatAPI.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MenuDto {

    private Long menuId;
    private String menuName;
    private int menuPrice;
    private String category;
    private Long shopId;

}
