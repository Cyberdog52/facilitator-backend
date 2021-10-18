package ch.zuehlke.lambda.facilitator.store;

import ch.zuehlke.lambda.facilitator.domain.Member;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;

import java.util.Collection;

public interface MemberStore {

    Collection<Member> getMembers();

    void createMember(Member newMember);

    void updateMember(Member member) throws NotFoundException;

    Member getMember(String id) throws NotFoundException;

    void deleteMember(String id);

}
