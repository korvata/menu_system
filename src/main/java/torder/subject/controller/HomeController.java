package torder.subject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import torder.subject.domain.Member;
import torder.subject.session.SessionConst;

@Slf4j
public class HomeController {


    @GetMapping("/")
    public String index(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember
            , Model model) {

        if (loginMember == null) {
            return "index";
        }

        log.info("memberID = {}", loginMember.getId());
        model.addAttribute("member", loginMember);
        return "menus/menuList";
    }
}
