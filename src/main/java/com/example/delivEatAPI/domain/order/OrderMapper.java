package com.example.delivEatAPI.domain.order;

import com.example.delivEatAPI.global.config.GenericMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",  //빌드시 구현체 생성 및 빈 등록
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, // 생성자 주입
        unmappedTargetPolicy = ReportingPolicy.ERROR // 일치하지 않는 필드 발생시 빌드오류발생
)
public interface OrderMapper extends GenericMapper<OrderDto, Order> {

    // DTO 리스트를 Entity 리스트로 매핑
    List<Order> toEntityList(List<OrderDto> dtoList);

    // Entity 리스트를 DTO 리스트로 매핑
    List<OrderDto> toDtoList(List<Order> entityList);

    @Override
    @Mapping(target = "userId", ignore = true)
    OrderDto toDto(Order order);

    @Override
    @Mapping(target = "user", ignore = true)
    Order toEnttiy(OrderDto orderDto);
}
