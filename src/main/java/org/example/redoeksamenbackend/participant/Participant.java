package org.example.redoeksamenbackend.participant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.redoeksamenbackend.discipline.Discipline;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private int age;
    private String club;

    @ManyToMany(fetch = FetchType.EAGER)
    private List <Discipline> disciplines = new ArrayList<>();

}
