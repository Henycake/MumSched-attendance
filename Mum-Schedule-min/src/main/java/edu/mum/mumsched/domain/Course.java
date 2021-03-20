package edu.mum.mumsched.domain;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String courseCode;
    private String courseTitle;
    private int credits;
    @Digits(integer=10, fraction=0, message = "{invalidNumber.message}")
    private int maxStudent;

    @ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    //@OneToMany(fetch = FetchType.LAZY)
    private List<Course> prerequisites = new ArrayList<>();
    @OneToMany(mappedBy="course")
    private List<Section> sections;
    @Digits(integer=10, fraction=0, message = "{invalidNumber.message}")
    private int level;
    public Boolean hasPreRequisite() {
        return this.prerequisites != null;
    }


    //    private Integer maxNumber;
//    private Integer minNumber;
//    @ManyToMany
//    private List<Faculty> faculties=new ArrayList<>();
//    @ManyToMany(mappedBy = "courses")
//    private List<Block> blocks=new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getMaxStudent() {
        return maxStudent;
    }

    public void setMaxStudent(int maxStudent) {
        this.maxStudent = maxStudent;
    }

    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
