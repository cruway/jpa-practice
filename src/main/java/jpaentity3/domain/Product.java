package jpaentity3.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Deprecated
// 実際の仕事では使わない
/*@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity*/
public class Product {

    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "product")
    private List<MemberProduct> memberProducts;

    public Product(Long id, List<MemberProduct> memberProducts) {
        this.id = id;
        this.memberProducts = new ArrayList<>();
    }
}
