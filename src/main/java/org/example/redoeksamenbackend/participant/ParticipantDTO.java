package org.example.redoeksamenbackend.participant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.redoeksamenbackend.discipline.Discipline;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ParticipantDTO {

    private Long id;
    private String name;
    private String gender;
    private int age;
    private String club;

    private List <Discipline> disciplines;
}
