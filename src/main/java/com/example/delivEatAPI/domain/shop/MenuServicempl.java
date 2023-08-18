package com.example.delivEatAPI.domain.shop;

import org.modelmapper.ModelMapper;
import com.example.delivEatAPI.error.MenuNotFoundException;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class MenuServicempl implements MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<MenuDto> getMenuList(Long shopId) {
        List<MenuDto> menuDtoList = menuRepository.findByShopId(shopId);
        if (menuDtoList.isEmpty()) {
            throw new MenuNotFoundException("메뉴 목록을 찾을 수 없습니다.");
        }
        return menuDtoList;
    }

    @Override
    public MenuDto getMenu(Long shopId, Long menuId) {
        MenuDto menu = menuRepository.findByShopIdAndMenuId(shopId, menuId);

        if (menu == null) {
            throw new MenuNotFoundException("메뉴를 찾을 수 없습니다. ID: " + menuId);
        }

        return menu;
    }


    @Override
    public void addMenu(Long shopId, MenuDto menuDto) {
        MenuDto menu = menuRepository.insertMenu(menuDto);
        if (menu == null) {
            throw new MenuNotFoundException("메뉴를 찾을 수 없습니다. ID: " + menuDto.getMenuId());
        }
    }

    @Override
    public void editMenu(Long shopId, Long menuId, MenuDto menuDto) {
        MenuDto existingMenu = menuRepository.findByShopIdAndMenuId(shopId, menuId);

        if (existingMenu == null) {
            throw new MenuNotFoundException("해당 메뉴는 존재하지 않습니다.");
        }
        modelMapper.map(menuDto, existingMenu);
        menuRepository.updateMenu(existingMenu);
    }

    @Override
    public void deleteAllMenu(Long shopId) {

    }

    @Override
    public void deleteMenu(Long shopId, Long menuId) {

    }
}
