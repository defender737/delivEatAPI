package com.example.delivEatAPI.domain.shop;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "TB_menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id", nullable = false) // Primary Key
    private Long foodId;

    @Column(name = "menu_name", nullable = false) // 음식 이름
    private String foodName;

    @Column(name = "menu_price", nullable = false) // 음식 가격
    private int foodPrice;

    @Column(name = "menu_category", nullable = false) // 음식 종류(ex. 분식)
    private ShopCategoryEnum shopCategoryEnum;

    @ManyToOne
    @JoinColumn(name = "shop", nullable = false)
    private Shop shop;

    public Menu(String foodName, int foodPrice, ShopCategoryEnum shopCategoryEnum, Shop shop) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.shopCategoryEnum = shopCategoryEnum;
        this.shop = shop;
    }
}