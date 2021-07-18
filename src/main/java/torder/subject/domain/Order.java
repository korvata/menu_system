package torder.subject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;                                        //주문 id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;                                  //회원

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderMenu> orderMenus = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;                                //결제

    private LocalDateTime orderDateTime;                    //주문시간


    /**
     * 연관관계 메서드
     */
    public void setMember(Member member){
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderMenu(OrderMenu orderMenu){
        orderMenus.add(orderMenu);
        orderMenu.setOrder(this);
    }

    public void setPayment(Payment payment){
        this.payment = payment;
        payment.setOrder(this);
    }

    /**
     * 생성 메서드
     */
    public static Order createOrder(Member member, Payment payment, List<OrderMenu> orderMenus){
        Order order = new Order();
        order.setMember(member);
        order.setPayment(payment);

        for(OrderMenu orderMenu : orderMenus){
            order.addOrderMenu(orderMenu);
        }

        order.setOrderDateTime(LocalDateTime.now());

        return order;
    }

    /**
     * 조회 로직
     */
    //전체 주문 가격 조회
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderMenu orderMenu : orderMenus) {
            totalPrice += orderMenu.getTotalPrice();
        }
        return totalPrice;
    }
}