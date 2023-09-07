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
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "menuName", nullable = false)
    private String menuName;

    @Column(name = "menuPrice", nullable = false)
    private int menuPrice;

    @Column(name = "category")
    private String category;

    @ManyToOne
    @JoinColumn(name = "shop", nullable = false)
    private Shop shop;

    @Builder
    public Menu(String menuName, int menuPrice, String category, Shop shop) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = category;
        this.shop = shop;
    }

    public void update(String menuName, int menuPrice, String category){
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = category;
    }

}