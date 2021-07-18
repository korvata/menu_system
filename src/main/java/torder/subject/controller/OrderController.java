package torder.subject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import torder.subject.domain.Cart;
import torder.subject.domain.Order;
import torder.subject.repository.MemberRepository;
import torder.subject.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberRepository memberRepository;

    //주문
    @PostMapping("/order")
    @ResponseBody
    public void order(@RequestParam(value = "menuArr[]") List<String> menuArr) {

        String memberId = "yjh";//임시 사용자ID

        for(String menu : menuArr){
            log.info(menu);
        }

        List<Cart> carts = new ArrayList<>();

        Long orderId = orderService.order(memberId, carts);

        log.info("order success!");
        log.info("orderId = {}", orderId);
    }

    //주문 내역
    @GetMapping("/order")
    public String orderList(Model model) {
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        log.info("order page");
        return "orders/orderList";
    }


}
