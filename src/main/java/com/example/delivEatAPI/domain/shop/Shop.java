package com.example.delivEatAPI.domain.shop;


import javax.persistence.*;

@Entity
@Table(name = "TB_shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "menu_category") // 음식 종류(ex. 분식)
    private ShopCategoryEnum shopCategoryEnum;
}
