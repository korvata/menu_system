package torder.subject.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import torder.subject.domain.Order;
import torder.subject.domain.Payment;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class PaymentRepository {

    private final EntityManager em;

    public void save(Payment payment) {
        if (payment.getId() == null) {
            em.persist(payment);
        } else {
            em.merge(payment);
        }
    }

    public Payment findOne(Long id) {
        return em.find(Payment.class, id);
    }

    public List<Payment> findAll() {
        return em.createQuery("select p from Payment p", Payment.class)
                .getResultList();
    }

    public Payment findByOrder(Order order){
        return findAll().stream()
                .filter(p->p.getOrder().equals(order))
                .findFirst().get();
    }
}