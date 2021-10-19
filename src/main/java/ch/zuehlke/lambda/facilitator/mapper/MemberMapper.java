package ch.zuehlke.lambda.facilitator.mapper;

import ch.zuehlke.lambda.facilitator.domain.Member;
import ch.zuehlke.lambda.facilitator.domain.Role;
import ch.zuehlke.lambda.facilitator.dto.CreateMemberDTO;
import ch.zuehlke.lambda.facilitator.dto.MemberDTO;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class MemberMapper {
    public static Collection<MemberDTO> map(Collection<Member> members) {
        return members.stream()
                .map(MemberMapper::map)
                .collect(Collectors.toList());
    }

    public static MemberDTO map(Member member) {
        return MemberDTO.builder().id(member.getId())
                .name(member.getName())
                .role(member.getRole().toString())
                .build();
    }

    public static Member map(CreateMemberDTO createMemberDTO) {
        MemberDTO memberDTO = MemberDTO.builder().id(UUID.randomUUID().toString())
                .name(createMemberDTO.getName())
                .role(createMemberDTO.getRole())
                .build();

        return MemberMapper.map(memberDTO);
    }

    public static Member map(MemberDTO memberDTO) {
        return Member.builder().id(memberDTO.getId())
                .name(memberDTO.getName())
                .role(Role.fromString(memberDTO.getRole()))
                .build();

    }
}
