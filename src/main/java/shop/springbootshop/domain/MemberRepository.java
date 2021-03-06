package shop.springbootshop.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public Member findByName(String name) {
        Member findMember = null;
        try {
            findMember = em.createQuery("select m from Member m where m.name = :name", Member.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
        }
        return findMember;
    }
}
