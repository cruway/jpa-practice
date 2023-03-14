package jpaErdPractice.domain;

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
    private String id;

    private String userName;
    private String city;
    private String street;
    private String zipcode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
    @OneToMany(mappedBy = "member")
    private List<Order> orders;
    @Builder
    public Member(String id, String userName, String city, String street, String zipcode, Team team, List<Order> orders) {
        this.id = id;
        this.userName = userName;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
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
