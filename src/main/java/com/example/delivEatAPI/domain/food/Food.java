package com.example.delivEatAPI.domain.food;

import com.example.delivEatAPI.domain.Restairant.Restaurant;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "TB_Food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "food_id", nullable = false) // Primary Key
    private Long foodId;

    @Column(name = "food_name", nullable = false) // 음식 이름
    private String foodName;

    @Column(name = "food_price", nullable = false) // 음식 가격
    private int foodPrice;

    @Column(name = "food_category", nullable = false) // 음식 종류(ex. 분식)
    private FoodCategoryEnum foodCategoryEnum;

    @ManyToOne
    @JoinColumn(name = "restaurant", nullable = false)
    private Restaurant restaurant;

    public Food(String foodName, int foodPrice, FoodCategoryEnum foodCategoryEnum, Restaurant restaurant) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodCategoryEnum = foodCategoryEnum;
        this.restaurant = restaurant;
    }
}
