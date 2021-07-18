package torder.subject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @PostMapping("/cart")
    @ResponseBody
    public void create(@RequestParam(value = "menuArr[]") List<String> menuArr, Model model) {

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

    //카트 목록
    @GetMapping("/cart")
    public String cartList(Model model) {

        model.addAttribute("carts", carts);

        log.info("cartList");
        return "cart/cartList";
    }
}
