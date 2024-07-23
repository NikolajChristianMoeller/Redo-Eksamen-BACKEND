package org.example.redoeksamenbackend.result;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultService {
    ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<ResultDTO> getResults() {
        return resultRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private ResultDTO toDTO(Result result) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setId(result.getId());
        resultDTO.setDate(result.getDate());
        resultDTO.setResultValue(result.getResultValue());
        // Check if Discipline is null before accessing it
        if (result.getDiscipline() != null) {
            resultDTO.setResultType(result.getDiscipline().getResultType());
        } else {
            // Handle the case where Discipline is null
            resultDTO.setResultType("No Discipline"); // Or set to null, or any other placeholder value that makes sense for your application
        }
        return resultDTO;
    }

    public ResultDTO getResult(Long id) {
        return resultRepository.findById(id).map(this::toDTO).orElse(null);
    }
}
