package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@Deprecated
public class JpaMain {

    // JPA定番コード（流れを確認するため）

    /**
     * ・entity manager factoryは一つだけ生成してアプリケーション全体に共有
     * ・entity managerはthread間の共有は禁止(使用したら捨てる)
     * ・JPAの全てのデータ変更はtransaction中で実行
     */
    public static void main(String[] args) {
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            *//*Member member = Member
                    .builder()
                    .id(3L)
                    .username("C")
                    .roleType(RoleType.GUEST)
                    .build();*//*
            Member2 member = Member2.builder()
                    .id("ID_A")
                    .username("C")
                    .build();

            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();*/
    }
}
