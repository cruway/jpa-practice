package jpaErdPractice;


import jpaErdPractice.domain.Member;
import jpaErdPractice.domain.Movie;
import jpaErdPractice.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class Jpamain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /*Team team = Team.builder()
                    .name("teamA")
                    .build();
            em.persist(team);

            Member member = Member.builder()
                    .userName("hello")
                    .team(team)
                    .build();
            em.persist(member);

            em.flush();
            em.clear();*/

            //
            List<Member> resultList = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void printMember(Member member) {
        System.out.println("member = " + member.getUserName());
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUserName();
        System.out.println("username = " + username);
    }
}
