package protest.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import protest.test.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByBoardName(String name);
}
