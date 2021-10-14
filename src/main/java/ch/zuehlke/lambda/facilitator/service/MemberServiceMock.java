package ch.zuehlke.lambda.facilitator.service;

import ch.zuehlke.lambda.facilitator.dto.CreateMemberDTO;
import ch.zuehlke.lambda.facilitator.dto.MemberDTO;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemberServiceMock implements MemberService {

    private static List<MemberDTO> members = new ArrayList<>(List.of(
            new MemberDTO("1", "Tamara Widmer", "HCU"),
            new MemberDTO("2", "Delia Treichler", "TL"),
            new MemberDTO("3", "Andres Konrad", "MEMBER"),
            new MemberDTO("4", "Stefanie Ziltener", "MEMBER"),
            new MemberDTO("5", "Georg Mohr", "MEMBER"),
            new MemberDTO("6", "Kevin Gerspacher", "MEMBER"),
            new MemberDTO("7", "Stefan Diegas", "MEMBER"),
            new MemberDTO("8", "Yannick Streit", "MEMBER"),
            new MemberDTO("9", "Raphael Haslebacher", "MEMBER"),
            new MemberDTO("10", "Murièle Trentini", "MEMBER"),
            new MemberDTO("11", "Aaron Krämer", "MEMBER"),
            new MemberDTO("12", "Jasmin Frei", "MEMBER"),
            new MemberDTO("13", "Marius Niklaus", "MEMBER"),
            new MemberDTO("14", "Patrick Grosschmidt", "MEMBER")
    ));

    @Override
    public Collection<MemberDTO> getMembers() {
        return members;
    }

    @Override
    public void createMember(CreateMemberDTO createMemberDTO) {
        members.add(new MemberDTO(UUID.randomUUID().toString(), createMemberDTO.getName(), createMemberDTO.getRole()));
    }

    @Override
    public void updateMember(MemberDTO memberDTO) throws NotFoundException {
        MemberDTO memberToReplace = this.getMember(memberDTO.getId());
        Collections.replaceAll(members, memberToReplace, memberDTO);
    }

    @Override
    public MemberDTO getMember(String id) {
        return members.stream()
                .filter(memberDTO -> memberDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Could not find member with id " + id));
    }

    @Override
    public void deleteMember(String id) {
        members.removeIf(memberDTO -> memberDTO.getId().equals(id));
    }
}
