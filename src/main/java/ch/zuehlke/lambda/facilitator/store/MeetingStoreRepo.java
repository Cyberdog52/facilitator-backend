package ch.zuehlke.lambda.facilitator.store;

import ch.zuehlke.lambda.facilitator.domain.Meeting;
import ch.zuehlke.lambda.facilitator.exception.BadRequestException;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import ch.zuehlke.lambda.facilitator.repository.MeetingRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@Profile(value = "!dev")
public class MeetingStoreRepo implements MeetingStore {

    private final MeetingRepository meetingRepository;

    @Autowired
    public MeetingStoreRepo(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @Override
    public Collection<Meeting> getMeetings() {
        return IteratorUtils.toList(meetingRepository.findAll().iterator());
    }

    @Override
    public void createMeeting(Meeting newMeeting) {
        meetingRepository.save(newMeeting);
    }

    @Override
    public void updateMeeting(Meeting meeting) throws NotFoundException {
        meetingRepository.save(meeting);
    }

    @Override
    public Meeting getMeeting(String id) throws NotFoundException {
        Optional<Meeting> meetingOptional = meetingRepository.findById(id);
        if (meetingOptional.isEmpty()) {
            throw new NotFoundException("Could not find meeting with id " + id);
        }

        return meetingOptional.get();
    }

    @Override
    public void deleteMeeting(String id) {
        try {
            meetingRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Could not delete meeting with id " + id);
        }
    }
}
