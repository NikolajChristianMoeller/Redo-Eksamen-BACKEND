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
}
