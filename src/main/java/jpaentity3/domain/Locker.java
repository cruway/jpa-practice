package jpaentity3.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Deprecated
/*@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity*/
public class Locker {

    @Id
    @GeneratedValue
    @Column(name = "locker_id", nullable = false)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;
}
