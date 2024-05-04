package protest.test.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import protest.test.domain.Post;

@Repository
public interface  PostRepository extends JpaRepository<Post, Long> {



}
