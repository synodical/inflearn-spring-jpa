package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // app 로딩 시점에 딱 하나만 있어야 함
        // tx 단위마다 있어야함
        // 쓰레드 간 공유 안됨
        // 모든 데이터 변경은 tx 안에서만 실행
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member = new Member();
        member.setId(1L);
        member.setName("");
        em.persist(member);

        tx.commit();
        em.close();
        emf.close();

    }
}
