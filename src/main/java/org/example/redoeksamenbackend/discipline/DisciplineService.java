package org.example.redoeksamenbackend.discipline;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplineService {
    DisciplineRepository disciplineRepository;

    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }
    
    public List<DisciplineDTO> getDisciplines() {
        return disciplineRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private DisciplineDTO toDTO(Discipline discipline) {
        DisciplineDTO disciplineDTO = new DisciplineDTO();
        disciplineDTO.setId(discipline.getId());
        disciplineDTO.setName(discipline.getName());
        disciplineDTO.setResultType(discipline.getResultType());
        return disciplineDTO;
    }

    public DisciplineDTO getDiscipline(Long id) {
        return disciplineRepository.findById(id).map(this::toDTO).orElse(null);
    }
}
