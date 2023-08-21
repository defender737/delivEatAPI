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
    @JoinColumn(name = "user", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menu", nullable = false)
    private Menu menuId;

    @Column(name = "quantity", nullable = false)
    private String quantity;

    public Cart(Order order, Menu menuId, String quantity) {
        this.order = order;
        this.menuId = menuId;
        this.quantity = quantity;
    }
}
