package org.example.redoeksamenbackend.participant;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public List<ParticipantDTO> getParticipants() {
        return participantRepository.findAll().stream().map(this::toDTO).toList();
    }

    private ParticipantDTO toDTO(Participant participant) {
        ParticipantDTO participantDTO = new ParticipantDTO();
        participantDTO.setId(participant.getId());
        participantDTO.setName(participant.getName());
        participantDTO.setGender(participant.getGender());
        participantDTO.setAge(participant.getAge());
        participantDTO.setClub(participant.getClub());
        participantDTO.setDisciplines(participant.getDisciplines());
        return participantDTO;
    }

    public ParticipantDTO getParticipant(Long id) {
        return participantRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public ParticipantDTO createParticipant(ParticipantDTO participantDTO) {
        Participant participant = new Participant();
        participant.setName(participantDTO.getName());
        participant.setGender(participantDTO.getGender());
        participant.setAge(participantDTO.getAge());
        participant.setClub(participantDTO.getClub());
        participant.setDisciplines(participantDTO.getDisciplines());
        return toDTO(participantRepository.save(participant));
    }

    public ParticipantDTO updateParticipant(Long id, ParticipantDTO participantDTO) {
        return participantRepository.findById(id).map(participant -> {
            participant.setName(participantDTO.getName());
            participant.setGender(participantDTO.getGender());
            participant.setAge(participantDTO.getAge());
            participant.setClub(participantDTO.getClub());
            participant.setDisciplines(participantDTO.getDisciplines());
            return toDTO(participantRepository.save(participant));
        }).orElse(null);
    }

    public ParticipantDTO deleteParticipant(Long id) {
        return participantRepository.findById(id).map(participant -> {
            participantRepository.delete(participant);
            return toDTO(participant);
        }).orElse(null);
    }
}
