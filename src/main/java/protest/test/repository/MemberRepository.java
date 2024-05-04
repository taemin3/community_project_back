package protest.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import protest.test.domain.Board;
import protest.test.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByLoginId(String id);
}
