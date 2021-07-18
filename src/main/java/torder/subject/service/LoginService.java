package torder.subject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import torder.subject.domain.Member;
import torder.subject.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    //로그인 실패시 null
    public Member login(String loginId, String password) {
        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPwd().equals(password))
                .orElse(null);
    }
}
