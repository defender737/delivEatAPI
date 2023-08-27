package com.example.delivEatAPI.domain.menu;

import com.example.delivEatAPI.error.MenuNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service

public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository, MenuMapper menuMapper) {

        this.menuRepository = menuRepository;

        this.menuMapper = menuMapper;
    }

    @Override
    @Transactional
    public void addMenu(UUID shopId, MenuDto menuDto) {
        if(shopId.equals(menuDto.getShop().getShopId())){
            menuRepository.save(menuMapper.toEntity(menuDto));
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "shopId가 일치하지 않습니다.");
        }

    }

    @Override
    @Transactional
    public List<MenuDto> getMenuList(UUID shopId) {
        try {
            List<Menu> menuList = menuRepository.findByShop_ShopId(shopId);
            return menuMapper.toDtoList(menuList);
        }catch (DataAccessException e){
            throw new RuntimeException("메뉴 목록을 가져올 수 없습니다.", e);
        }
    }

    @Override
    @Transactional
    public MenuDto getMenu(UUID shopId, Long menuId) {
        Menu menu = menuRepository.findByShop_ShopIdAndMenuId(shopId, menuId);

        MenuDto menuDto = menuMapper.toDto(menu);

        if (menu == null) {
            throw new MenuNotFoundException("메뉴를 찾을 수 없습니다. ID: " + menuId);
        }

        return menuDto;
    }

    @Override
    @Transactional
    @Modifying
    public void editMenu(UUID shopId, MenuDto menuDto) {
        Menu menu = menuRepository.findByShop_ShopIdAndMenuId(shopId, menuDto.getMenuId());
        if (menu == null) {
            throw new MenuNotFoundException("해당 메뉴는 존재하지 않습니다.");
        }
        menu.update(menuDto.getMenuName(), menuDto.getMenuPrice(), menuDto.getCategory());
        menuRepository.save(menu);
    }

    @Override
    @Transactional
    public void deleteAllMenu(UUID shopId) {
        menuRepository.deleteAllByShop_ShopId(shopId);
    }

    @Override
    @Transactional
    public void deleteMenu(Long menuId) {
        menuRepository.deleteById(menuId);
    }
}
