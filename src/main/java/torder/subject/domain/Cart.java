package torder.subject.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cart {

    private Menu menu;              //메뉴
    private int count;              //메뉴 수량

    /**
     * 조회로직
     */
    //전체 메뉴 가격
    public int getTotalPrice() {
        return menu.getPrice() * getCount();
    }
}
