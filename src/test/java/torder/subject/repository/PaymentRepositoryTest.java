package torder.subject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import torder.subject.domain.Order;
import torder.subject.domain.Payment;
import torder.subject.domain.PaymentStatus;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PaymentRepositoryTest {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void testPayments(){
        //given
        List<Payment> paymentList = new ArrayList<>();

        //when
        paymentList = paymentRepository.findAll();

        //then
        assertThat(paymentList.size()).isEqualTo(4);   //통과되지 않음(전체 결제 내역 1건)
        assertThat(paymentList.size()).isEqualTo(1);   //통과됨

    }

    @Test
    public void testPaymentByOrder(){
        //given
        Order order = orderRepository.findOne(1l);

        //when
        Payment testPayment = paymentRepository.findByOrder(order);

        //then
        assertThat(testPayment.getId()).isEqualTo(4l);   //통과되지 않음(해당 결제ID는 2l)
        assertThat(testPayment.getId()).isEqualTo(2l);   //통과됨

    }

}