package torder.subject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import torder.subject.domain.Menu;
import torder.subject.repository.MenuRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public List<Menu> findMenus() {
        return menuRepository.findAll();
    }
    public Menu findOne(String menuId) {
        return menuRepository.findOne(menuId);
    }
}
