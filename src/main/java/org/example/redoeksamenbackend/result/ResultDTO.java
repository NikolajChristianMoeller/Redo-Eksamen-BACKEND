package org.example.redoeksamenbackend.result;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.redoeksamenbackend.discipline.DisciplineDTO;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ResultDTO {

    private Long id;
    private LocalDate date;
    private Double resultValue;
    private String resultType;
}
