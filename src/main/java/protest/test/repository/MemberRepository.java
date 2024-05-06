package protest.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import protest.test.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByLoginId(String id);
}
