package com.example.delivEatAPI.domain.shop;

import com.example.delivEatAPI.global.config.GenericMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ShopMapper extends GenericMapper<ShopDto, Shop> {
}
