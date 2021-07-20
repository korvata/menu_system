package torder.subject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import torder.subject.domain.*;
import torder.subject.repository.MemberRepository;
import torder.subject.repository.MenuRepository;
import torder.subject.service.OrderService;
import torder.subject.session.SessionConst;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MenuRepository menuRepository;

    //주문
    @PostMapping("/order")
    @ResponseBody
    public void order(@RequestParam(value = "menuId[]") List<Long> ids,
                      @RequestParam(value = "count[]") List<Integer> cnts,
                      @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember) {

        String memberId = loginMember.getId();

        for(int i=0; i< cnts.size(); i++){
            log.info("menuId : {}", ids.get(i));
            log.info("count : {}", cnts.get(i));
        }

        List<Cart> carts = new ArrayList<>();

        for(int i=0; i < cnts.size(); i++){
            Cart cart = new Cart();
            cart.setMenu(menuRepository.findOne(ids.get(i)));
            cart.setCount(cnts.get(i));

            carts.add(cart);
        }

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
