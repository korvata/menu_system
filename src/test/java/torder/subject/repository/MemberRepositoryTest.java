package torder.subject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import torder.subject.domain.Member;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    public void saveMember(){
        //given
        Member member = new Member();
        member.setId("ff");
        member.setPwd("1234");

        //when
        String memberId = memberRepository.save(member);

        //then
        assertThat("ff").isEqualTo(memberRepository.findByLoginId(memberId).get().getId());   //통과
        assertThat("asdf").isEqualTo(memberRepository.findByLoginId(memberId).get().getId());   //실패

    }

    @Test
    public void showMember(){
        //given
        String memberId = "zzzzz";

        //when
        Member member = memberRepository.findOne(memberId);

        //then
        assertThat(member.getId()).isEqualTo(memberId);     //통과
        assertThat("asdf").isEqualTo(memberId);     //통과

    }

}