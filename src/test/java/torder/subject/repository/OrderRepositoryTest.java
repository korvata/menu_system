package torder.subject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import torder.subject.domain.Order;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void testOrder(){
        //given
        List<Order> orderList = new ArrayList<>();

        //when
        orderList = orderRepository.findAll();
        System.out.println(orderList);

        //then
        assertThat(orderList.size()).isEqualTo(4);   //통과되지 않음(주문내역은 총 1건)
        assertThat(orderList.size()).isEqualTo(1);   //통과됨
    }

}