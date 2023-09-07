package com.example.delivEatAPI.domain.delivery;

import com.example.delivEatAPI.domain.order.OrderService;
import com.example.delivEatAPI.error.commonException.EntityNotFoundException;
import com.example.delivEatAPI.error.ErrorCode;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeliveryServiceImpl implements DeliveryService{

    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;
    private final OrderService orderService;


    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, DeliveryMapper deliveryMapper, OrderService orderService) {
        this.deliveryRepository = deliveryRepository;
        this.deliveryMapper = deliveryMapper;
        this.orderService = orderService;
    }


    @Override
    public void startDelivery(DeliveryDto deliveryDto) {
        orderService.changeStatus(deliveryDto.getOrder().getId(), "배달중");
        Delivery delivery = deliveryMapper.toEntity(deliveryDto);
        deliveryRepository.save(delivery);

    }

    @Override
    public DeliveryDto getDelivery(UUID delivery_id) {
        Delivery delivery = deliveryRepository.findById(delivery_id)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.DELIVERY_NOT_FOUND, "배송 정보를 찾을 수 없습니다."));
        return deliveryMapper.toDto(delivery);
    }

    @Override
    public void endDelivery(UUID delivery_id) {
        Delivery delivery = deliveryRepository.findById(delivery_id)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.DELIVERY_NOT_FOUND, "배송 정보를 찾을 수 없습니다."));
        orderService.changeStatus(delivery.getOrder().getId(), "배달완료");
        deliveryRepository.save(delivery);
    }
}
