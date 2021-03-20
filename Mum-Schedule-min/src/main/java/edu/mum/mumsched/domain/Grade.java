package edu.mum.mumsched.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private GradeLetter gradeLetter;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Section section;
}
