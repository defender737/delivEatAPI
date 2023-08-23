package com.example.delivEatAPI.domain.menu;

import com.example.delivEatAPI.domain.shop.Shop;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menuId", nullable = false) // Primary Key
    private Long menuId;

    @Column(name = "menuName", nullable = false) // 음식 이름
    private String menuName;

    @Column(name = "menuPrice", nullable = false) // 음식 가격
    private int menuPrice;

    @Column(name = "category") // 카테고리
    private String category;

    @ManyToOne
    @JoinColumn(name = "shop", nullable = false)
    private Shop shop;

    public Menu(String foodName, int foodPrice, String category, Shop shop) {
        this.menuName = foodName;
        this.menuPrice = foodPrice;
        this.category = category;
        this.shop = shop;
    }

}