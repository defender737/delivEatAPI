package com.example.delivEatAPI.domain.order;

import com.example.delivEatAPI.global.config.GenericMapper;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface OrderMapper extends GenericMapper<OrderDto, Order> {

    @Mapping(target = "status", constant = "접수중")
    @Override
    OrderDto toDto(Order entity);

    @Override
    @Mapping(target = "datetime", ignore = true)
    Order toEntity(OrderDto orderDto);

    List<OrderDto> toDtoList(List<Order> entityList);

}
