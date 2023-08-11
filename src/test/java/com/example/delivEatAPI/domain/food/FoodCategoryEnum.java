package com.example.delivEatAPI.domain.food;

public enum FoodCategoryEnum {
    KOREAN("Korean"),           // 한식
    CHINESE("Chinese"),         // 중식
    JAPANESE("Japanese"),       // 일식
    WESTERN("Western"),         // 양식
    CHICKEN("Chicken"),         // 치킨
    PIZZA("Pizza"),             // 피자
    FLOUR_FOOD("Flour Food"),   // 분식
    FAST_FOOD("Fast Food"),     // 패스트푸드
    DESSERT("Dessert");         // 카페,디저트

    private final String category;

    FoodCategoryEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }
}