package torder.subject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import torder.subject.domain.Cart;
import torder.subject.domain.Member;
import torder.subject.domain.Menu;
import torder.subject.service.MenuService;
import torder.subject.session.SessionConst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CartController {

    private final MenuService menuService;
    HashMap<Long, Integer> carts = new HashMap<>();

    //장바구니 담기
    @PostMapping("/cart")
    @ResponseBody
    public void create(@RequestParam(value = "menuArr[]") List<Long> menuArr
            , Model model
            , @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember) {

        log.info("memberID = {}", loginMember.getId());
        log.info("cartList");

        for(Long menuId : menuArr){
            log.info("{}",menuId);
        }

        for(Long menuId : menuArr){
            if(carts.containsKey(menuId)){
                carts.put(menuId, carts.get(menuId)+1);
            }else{
                carts.put(menuId, 1);
            }
        }

        for(Long key : carts.keySet()){
            log.info("menu : {}, count : {}", key, carts.get(key));
        }

        log.info("cart created!");
    }

    //장바구니 목록
    @GetMapping("/cart")
    public String cartList(Model model
            , @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember) {

        List<Cart> newCart = new ArrayList<>();

        model.addAttribute("carts", carts);

        log.info("memberID = {}", loginMember.getId());
        log.info("cart page");
        return "cart/cartList";
    }
}
