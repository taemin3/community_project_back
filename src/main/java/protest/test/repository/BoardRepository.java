package protest.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import protest.test.domain.Board;
import protest.test.domain.Post;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByBoardName(String name);
}
