package com.example.delivEatAPI.domain.order;

import com.example.delivEatAPI.global.config.GenericMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        componentModel = "spring",  //빌드시 구현체 생성 및 빈 등록
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, // 생성자 주입
        unmappedTargetPolicy = ReportingPolicy.ERROR // 일치하지 않는 필드 발생시 빌드오류발생
)
public interface OrderMapper extends GenericMapper<OrderDto, Order> {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Override
    OrderDto toDto(Order order);

    @Override
    Order toEntity(OrderDto orderDto);

    List<OrderDto> toDtoList(List<Order> entityList);

}
