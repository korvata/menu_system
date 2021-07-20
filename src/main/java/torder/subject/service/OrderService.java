package torder.subject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import torder.subject.domain.*;
import torder.subject.repository.MemberRepository;
import torder.subject.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    //주문
    @Transactional
    public Long order(String memberId, List<Cart> carts) {
        //엔티티 조회
        Member member = memberRepository.findOne(memberId);

        //결제정보 생성
        Payment payment = new Payment();
        payment.setStatus(PaymentStatus.N);

        //주문상품 생성
        List<OrderMenu> orderMenus = OrderMenu.createOrderMenus(carts);

        //주문 생성
        Order order = Order.createOrder(member, payment, orderMenus);

        //주문 저장
        orderRepository.save(order);

        //장바구니 비우기
        carts.clear();

        return order.getId();
    }

    //단일 주문건 조회
    public Order findOne(Long orderId){
        return orderRepository.findOne(orderId);
    }

    //전체 주문내역
    public List<Order> findOrders(){
        return orderRepository.findAll();
    }

    //결제되지 않은 주문 내역만 조회
    public List<Order> notPayedOrderList(String memberId){
        List<Order> orders = findOrders();

        List<Order> orderList = new ArrayList<>();

        for(Order order : orders){
            if(order.getMember().getId().equals(memberId) && order.getPayment().getStatus().equals(PaymentStatus.N)){
                orderList.add(order);
            }
        }

        return orderList;
    }
}
