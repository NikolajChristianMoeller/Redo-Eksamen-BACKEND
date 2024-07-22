package org.example.redoeksamenbackend.discipline;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DisciplineDTO {

    private Long id;
    private String name;
    private String resultType;
}
