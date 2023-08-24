package com.example.delivEatAPI.domain.shop;

import java.util.UUID;

public interface ShopService {
    void addShop(ShopDto shopDto);

    ShopDto getShop(UUID shop_id);

    void editShop(ShopDto shopDto);

    void deleteShop(UUID shop_id);

    void changeStatus(UUID shop_id, String status);
}
