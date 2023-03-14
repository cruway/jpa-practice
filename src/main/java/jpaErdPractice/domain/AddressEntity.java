package jpaErdPractice.domain;

import jpaErdPractice.domain.embeded.Address;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue
    private Long id;

    private Address address;

    @Builder
    public AddressEntity(String city, String street, String zipcode) {
        this.address = Address.builder()
                .city(city)
                .street(street)
                .zipcode(zipcode)
                .build();
    }

    @Builder
    public AddressEntity(Long id, Address address) {
        this.id = id;
        this.address = address;
    }
}
