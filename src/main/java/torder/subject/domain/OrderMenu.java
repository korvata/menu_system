package torder.subject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_menu")
@Getter @Setter
public class OrderMenu {

    @Id @GeneratedValue
    @Column(name = "order_menu_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;                  //주문 상품

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;                //주문

    private int count;                  //주문 수량

    /**
     * 생성 메서드
     */
    public static List<OrderMenu> createOrderMenus(List<Cart> carts) {
        List<OrderMenu> orderMenus = new ArrayList<>();
        for(Cart cart : carts){
            OrderMenu orderMenu = new OrderMenu();
            orderMenu.setMenu(cart.getMenu());
            orderMenu.setCount(cart.getCount());

            orderMenus.add(orderMenu);
        }
        return orderMenus;
    }

    /**
     * 조회로직
     */
    // 주문상품 전체 가격 조회
    public int getTotalPrice() {
        return getMenu().getPrice() * getCount();
    }
}
