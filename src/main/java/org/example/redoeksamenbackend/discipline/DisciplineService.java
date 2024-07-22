package org.example.redoeksamenbackend.discipline;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {
    private final DisciplineRepository disciplineRepository;

    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }
    
    public List<DisciplineDTO> getDisciplines() {
        return disciplineRepository.findAll().stream().map(this::toDTO).toList();
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

    public DisciplineDTO createDiscipline(DisciplineDTO disciplineDTO) {
        Discipline discipline = new Discipline();
        discipline.setName(disciplineDTO.getName());
        discipline.setResultType(disciplineDTO.getResultType());
        return toDTO(disciplineRepository.save(discipline));
    }


    public DisciplineDTO updateDiscipline(Long id, DisciplineDTO disciplineDTO) {
        return disciplineRepository.findById(id).map(discipline -> {
            discipline.setName(disciplineDTO.getName());
            discipline.setResultType(disciplineDTO.getResultType());
            return toDTO(disciplineRepository.save(discipline));
        }).orElse(null);
    }

    public DisciplineDTO deleteDiscipline(Long id) {
        return disciplineRepository.findById(id).map(discipline -> {
            disciplineRepository.delete(discipline);
            return toDTO(discipline);
        }).orElse(null);
    }
}
