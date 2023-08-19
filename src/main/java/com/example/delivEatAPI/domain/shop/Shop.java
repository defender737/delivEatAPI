package com.example.delivEatAPI.domain.shop;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shopId")
    private Long shopId;

    @Column(name = "shopName", nullable = false) // 음식 이름
    private String shopName;

    @Column(name = "address", nullable = false) // 음식 가격
    private String address;

    @Column(name = "shopPhoneNumber") // 카테고리
    private String shopPhoneNumber;

    @Column(name = "operationTime") // 카테고리
    private String operationTime;

    @Column(name = "BreakDay") // 카테고리
    private String BreakDay;

    @Column(name = "status") // 카테고리
    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "shop")
    private final List<Menu> menuList = new ArrayList<>();


    public Shop(String shopName, String address, String shopPhoneNumber, String operationTime, String breakDay, String status) {
        this.shopName = shopName;
        this.address = address;
        this.shopPhoneNumber = shopPhoneNumber;
        this.operationTime = operationTime;
        this.BreakDay = breakDay;
        this.status = status;
    }
}
