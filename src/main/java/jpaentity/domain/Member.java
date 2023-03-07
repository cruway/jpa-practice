package jpaentity.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private String name;
    private String city;

    private String street;
    private String zipcode;
}
