package com.example.delivEatAPI.domain.cart;

import com.example.delivEatAPI.domain.order.Order;
import com.example.delivEatAPI.domain.menu.Menu;
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
    private String quantity;

    public Cart(Order order, Menu menuId, String quantity) {
        this.order = order;
        this.menu = menuId;
        this.quantity = quantity;
    }
}
