package com.example.delivEatAPI.domain.shop;

public interface ShopService {
    void addShop(ShopDto shopDto);

    ShopDto getShop(Long shop_id);

    void editShop(Long shop_id, ShopDto shopDto);

    void deleteShop(Long shop_id);
}
