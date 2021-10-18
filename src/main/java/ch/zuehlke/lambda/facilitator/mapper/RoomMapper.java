package ch.zuehlke.lambda.facilitator.mapper;

import ch.zuehlke.lambda.facilitator.domain.Room;
import ch.zuehlke.lambda.facilitator.dto.CreateRoomDTO;
import ch.zuehlke.lambda.facilitator.dto.RoomDTO;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class RoomMapper {

    public static RoomDTO map(Room room) {
        return RoomDTO.builder()
                .id(room.getId())
                .name(room.getName())
                .capacity(room.getCapacity())
                .build();
    }

    public static Collection<RoomDTO> map(Collection<Room> rooms) {
        return rooms.stream()
                .map(RoomMapper::map)
                .collect(Collectors.toList());
    }

    public static Room map(RoomDTO roomDTO) {
        return Room.builder()
                .id(roomDTO.getId())
                .name(roomDTO.getName())
                .capacity(roomDTO.getCapacity())
                .build();
    }

    public static Room map(CreateRoomDTO createRoomDTO) {
        RoomDTO roomDTO = RoomDTO.builder().id(UUID.randomUUID().toString())
                .name(createRoomDTO.getName())
                .capacity(createRoomDTO.getCapacity())
                .build();
        return RoomMapper.map(roomDTO);
    }
}
