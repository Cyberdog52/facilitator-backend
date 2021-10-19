package ch.zuehlke.lambda.facilitator.service;

import ch.zuehlke.lambda.facilitator.domain.Member;
import ch.zuehlke.lambda.facilitator.dto.CreateMemberDTO;
import ch.zuehlke.lambda.facilitator.dto.MemberDTO;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import ch.zuehlke.lambda.facilitator.mapper.MemberMapper;
import ch.zuehlke.lambda.facilitator.store.MemberStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberStore memberStore;

    @Autowired
    public MemberServiceImpl(MemberStore memberStore) {
        this.memberStore = memberStore;
    }

    @Override
    public Collection<MemberDTO> getMembers() {
        Collection<Member> members = memberStore.getMembers();
        return MemberMapper.map(members);
    }

    @Override
    public MemberDTO getMember(String id) {
        Member member = memberStore.getMember(id);
        return MemberMapper.map(member);
    }

    @Override
    public String createMember(CreateMemberDTO createMemberDTO) {
        Member member = MemberMapper.map(createMemberDTO);
        memberStore.createMember(member);
        return member.getId();
    }

    @Override
    public void updateMember(MemberDTO memberDTO) throws NotFoundException {
        Member member = MemberMapper.map(memberDTO);
        memberStore.updateMember(member);
    }

    @Override
    public void deleteMember(String id) {
        memberStore.deleteMember(id);
    }
}
