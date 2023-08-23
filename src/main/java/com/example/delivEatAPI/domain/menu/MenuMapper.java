package com.example.delivEatAPI.domain.menu;

import com.example.delivEatAPI.global.config.GenericMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(
        componentModel = "spring",  //빌드시 구현체 생성 및 빈 등록
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, // 생성자 주입
        unmappedTargetPolicy = ReportingPolicy.ERROR // 일치하지 않는 필드 발생시 빌드오류발생
)
public interface MenuMapper extends GenericMapper<MenuDto, Menu> {
    List<MenuDto> toDtoList(List<Menu> menuList);
}
