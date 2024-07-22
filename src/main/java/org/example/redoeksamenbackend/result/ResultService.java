package org.example.redoeksamenbackend.result;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    private final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<ResultDTO> getResults() {
        return resultRepository.findAll().stream().map(this::toDTO).toList();
    }

    private ResultDTO toDTO(Result result) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setId(result.getId());
        resultDTO.setResultType(result.getResultType());
        resultDTO.setDate(result.getDate());
        return resultDTO;
    }

    public ResultDTO getResult(Long id) {
        return resultRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public ResultDTO createResult(ResultDTO resultDTO) {
        Result result = new Result();
        result.setResultType(resultDTO.getResultType());
        result.setDate(resultDTO.getDate());
        result.setResultValue(resultDTO.getResultValue());
        return toDTO(resultRepository.save(result));
    }

    public ResultDTO updateResult(Long id, ResultDTO resultDTO) {
        return resultRepository.findById(id).map(result -> {
            result.setResultType(resultDTO.getResultType());
            result.setDate(resultDTO.getDate());
            result.setResultValue(resultDTO.getResultValue());
            return toDTO(resultRepository.save(result));
        }).orElse(null);
    }

    public ResultDTO deleteResult(Long id) {
        return resultRepository.findById(id).map(result -> {
            resultRepository.delete(result);
            return toDTO(result);
        }).orElse(null);
    }
}
