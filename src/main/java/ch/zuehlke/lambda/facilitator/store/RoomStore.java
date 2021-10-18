package ch.zuehlke.lambda.facilitator.store;

import ch.zuehlke.lambda.facilitator.domain.Room;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;

import java.util.Collection;

public interface RoomStore {

    Collection<Room> getRooms();

    Room getRoom(String id) throws NotFoundException;

    void updateRoom(Room room) throws NotFoundException;

    void createRoom(Room newRoom);

    void deleteRoom(String id);
}
