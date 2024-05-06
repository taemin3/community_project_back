package protest.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import protest.test.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p join p.member where p.board.id = :boardId")
    Page<Post> findAllWithPost(@Param("boardId") Long boardId, Pageable pageable);

}
