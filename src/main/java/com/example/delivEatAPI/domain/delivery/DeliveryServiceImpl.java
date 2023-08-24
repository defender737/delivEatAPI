package com.example.delivEatAPI.domain.delivery;

import com.example.delivEatAPI.domain.order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        orderService.changeStatus(deliveryDto.getOrder().getOrderId(), "배달중");
        Delivery delivery = deliveryMapper.toEntity(deliveryDto);
        deliveryRepository.save(delivery);

    }

    @Override
    public DeliveryDto getDelivery(UUID delivery_id) {
        Delivery delivery = deliveryRepository.findById(delivery_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "배송 조회 불가. 배달 ID: " + delivery_id));

        return deliveryMapper.toDto(delivery);
    }

    @Override
    public void endDelivery(UUID delivery_id) {
        Delivery delivery = deliveryRepository.findById(delivery_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 배달정보를 찾을 수 없습니다. 배달 ID: " + delivery_id));

        orderService.changeStatus(delivery.getOrder().getOrderId(), "배달완료");
        deliveryRepository.save(delivery);
    }

}
