package com.example.delivEatAPI.domain.shop;

import com.example.delivEatAPI.domain.menu.Menu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShopDto {


    private Long shopId;

    private String shopName;

    private String address;

    private String shopPhoneNumber;

    private String operationTime;

    private String BreakDay;

    private String status;

    private List<Menu> menuList;
}
