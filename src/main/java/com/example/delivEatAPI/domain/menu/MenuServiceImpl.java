package com.example.delivEatAPI.domain.menu;


import com.example.delivEatAPI.domain.menu.exception.ShopMenuMismatchException;
import com.example.delivEatAPI.error.commonException.EntityNotFoundException;
import com.example.delivEatAPI.error.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

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
        if(shopId.equals(menuDto.getShop().getId())){
            menuRepository.save(menuMapper.toEntity(menuDto));
        }else {
            throw new ShopMenuMismatchException(menuDto.getId());
        }
    }

    @Override
    @Transactional
    public List<MenuDto> getMenuList(UUID shopId) {
        try {
            List<Menu> menuList = menuRepository.findByShop_Id(shopId);
            return menuMapper.toDtoList(menuList);
        }catch (DataAccessException e){
            throw new EntityNotFoundException(ErrorCode.MENU_NOT_FOUND, "해당 메뉴를 찾을 수 없습니다.");
        }
    }

    @Override
    @Transactional
    public MenuDto getMenu(UUID shopId, Long menuId) {
        Menu menu = menuRepository.findByShop_IdAndId(shopId, menuId);
        MenuDto menuDto = menuMapper.toDto(menu);
        if (menu == null) {
            throw new EntityNotFoundException(ErrorCode.MENU_NOT_FOUND, "해당 메뉴를 찾을 수 없습니다.");
        }
        return menuDto;
    }

    @Override
    @Transactional
    @Modifying
    public void editMenu(UUID shopId, MenuDto menuDto) {
        Menu menu = menuRepository.findByShop_IdAndId(shopId, menuDto.getId());
        if (menu == null) {
            throw new EntityNotFoundException(ErrorCode.MENU_NOT_FOUND, "해당 메뉴를 찾을 수 없습니다.");
        }
        menu.update(menuDto.getMenuName(), menuDto.getMenuPrice(), menuDto.getCategory());
        menuRepository.save(menu);
    }

    @Override
    @Transactional
    public void deleteAllMenu(UUID shopId) {
        menuRepository.deleteAllByShop_Id(shopId);
    }

    @Override
    @Transactional
    public void deleteMenu(Long menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.MENU_NOT_FOUND, "해당 메뉴를 찾을 수 없습니다."));
        menuRepository.delete(menu);
    }
}
