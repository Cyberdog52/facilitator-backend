package ch.zuehlke.lambda.facilitator.store;

import ch.zuehlke.lambda.facilitator.domain.Member;
import ch.zuehlke.lambda.facilitator.exception.BadRequestException;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import ch.zuehlke.lambda.facilitator.repository.MemberRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@Profile(value = "!dev")
public class MemberStoreRepo implements MemberStore {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberStoreRepo(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Collection<Member> getMembers() {
        return IteratorUtils.toList(memberRepository.findAll().iterator());
    }

    @Override
    public void createMember(Member newMember) {
        memberRepository.save(newMember);
    }

    @Override
    public void updateMember(Member member) throws NotFoundException {
        memberRepository.save(member);
    }

    @Override
    public Member getMember(String id) throws NotFoundException {
        Optional<Member> memberOptional = memberRepository.findById(id);
        if (memberOptional.isEmpty()) {
            throw new NotFoundException("Could not find member with id " + id);
        }

        return memberOptional.get();
    }

    @Override
    public void deleteMember(String id) {
        try {
            memberRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Could not delete member with id " + id);
        }
    }
}
