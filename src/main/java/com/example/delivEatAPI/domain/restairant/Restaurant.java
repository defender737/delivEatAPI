package com.example.delivEatAPI.domain.restairant;


import javax.persistence.*;

@Entity
@Table(name = "TB_Restraunt")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurant_id")
    private int restaurantId;
}
