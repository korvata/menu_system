package torder.subject.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import torder.subject.domain.Order;

import javax.persistence.EntityManager;

@Repository
@Transactional
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;
    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    @Transactional
    public void deleteById(Long id){
        em.createQuery("delete from order where id =:id");
    }

}
