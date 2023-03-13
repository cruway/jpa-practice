package jpaErdPractice;


import jpaErdPractice.domain.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Jpamain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /*Movie moive = Movie.movieBuilder()
                    .director("aaaa")
                    .actor("bbbb")
                    .name("hello")
                    .price(10000)
                    .build();

            em.persist(moive);

            em.flush();
            em.clear();

            Movie findMove = em.find(Movie.class, moive.getId());
            System.out.println("findMove = " + findMove);*/

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
