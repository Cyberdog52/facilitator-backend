package ch.zuehlke.lambda.facilitator.controller;

import ch.zuehlke.lambda.facilitator.dto.CreateMemberDTO;
import ch.zuehlke.lambda.facilitator.dto.MemberDTO;
import ch.zuehlke.lambda.facilitator.exception.BadRequestException;
import ch.zuehlke.lambda.facilitator.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/members")
public class MembersController {

    private final MemberService memberService;

    @Autowired
    public MembersController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public Collection<MemberDTO> getMembers() {
        return this.memberService.getMembers();
    }

    @GetMapping("/{id}")
    public MemberDTO getMember(@PathVariable String id) {
        return this.memberService.getMember(id);
    }

    @PutMapping("/{id}")
    public void updateMember(@RequestBody MemberDTO memberDTO) {
        this.memberService.updateMember(memberDTO);
    }

    @PostMapping
    public void createMember(@RequestBody CreateMemberDTO createMemberDTO) {
        this.memberService.createMember(createMemberDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable String id) {
        this.memberService.deleteMember(id);
    }
}
