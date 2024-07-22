package org.example.redoeksamenbackend.result;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.redoeksamenbackend.discipline.Discipline;
import org.example.redoeksamenbackend.participant.Participant;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDate date;
    private Double resultValue;

    @ManyToOne
    private Participant participant;

    @ManyToOne
    private Discipline discipline;

}
