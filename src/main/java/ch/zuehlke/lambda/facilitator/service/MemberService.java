package ch.zuehlke.lambda.facilitator.service;

import ch.zuehlke.lambda.facilitator.dto.CreateMemberDTO;
import ch.zuehlke.lambda.facilitator.dto.MemberDTO;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface MemberService {

    Collection<MemberDTO> getMembers();

    String createMember(CreateMemberDTO createMemberDTO);

    void updateMember(MemberDTO memberDTO) throws NotFoundException;

    MemberDTO getMember(String id) throws NotFoundException;

    void deleteMember(String id);
}
