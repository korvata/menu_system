package torder.subject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id
    @Column(name = "member_id")
    private String id;              //회원 id

    private String pwd;             //회원 패스워드

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>(); //주문내역
}
