package jpaentity.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Deprecated
/*@Entity
@Builder
@Getter
@Setter
@Table(name ="ORDERS")*/
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;
    @Column(name = "member_id")
    private Long memberId;
    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
