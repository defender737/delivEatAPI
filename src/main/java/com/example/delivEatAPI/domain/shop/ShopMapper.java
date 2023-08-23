package com.example.delivEatAPI.domain.shop;

import com.example.delivEatAPI.global.config.GenericMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",  //빌드시 구현체 생성 및 빈 등록
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, // 생성자 주입
        unmappedTargetPolicy = ReportingPolicy.ERROR // 일치하지 않는 필드 발생시 빌드오류발생
)
public interface ShopMapper extends GenericMapper<ShopDto, Shop> {
}
