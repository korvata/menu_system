package torder.subject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import torder.subject.domain.Member;
import torder.subject.login.LoginForm;
import torder.subject.service.LoginService;
import torder.subject.session.SessionConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final LoginService loginService;

    @GetMapping("/")
    public String login(HttpServletRequest request, Model model, @ModelAttribute("loginForm") LoginForm form) {

        HttpSession session = request.getSession(false);
        if (session == null) {
            log.info("login controller");
            return "login/loginForm";
        }

        Member loginMember = (Member)session.getAttribute(SessionConst.LOGIN_MEMBER);

        //세션에 회원 데이터가 없으면 로그인 화면으로 이동
        if (loginMember == null) {
            log.info("login controller");
            return "login/loginForm";
        }

        model.addAttribute("member", loginMember);
        return "menus/menuList";
    }

}
