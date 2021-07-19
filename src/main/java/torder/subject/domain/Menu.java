package torder.subject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Menu {

    @Id
    private Long id;      //메뉴ID

    private String name;    //메뉴이름
    private int price;      //메뉴가격
}
