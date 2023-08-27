package com.example.delivEatAPI.domain.cart;

import com.example.delivEatAPI.domain.order.Order;
import com.example.delivEatAPI.domain.menu.Menu;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cartId", nullable = false) // Primary Key
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;

    @OneToOne
    @JoinColumn(name = "menuId", nullable = false)
    private Menu menu;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Builder
    public Cart(Order order, Menu menu, int quantity) {
        this.order = order;
        this.menu = menu;
        this.quantity = quantity;
    }

    public void changeQuantity(int quantity){
        this.quantity = quantity;
    }
}
