package ch.zuehlke.lambda.facilitator.service;

import ch.zuehlke.lambda.facilitator.dto.CreateRoomDTO;
import ch.zuehlke.lambda.facilitator.dto.RoomDTO;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoomServiceMock implements RoomService {

    private final List<RoomDTO> rooms = new ArrayList<>(List.of(
            new RoomDTO("1", "Multiplex 1", 20),
            new RoomDTO("2", "Toolbox 180", 10),
            new RoomDTO("3", "Bento 320", 8),
            new RoomDTO("4", "Piazza", 200)
    ));

    @Override
    public Collection<RoomDTO> getRooms() {
        return rooms;
    }

    @Override
    public RoomDTO getRoom(String id) throws NotFoundException {
        return rooms.stream()
                .filter(roomDTO -> roomDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Could not find room with id " + id));
    }

    @Override
    public void updateRoom(RoomDTO roomDTO) throws NotFoundException {
        RoomDTO roomToReplace = this.getRoom(roomDTO.getId());
        Collections.replaceAll(rooms, roomToReplace, roomDTO);
    }

    @Override
    public String createRoom(CreateRoomDTO createRoomDTO) {
        String uuid = UUID.randomUUID().toString();
        rooms.add(new RoomDTO(uuid, createRoomDTO.getName(), createRoomDTO.getCapacity()));
        return uuid;
    }

    @Override
    public void deleteRoom(String id) {
        rooms.removeIf(room -> room.getId().equals(id));
    }
}
