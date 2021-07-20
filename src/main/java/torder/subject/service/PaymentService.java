package torder.subject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import torder.subject.domain.Member;
import torder.subject.domain.Order;
import torder.subject.domain.Payment;
import torder.subject.domain.PaymentStatus;
import torder.subject.repository.OrderRepository;
import torder.subject.repository.PaymentRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    //결제
    @Transactional
    public void pay(Long orderId) {
        //엔티티 조회
        Order order = orderRepository.findOne(orderId);
        Payment payment = paymentRepository.findByOrder(order);

        payment.setStatus(PaymentStatus.Y);     //결제완료

        //orderRepository.deleteById(orderId);    //주문내역 삭제
    }

    //결제내역 조회
    public List<Payment> findPayments(){

        return paymentRepository.findAll();
    }

    //결제상태가 Y인 결제내역만 조회
    public List<Payment> findYPayments(String memberId){

        List<Payment> payments = findPayments();

        List<Payment> paymented = new ArrayList<>();

        for(Payment payment : payments){
            if(payment.getOrder().getMember().getId().equals(memberId) && payment.getStatus().equals(PaymentStatus.Y)){
                paymented.add(payment);
            }
        }

        return paymented;
    }
}
