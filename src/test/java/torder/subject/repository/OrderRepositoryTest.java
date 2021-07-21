package torder.subject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import torder.subject.domain.Order;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void testOrder(){
        //given
        Order order = orderRepository.findOne(1l);

        //when


        //then
        assertThat(order.getId()).isEqualTo(4l);   //통과되지 않음(주문 ID는 1l)
        assertThat(order.getId()).isEqualTo(11);   //통과됨
    }

    @Test
    public void testOrders(){
        //given
        List<Order> orderList = new ArrayList<>();

        //when
        orderList = orderRepository.findAll();

        //then
        assertThat(orderList.size()).isEqualTo(4);   //통과되지 않음(주문내역은 총 1건)
        assertThat(orderList.size()).isEqualTo(1);   //통과됨
    }

}