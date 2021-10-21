package ch.zuehlke.lambda.facilitator.store;

import ch.zuehlke.lambda.facilitator.domain.Member;
import ch.zuehlke.lambda.facilitator.domain.Role;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@Profile(value = "dev")
public class MemberStoreMock implements MemberStore {

    static List<Member> members = new ArrayList<>(List.of(
            new Member("1", "Tamara Widmer", Role.HCU),
            new Member("2", "Delia Treichler", Role.TL),
            new Member("3", "Andres Konrad", Role.MEMBER),
            new Member("4", "Stefanie Ziltener", Role.MEMBER),
            new Member("5", "Georg Mohr", Role.MEMBER),
            new Member("6", "Kevin Gerspacher", Role.MEMBER),
            new Member("7", "Stefan Diegas", Role.MEMBER),
            new Member("8", "Yannick Streit", Role.MEMBER),
            new Member("9", "Raphael Haslebacher", Role.MEMBER),
            new Member("10", "Murièle Trentini", Role.MEMBER),
            new Member("11", "Aaron Krämer", Role.MEMBER),
            new Member("12", "Jasmin Frei", Role.MEMBER),
            new Member("13", "Marius Niklaus", Role.MEMBER),
            new Member("14", "Patrick Grosschmidt", Role.MEMBER)
    ));

    @Override
    public Collection<Member> getMembers() {
        return members;
    }

    @Override
    public Member getMember(String id) throws NotFoundException {
        return members.stream()
                .filter(member -> member.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Could not find member with id " + id));
    }

    @Override
    public void createMember(Member newMember) {
        members.add(newMember);
    }

    @Override
    public void updateMember(Member member) throws NotFoundException {
        Member memberToReplace = this.getMember(member.getId());
        Collections.replaceAll(members, memberToReplace, member);
    }

    @Override
    public void deleteMember(String id) {
        members.removeIf(member -> member.getId().equals(id));
    }
}
