package ch.zuehlke.lambda.facilitator.service;

import ch.zuehlke.lambda.facilitator.domain.Room;
import ch.zuehlke.lambda.facilitator.dto.CreateRoomDTO;
import ch.zuehlke.lambda.facilitator.dto.RoomDTO;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import ch.zuehlke.lambda.facilitator.mapper.RoomMapper;
import ch.zuehlke.lambda.facilitator.store.RoomStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomStore roomStore;

    @Autowired
    public RoomServiceImpl(RoomStore roomStore) {
        this.roomStore = roomStore;
    }

    @Override
    public Collection<RoomDTO> getRooms() {
        Collection<Room> rooms = roomStore.getRooms();
        return RoomMapper.map(rooms);
    }

    @Override
    public RoomDTO getRoom(String id) throws NotFoundException {
        Room room = roomStore.getRoom(id);
        return RoomMapper.map(room);
    }

    @Override
    public void updateRoom(RoomDTO roomDTO) throws NotFoundException {
        Room room = RoomMapper.map(roomDTO);
        roomStore.updateRoom(room);
    }

    @Override
    public String createRoom(CreateRoomDTO createRoomDTO) {
        Room newRoom = RoomMapper.map(createRoomDTO);
        roomStore.createRoom(newRoom);
        return newRoom.getId();
    }

    @Override
    public void deleteRoom(String id) {
        roomStore.deleteRoom(id);
    }
}
