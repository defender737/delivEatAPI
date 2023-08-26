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
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.SHOP_NOT_FOUND, "not found."));

        return shopMapper.toDto(shop);
    }

    @Override
    @Transactional
    @Modifying
    public void editShop(ShopDto shopDto) {
        UUID shopId = shopDto.getShopId();
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.SHOP_NOT_FOUND, "not found."));
        shop.update(shopDto.getShopName(), shopDto.getAddress(), shopDto.getShopPhoneNumber(), shopDto.getOperationTime(), shopDto.getBreakDay(), shopDto.getStatus());
        shopRepository.save(shop);
    }

    @Override
    @Transactional
    public void deleteShop(UUID shopId) {
        shopRepository.findById(shopId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.SHOP_NOT_FOUND, "not found."));

        shopRepository.deleteById(shopId);
    }

    @Override
    @Transactional
    @Modifying
    public void changeStatus(UUID shopId, String status) {
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.SHOP_NOT_FOUND, "not found."));
        shop.changeStatus(status);
        shopRepository.save(shop);
    }


}
