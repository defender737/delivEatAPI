package com.example.delivEatAPI.domain.menu;

import com.example.delivEatAPI.global.config.GenericMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface MenuMapper extends GenericMapper<MenuDto, Menu> {
    List<MenuDto> toDtoList(List<Menu> menuList);
}
