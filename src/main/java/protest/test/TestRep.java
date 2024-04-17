package protest.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import protest.test.domain.Post;

@Repository
@RequiredArgsConstructor
public class TestRep {

    @PersistenceContext
    private final EntityManager em;

    public void save(Post post) {
        em.persist(post);
    }





}
