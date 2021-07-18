package torder.subject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Payment {

    @Id @GeneratedValue
    @Column(name = "payment_id")
    private Long id;                //결제 id

    @OneToOne(mappedBy = "payment")
    private Order order;            //주문

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;    //결제상태(Y:결제 완료, N:결제 안됨)
}
