package ch.zuehlke.lambda.facilitator.controller;

import ch.zuehlke.lambda.facilitator.dto.CreateRoomDTO;
import ch.zuehlke.lambda.facilitator.dto.RoomDTO;
import ch.zuehlke.lambda.facilitator.exception.BadRequestException;
import ch.zuehlke.lambda.facilitator.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/rooms")
public class RoomsController {

    private final RoomService roomService;

    @Autowired
    public RoomsController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public Collection<RoomDTO> getRooms() {
        return this.roomService.getRooms();
    }

    @GetMapping("/{id}")
    public RoomDTO getRoom(@PathVariable String id) {
        return this.roomService.getRoom(id);
    }

    @PutMapping("/{id}")
    public void updateRoom(@PathVariable String id, @RequestBody RoomDTO roomDTO) {
        if (!roomDTO.getId().equals(id)) {
            throw new BadRequestException("The id " + id + " does not match the updated roomDTO");
        }

        this.roomService.updateRoom(roomDTO);
    }

    @PostMapping
    public String createRoom(@RequestBody CreateRoomDTO createRoomDTO) {
        return this.roomService.createRoom(createRoomDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable String id) {
        this.roomService.deleteRoom(id);
    }

}
