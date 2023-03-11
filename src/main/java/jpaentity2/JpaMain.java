package jpaentity2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@Deprecated
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // 保存コード
            /*Team team = Team.builder()
                    .name("TeamA")
                    .build();
            em.persist(team);

            Member member = Member.builder()
                    .username("member1")
                    .team(team)
                    .build();
            em.persist(member);*/

            //team.addMember(member);

            em.flush();
            em.clear();

            //Member findMember = em.find(Member.class, member.getId());
            //Team findTeam = em.find(Team.class, team.getId());
            //List<Member> members = findMember.getTeam().getMembers();

            //System.out.println("team = " + team);
            //System.out.println("findMember = " + findMember);

            /*for (Member m : members) {
                System.out.println("m = " + m.getUsername());
            }*/

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
