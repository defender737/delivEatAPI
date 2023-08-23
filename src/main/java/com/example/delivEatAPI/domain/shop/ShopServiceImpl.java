package com.example.delivEatAPI.domain.shop;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ShopServiceImpl implements ShopService{

    private final ShopRepository shopRepository;
    private final ShopMapper shopMapper;

    public ShopServiceImpl(ShopRepository shopRepository, ShopMapper shopMapper) {
        this.shopRepository = shopRepository;
        this.shopMapper = shopMapper;
    }

    @Override
    @Transactional
    public void addShop(ShopDto shopDto) {
        Shop shop = shopMapper.toEntity(shopDto);
        shopRepository.save(shop);
    }

    @Override
    @Transactional
    public ShopDto getShop(Long shopId) {
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 매장은 존재하지 않습니다. 주문 ID: " + shopId));

        return shopMapper.toDto(shop);
    }

    @Override
    @Transactional
    @Modifying
    public void editShop(Long shopId, ShopDto shopDto) {
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 매장은 존재하지 않습니다. 주문 ID: " + shopId));
        shopMapper.updateFromDto(shopDto, shop);
        shopRepository.save(shop);
    }

    @Override
    @Transactional
    public void deleteShop(Long shopId) {
        shopRepository.deleteById(shopId);
    }
}
