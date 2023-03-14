package jpaErdPractice.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "delivery_id", nullable = false)
    private Long id;
    private String city;
    private String street;
    private String zipcode;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Builder
    public Delivery(Long id, String city, String street, String zipcode, DeliveryStatus status, Order order) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.status = status;
        this.order = order;
    }
}
