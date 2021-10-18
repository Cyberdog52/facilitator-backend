package ch.zuehlke.lambda.facilitator.service;

import ch.zuehlke.lambda.facilitator.dto.CreateRoomDTO;
import ch.zuehlke.lambda.facilitator.dto.RoomDTO;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface RoomService {

    Collection<RoomDTO> getRooms();

    RoomDTO getRoom(String id) throws NotFoundException;

    void updateRoom(RoomDTO roomDTO) throws NotFoundException;

    String createRoom(CreateRoomDTO createRoomDTO);

    void deleteRoom(String id);
}
