package com.example.delivEatAPI.domain.shop;

import com.example.delivEatAPI.domain.menu.Menu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "shop")
public class Shop {

    @Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "shopName", nullable = false)
    private String shopName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "shopPhoneNumber")
    private String shopPhoneNumber;

    @Column(name = "operationTime")
    private String operationTime;

    @Column(name = "breakDay")
    private String breakDay;

    @Column(name = "status")
    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "shop")
    private final List<Menu> menuList = new ArrayList<>();


    @Builder
    public Shop(String shopName, String address, String shopPhoneNumber, String operationTime, String breakDay, String status) {
        this.id = UUID.randomUUID();
        this.shopName = shopName;
        this.address = address;
        this.shopPhoneNumber = shopPhoneNumber;
        this.operationTime = operationTime;
        this.breakDay = breakDay;
        this.status = status;
    }

     public void update(String shopName, String address, String shopPhoneNumber, String operationTime, String breakDay, String status){
        this.shopName = shopName;
        this.address = address;
        this.shopPhoneNumber = shopPhoneNumber;
        this.operationTime = operationTime;
        this.breakDay = breakDay;
        this.status = status;
    }

    public void changeStatus(String status){this.status = status;}
}
