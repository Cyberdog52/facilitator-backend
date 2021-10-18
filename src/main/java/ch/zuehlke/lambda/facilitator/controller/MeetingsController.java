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

    @PutMapping
    public void updateMeeting(@RequestBody MeetingDTO meetingDTO) {
        this.meetingService.updateMeeting(meetingDTO);
    }

    @PostMapping
    public String createMeeting(@RequestBody CreateMeetingDTO createMeetingDTO) {
        return this.meetingService.createMeeting(createMeetingDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMeeting(@PathVariable String id) {
        this.meetingService.deleteMeeting(id);
    }

}
