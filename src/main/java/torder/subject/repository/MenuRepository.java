package torder.subject.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import torder.subject.domain.Menu;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MenuRepository {

    private final EntityManager em;
    public void save(Menu menu) {
        if (menu.getId() == null) {
            em.persist(menu);
        } else {
            em.merge(menu);
        }
    }
    public Menu findOne(Long id) {
        return em.find(Menu.class, id);
    }
    public List<Menu> findAll() {
        return em.createQuery("select i from Item i",Menu.class).getResultList();
    }
}
