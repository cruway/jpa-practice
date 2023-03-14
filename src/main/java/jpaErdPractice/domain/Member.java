package jpaErdPractice.domain;

import jpaErdPractice.domain.embeded.Address;
import jpaErdPractice.domain.embeded.Period;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id", nullable = false)
    private Long id;
    private String userName;
    @Embedded
    private Period workPeriod;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city",
                column = @Column(name = "work_city")),
            @AttributeOverride(name = "street",
                column = @Column(name = "work_street")),
            @AttributeOverride(name = "zipcode",
                column = @Column(name = "work_zipcodes"))
    })
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "favorite_food",
            joinColumns = @JoinColumn(name = "member_id")
    )
    @Column(name = "food_name")
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "address",
//            joinColumns = @JoinColumn(name = "member_id")
//    )
//    private List<Address> addressHistory = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "member_id")
    private List<AddressEntity> addressHistory;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
    @OneToMany(mappedBy = "member")
    private List<Order> orders;
    @Builder
    public Member(Long id, String userName, Period workPeriod, Address homeAddress, List<AddressEntity> addressHistory, Team team, List<Order> orders) {
        this.id = id;
        this.userName = userName;
        this.workPeriod = workPeriod;
        this.homeAddress = homeAddress;
        this.addressHistory = new ArrayList<>();
        this.setTeam(team);
        this.orders = new ArrayList<>();
    }

    public void setTeam(Team team) {
        if(this.team != null) {
            this.team.getMembers().remove(this);
        }
        this.team = team;
        team.getMembers().add(this);
    }

}
