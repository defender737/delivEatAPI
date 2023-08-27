package com.example.delivEatAPI.domain.shop;

import com.example.delivEatAPI.error.commonException.EntityNotFoundException;
import com.example.delivEatAPI.error.ErrorCode;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

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
    public ShopDto getShop(UUID shopId) {
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.SHOP_NOT_FOUND, "해당 상점을 찾을 수 없습니다."));

        return shopMapper.toDto(shop);
    }

    @Override
    @Transactional
    @Modifying
    public void editShop(ShopDto shopDto) {
        UUID shopId = shopDto.getId();
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.SHOP_NOT_FOUND, "해당 상점을 찾을 수 없습니다."));
        shop.update(shopDto.getShopName(), shopDto.getAddress(), shopDto.getShopPhoneNumber(), shopDto.getOperationTime(), shopDto.getBreakDay(), shopDto.getStatus());
        shopRepository.save(shop);
    }

    @Override
    @Transactional
    public void deleteShop(UUID shopId) {
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.SHOP_NOT_FOUND, "해당 상점을 찾을 수 없습니다."));

        shopRepository.delete(shop);
    }

    @Override
    @Transactional
    @Modifying
    public void changeStatus(UUID shopId, String status) {
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.SHOP_NOT_FOUND, "해당 상점을 찾을 수 없습니다."));
        shop.changeStatus(status);
        shopRepository.save(shop);
    }
}
