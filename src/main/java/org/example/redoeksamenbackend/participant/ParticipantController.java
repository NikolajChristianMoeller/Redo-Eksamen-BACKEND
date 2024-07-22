package org.example.redoeksamenbackend.participant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping
    public ResponseEntity<List<ParticipantDTO>> getParticipants() {
        return ResponseEntity.ok(participantService.getParticipants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipantDTO> getParticipant(@PathVariable Long id) {
        return ResponseEntity.ok(participantService.getParticipant(id));
    }

    @PostMapping
    public ResponseEntity<ParticipantDTO> createParticipant(@RequestBody ParticipantDTO participantDTO) {
        return ResponseEntity.ok(participantService.createParticipant(participantDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipantDTO> updateParticipant(@PathVariable Long id, @RequestBody ParticipantDTO participantDTO) {
        return ResponseEntity.ok(participantService.updateParticipant(id, participantDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ParticipantDTO> deleteParticipant(@PathVariable Long id) {
        return ResponseEntity.ok(participantService.deleteParticipant(id));
    }

}
