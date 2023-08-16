package com.example.delivEatAPI.domain.shop;


import javax.persistence.*;

@Entity
@Table(name = "TB_shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shop_id")
    private Long shopId;
}