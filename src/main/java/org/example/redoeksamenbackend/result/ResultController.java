package org.example.redoeksamenbackend.result;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {
    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping
    public ResponseEntity<List<ResultDTO>> getResults() {
        return ResponseEntity.ok(resultService.getResults());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultDTO> getResult(@PathVariable Long id) {
        return ResponseEntity.ok(resultService.getResult(id));
    }

    @PostMapping
    public ResponseEntity<ResultDTO> createResult(@RequestBody ResultDTO resultDTO) {
        return ResponseEntity.ok(resultService.createResult(resultDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultDTO> updateResult(@PathVariable Long id, @RequestBody ResultDTO resultDTO) {
        return ResponseEntity.ok(resultService.updateResult(id, resultDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResultDTO> deleteResult(@PathVariable Long id) {
        return ResponseEntity.ok(resultService.deleteResult(id));
    }
}
