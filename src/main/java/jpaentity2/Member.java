package jpaentity2;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Builder
public class Member {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "USERNAME")
    private String username;
    private int age;

    /*@Column(name = "TEAM_ID")
    private Long teamId;*/

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
}