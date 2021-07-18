package torder.subject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import torder.subject.domain.Member;
import torder.subject.service.LoginService;
import torder.subject.session.SessionConst;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final LoginService loginService;

    @GetMapping("/")
    public String login(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)
                    Member loginMember,
                    Model model) {

        if (loginMember == null) {
            return "login/loginForm";
        }
        //세션이 유지되면 로그인으로 이동
        model.addAttribute("member", loginMember);
        return "menus/menuList";
    }

}
