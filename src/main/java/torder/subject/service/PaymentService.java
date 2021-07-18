package torder.subject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import torder.subject.domain.Order;
import torder.subject.domain.Payment;
import torder.subject.domain.PaymentStatus;
import torder.subject.repository.OrderRepository;
import torder.subject.repository.PaymentRepository;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    //결제
    @Transactional
    public void payment(Long orderId) {
        //엔티티 조회
        Order order = orderRepository.findOne(orderId);
        Payment payment = paymentRepository.findByOrder(order);

        payment.setStatus(PaymentStatus.Y);     //결제완료

        orderRepository.deleteById(orderId);    //주문내역 삭제
    }
}