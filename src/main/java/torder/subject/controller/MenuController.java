package torder.subject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import torder.subject.domain.Menu;
import torder.subject.service.MenuService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    //메뉴 목록
    @GetMapping("/menus")
    public String list(Model model) {
        List<Menu> menus = menuService.findMenus();
        model.addAttribute("menus", menus);
        return "menus/menuList";
    }
}
