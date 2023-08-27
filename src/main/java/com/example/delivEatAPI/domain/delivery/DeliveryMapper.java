package com.example.delivEatAPI.domain.delivery;

import com.example.delivEatAPI.global.config.GenericMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface DeliveryMapper extends GenericMapper<DeliveryDto, Delivery> {


    @Override
    @Mapping(target = "pickupTime", ignore = true)
    Delivery toEntity(DeliveryDto deliveryDto);
}
