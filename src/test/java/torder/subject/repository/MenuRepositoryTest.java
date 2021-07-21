package torder.subject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import torder.subject.domain.Menu;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MenuRepositoryTest {

    @Autowired MenuRepository menuRepository;

    @Test
    public void testMenu(){
        //given
        List<Menu> menuList = new ArrayList<>();

        //when
        Menu menu = menuRepository.findOne(1l);

        //then
        assertThat(menu.getId()).isEqualTo(6l);   //통과되지 않음(이 메뉴 ID는 1l)
        assertThat(menu.getId()).isEqualTo(1l);   //통과됨

    }

    @Test
    public void testMenus(){
        //given
        List<Menu> menuList = new ArrayList<>();

        //when
        menuList = menuRepository.findAll();

        //then
        assertThat(menuList.size()).isEqualTo(6);   //통과되지 않음(전체 메뉴는 12개)
        assertThat(menuList.size()).isEqualTo(12);   //통과됨

    }
}