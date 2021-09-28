package ch.zuehlke.lambda.facilitator.controller;

import ch.zuehlke.lambda.facilitator.dto.CreateMeetingDTO;
import ch.zuehlke.lambda.facilitator.dto.MeetingDTO;
import ch.zuehlke.lambda.facilitator.exception.BadRequestException;
import ch.zuehlke.lambda.facilitator.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/meetings")
public class MeetingsController {

    private final MeetingService meetingService;

    @Autowired
    public MeetingsController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping
    public Collection<MeetingDTO> getMeetings() {
        return this.meetingService.getMeetings();
    }

    @GetMapping("/{id}")
    public MeetingDTO getMeeting(@PathVariable String id) {
        return this.meetingService.getMeeting(id);
    }

    @PutMapping("/{id}")
    public void updateMeeting(@PathVariable String id, @RequestBody MeetingDTO meetingDTO) {
        if (!meetingDTO.getId().equals(id)) {
            throw new BadRequestException("The id " + id + " does not match the updated meetingDTO");
        }

        this.meetingService.updateMeeting(meetingDTO);
    }

    @PostMapping
    public void createMeeting(@RequestBody CreateMeetingDTO createMeetingDTO) {
        this.meetingService.createMeeting(createMeetingDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMeeting(@PathVariable String id) {
        this.meetingService.deleteMeeting(id);
    }

}
