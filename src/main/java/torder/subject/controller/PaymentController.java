package torder.subject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import torder.subject.domain.Cart;
import torder.subject.domain.Member;
import torder.subject.domain.Payment;
import torder.subject.repository.PaymentRepository;
import torder.subject.service.PaymentService;
import torder.subject.session.SessionConst;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    //결제
    @PostMapping("/pay")
    @ResponseBody
    public void pay(@RequestParam(value = "orderId[]") List<Long> orderIds) {

        for(Long orderId : orderIds){
            log.info("orderId : {}", orderId);
        }

        for(Long orderId : orderIds){
            paymentService.pay(orderId);
        }

        log.info("pay success!");
    }

    //결제내역 조회
    @GetMapping("/payments")
    public String payments(Model model) {

        List<Payment> payments = paymentService.findYPayments();
        model.addAttribute("payments", payments);

        log.info("payment page");

        return "payments/paymentList";
    }
}
