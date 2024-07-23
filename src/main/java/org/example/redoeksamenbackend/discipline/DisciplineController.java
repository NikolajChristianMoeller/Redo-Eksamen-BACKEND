package org.example.redoeksamenbackend.discipline;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {

    private final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping
    public ResponseEntity<List<DisciplineDTO>> getDisciplines() {
        return ResponseEntity.ok(disciplineService.getDisciplines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplineDTO> getDiscipline(@PathVariable Long id) {
        return ResponseEntity.ok(disciplineService.getDiscipline(id));
    }
}
