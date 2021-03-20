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
    private String lastName;
    private String email;
    private String studentId;
    private String stType;
    private String stEntry;
    private  StudentType studentType;
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="entryID", nullable = true)
    private Entry entry;
    @OneToMany
    private List<Grade> grades = new ArrayList<>();




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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStType() {
        return stType;
    }

    public void setStType(String stType) {
        this.stType = stType;
    }

    public String getStEntry() {
        return stEntry;
    }

    public void setStEntry(String stEntry) {
        this.stEntry = stEntry;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public StudentType getStudentType() {
        return studentType;
    }

    public void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", studentId='" + studentId + '\'' +
                ", stType='" + stType + '\'' +
                ", stEntry='" + stEntry + '\'' +
                ", studentType=" + studentType +
                ", entry=" + entry +
                ", grades=" + grades +
                ", address=" + address +
                ", sections=" + sections +
                '}';
    }
}
