package torder.subject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import torder.subject.domain.Menu;
import torder.subject.service.MenuService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CartController {

    private final MenuService menuService;

    @PostMapping("/cart")
    @ResponseBody
    public String create(@RequestParam(value = "menuArr[]") List<String> menuArr, Model model) {


        for(String menu : menuArr){
            log.info(menu);
        }
        log.info("cartList");

        List<Menu> menus = new ArrayList<>();

        for(String menuId : menuArr){
            Menu menu = menuService.findOne(menuId);
            menus.add(menu);
        }

        model.addAttribute("menus", menus);

        return "cart/cartList";
    }
}
