package com.example.delivEatAPI.domain.menu;

import com.example.delivEatAPI.domain.shop.Shop;
import com.example.delivEatAPI.domain.shop.ShopRepository;
import com.example.delivEatAPI.error.ShopNotFoundException;
import org.modelmapper.ModelMapper;
import com.example.delivEatAPI.error.MenuNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final ShopRepository shopRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository, ShopRepository shopRepository) {

        this.menuRepository = menuRepository;
        this.shopRepository = shopRepository;
    }


    @Override
    @Transactional
    public List<MenuDto> getMenuList(Long shopId) {
        List<Menu> menuList = menuRepository.findByShop_ShopId(shopId);
        if (menuList.isEmpty()) {
            throw new MenuNotFoundException("메뉴 목록을 찾을 수 없습니다.");
        }

        return menuList.stream()
                .map(menuEntity -> modelMapper.map(menuEntity, MenuDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MenuDto getMenu(Long shopId, Long menuId) {
        Menu menu = menuRepository.findByShop_ShopIdAndMenuId(shopId, menuId);

        MenuDto menuDto = modelMapper.map(menu, MenuDto.class);

        if (menu == null) {
            throw new MenuNotFoundException("메뉴를 찾을 수 없습니다. ID: " + menuId);
        }

        return menuDto;
    }


    @Override
    @Transactional
    public void addMenu(Long shopId, MenuDto menuDto) {
        // MenuDto로부터 필요한 정보 추출
        String menuName = menuDto.getMenuName();
        int menuPrice = menuDto.getMenuPrice();
        String category = menuDto.getCategory();
        Long bodyShopId = menuDto.getShopId();

        if (bodyShopId.equals(shopId)) {
            // MenuDto에서 필요한 정보로 Menu 엔티티 생성
            Shop shop = shopRepository.findById(shopId)
                    .orElseThrow(() -> new ShopNotFoundException("상점을 찾을 수 없습니다."));

            Menu menu = new Menu(menuName, menuPrice, category, shop);

            // Menu 엔티티 저장
            menuRepository.save(menu);
        } else {
            throw new IllegalArgumentException("요청된 상점 ID와 메뉴에 포함된 상점 ID가 일치하지 않습니다.");
        }
    }

    @Override
    @Transactional
    public void editMenu(Long shopId, Long menuId, MenuDto menuDto) {
        Menu forUpdateMenu = menuRepository.findByShop_ShopIdAndMenuId(shopId, menuId);

        if (forUpdateMenu == null) {
            throw new MenuNotFoundException("해당 메뉴는 존재하지 않습니다.");
        }
        forUpdateMenu.changeName(menuDto.getMenuName());
        forUpdateMenu.changePrice(menuDto.getMenuPrice());
        forUpdateMenu.changeCategory(menuDto.getCategory());


        menuRepository.save(forUpdateMenu);
    }

    @Override
    @Transactional
    public void deleteAllMenu(Long shopId) {
        menuRepository.deleteAllByShop_ShopId(shopId);
    }

    @Override
    @Transactional
    public void deleteMenu(Long shopId, Long menuId) {
        menuRepository.deleteMenuByShop_ShopIdAndMenuId(shopId, menuId);
    }
}
