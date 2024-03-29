package jpaErdPractice.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "team_id", nullable = false)
    private Long id;

    private String name;

    @BatchSize(size = 100)
    @OneToMany(mappedBy = "team")
    private List<Member> members;

    @Builder
    public Team(Long id, String name, List<Member> members) {
        this.id = id;
        this.name = name;
        this.members = new ArrayList<>();
    }

    public void addMember(Member member) {
        member.setTeam(this);
        this.members.add(member);
    }
}
