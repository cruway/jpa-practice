package jpaentity3.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id", nullable = false)
    private String name;
    private String city;
    private String street;
    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<Order> orders; // 普通は設計的によくない

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locker_id")
    private Locker locker;

    @ManyToMany
    @JoinTable(name = "member_product")
    private List<Product> products;

    @Builder
    public Member(String name, String city, String street, String zipcode, List<Order> orders, Locker locker, List<Product> products) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.orders = new ArrayList<>();
        this.locker = locker;
        this.products = new ArrayList<>();
    }
}
