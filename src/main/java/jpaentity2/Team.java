package jpaentity2;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@ToString(exclude = {"member"})*/
@Deprecated
public class Team {
    @Id
    @Column(name = "TEAM_ID", nullable = false)
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "team")
    private List<Member> members;

    @Builder
    public Team(Long id, String name, List<Member> members) {
        this.id = id;
        this.name = name;
        this.members = new ArrayList<>(); // builderを使う場合、生成者にnew ArrayListを追加する必要がある。
    }

    /*public void addMember(Member member) {
        member.setTeam(this);
        members.add(member);
    }*/
}