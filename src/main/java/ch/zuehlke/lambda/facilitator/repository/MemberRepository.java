package ch.zuehlke.lambda.facilitator.repository;

import ch.zuehlke.lambda.facilitator.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, String> {
}
