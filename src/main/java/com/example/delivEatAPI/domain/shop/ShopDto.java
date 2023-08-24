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
import java.util.UUID;


@Getter
@Setter
public class ShopDto {


    private UUID shopId;

    private String shopName;

    private String address;

    private String shopPhoneNumber;

    private String operationTime;

    private String breakDay;

    private String status;

    private List<Menu> menuList;


}
