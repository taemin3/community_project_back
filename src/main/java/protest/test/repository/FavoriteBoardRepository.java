package protest.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import protest.test.entity.Board;
import protest.test.entity.FavoriteBoard;
import protest.test.entity.Member;

import java.util.List;
import java.util.Optional;

public interface FavoriteBoardRepository extends JpaRepository<FavoriteBoard, Long> {

    List<FavoriteBoard> findByMemberId(Long id);
    Optional<FavoriteBoard> findByMemberAndBoard(Member member, Board board);
}
