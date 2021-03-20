package edu.mum.mumsched.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String firstName;
    private String LastName;
    private String email;
    private String studentId;
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="entryID", nullable = true)
    private Entry entry;
    @OneToMany
    private List<Grade> grades = new ArrayList<>();
    private  StudentType studentType;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @ManyToMany(
            fetch=FetchType.LAZY
    )
    @JoinTable(
            name="section_students",
            joinColumns={@JoinColumn(name="student_id")},
            inverseJoinColumns={@JoinColumn(name="section_id")}
    )
    private List<Section> sections = new ArrayList<>();

    public void addSection(Section section){
        this.sections.add(section);
    }



}
