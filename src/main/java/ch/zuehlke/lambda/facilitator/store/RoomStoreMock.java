package ch.zuehlke.lambda.facilitator.store;

import ch.zuehlke.lambda.facilitator.domain.Room;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class RoomStoreMock implements RoomStore {

    static final List<Room> rooms = new ArrayList<>(List.of(
            new Room("1", "Multiplex 1", 20),
            new Room("2", "Toolbox 180", 10),
            new Room("3", "Bento 320", 8),
            new Room("4", "Piazza", 200)
    ));

    @Override
    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public Room getRoom(String id) throws NotFoundException {
        return rooms.stream()
                .filter(room -> room.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Could not find room with id " + id));
    }

    @Override
    public void updateRoom(Room room) throws NotFoundException {
        Room roomToReplace = this.getRoom(room.getId());
        Collections.replaceAll(rooms, roomToReplace, room);
    }

    @Override
    public void createRoom(Room newRoom) {
        rooms.add(newRoom);
    }

    @Override
    public void deleteRoom(String id) {
        rooms.removeIf(room -> room.getId().equals(id));
    }
}
