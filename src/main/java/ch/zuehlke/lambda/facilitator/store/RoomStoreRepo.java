package ch.zuehlke.lambda.facilitator.store;

import ch.zuehlke.lambda.facilitator.domain.Room;
import ch.zuehlke.lambda.facilitator.exception.BadRequestException;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import ch.zuehlke.lambda.facilitator.repository.RoomRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@Profile(value = "!dev")
public class RoomStoreRepo implements RoomStore {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomStoreRepo(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Collection<Room> getRooms() {
        return IteratorUtils.toList(roomRepository.findAll().iterator());
    }

    @Override
    public Room getRoom(String id) throws NotFoundException {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isEmpty()) {
            throw new NotFoundException("Could not find room with id " + id);
        }

        return roomOptional.get();
    }

    @Override
    public void updateRoom(Room room) throws NotFoundException {
        roomRepository.save(room);
    }

    @Override
    public void createRoom(Room newRoom) {
        roomRepository.save(newRoom);
    }

    @Override
    public void deleteRoom(String id) {
        try {
            roomRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Could not delete room with id " + id);
        }
    }
}
