package com.example.delivEatAPI.domain.shop;

import com.example.delivEatAPI.error.ShopNotFoundException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
                .orElseThrow(() -> new ShopNotFoundException("해당 매장을 찾을 수 없습니다.", shopId));

        return shopMapper.toDto(shop);
    }

    @Override
    @Transactional
    @Modifying
    public void editShop(ShopDto shopDto) {
        UUID shopId = shopDto.getShopId();
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new ShopNotFoundException("해당 매장을 찾을 수 없습니다.", shopId));
        shop.update(shopDto.getShopName(), shopDto.getAddress(), shopDto.getShopPhoneNumber(), shopDto.getOperationTime(), shopDto.getBreakDay(), shopDto.getStatus());
        shopRepository.save(shop);
    }

    @Override
    @Transactional
    public void deleteShop(UUID shopId) {
        shopRepository.deleteById(shopId);
    }

    @Override
    @Transactional
    @Modifying
    public void changeStatus(UUID shopId, String status) {
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new ShopNotFoundException("해당 매장을 찾을 수 없습니다.", shopId));
        shop.changeStatus(status);
        shopRepository.save(shop);
    }


}
