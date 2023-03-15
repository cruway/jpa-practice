package jpaErdPractice;


import jpaErdPractice.domain.AddressEntity;
import jpaErdPractice.domain.Member;
import jpaErdPractice.domain.Team;
import jpaErdPractice.domain.embeded.Address;

import javax.persistence.*;


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
                    .userName("member1")
                    .team(team)
                    .homeAddress(Address.builder()
                            .city("old1")
                            .street("street")
                            .zipcode("10000")
                            .build())
                    .build();

            member.getFavoriteFoods().add("chicken");
            member.getFavoriteFoods().add("sushi");
            member.getFavoriteFoods().add("pizza");

            member.getAddressHistory().add(AddressEntity.builder()
                            .city("old1")
                            .street("street")
                            .zipcode("10000")
                    .build());
            member.getAddressHistory().add(AddressEntity.builder()
                    .city("old2")
                    .street("street")
                    .zipcode("10000")
                    .build());

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("================ START ================");
            Member findMember = em.find(Member.class, member.getId());*/

            /**
             * cascadeは親entityのみ使う場合、使う。子entityが親entity以外のところで使う場合は使わない
             * orphanRemoval = true 親entityと関係が切れた子entityを自動的に削除
             */
            //
            //List<Member> resultList = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();

            /**
             * JPQL練習
             */
            Member member = Member.builder()
                    .userName("member1")
                    .age(10)
                    .build();
            Member result = em.createQuery("select m from Member m where m.userName=:userName", Member.class)
                            .setParameter("userName", "member1")
                                    .getSingleResult();

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
