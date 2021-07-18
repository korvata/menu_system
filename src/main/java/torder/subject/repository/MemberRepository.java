package torder.subject.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import torder.subject.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = false)
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Member findOne(String id){
        return em.find(Member.class, id);
    }

    @Transactional
    public String save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public Optional<Member> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(m -> m.getId().equals(loginId))
                .findFirst();
    }
}
