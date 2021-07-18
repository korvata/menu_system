package torder.subject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import torder.subject.domain.Cart;
import torder.subject.domain.Menu;
import torder.subject.service.MenuService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CartController {

    private final MenuService menuService;
    List<Cart> carts = new ArrayList<>();

    //장바구니 담기
    @PostMapping("/cart")
    @ResponseBody
    public void create(@RequestParam(value = "menuArr[]") List<String> menuArr, Model model) {

        log.info("cartList");

        for(String menu : menuArr){
            log.info(menu);
        }

        for(String menuId : menuArr){
            Cart cart = new Cart();
            cart.setMenu(menuService.findOne(menuId));
            cart.setCount(1);
            carts.add(cart);
        }

        log.info("cart created!");
    }

    //장바구니 목록
    @GetMapping("/cart")
    public String cartList(Model model) {

        model.addAttribute("carts", carts);

        log.info("cart page");
        return "cart/cartList";
    }
}
