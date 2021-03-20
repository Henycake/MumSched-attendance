package edu.mum.mumsched.domain;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Entry")
public class Entry {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Enumerated(EnumType.ORDINAL)
//    private EntryType entryType;
//    @OneToMany(mappedBy = "entry")
//    private List<Student> students=new ArrayList<>();
//
    @Id
    @Column(name = "entryid")
//@GeneratedValue(strategy= GenerationType.AUTO ,generator = "native")
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    @NonNull
    @Column(name="entryName")
    private String  entryName;

    @Column(name="fppNum")
    private int fppNum;

    @Column(name="mppNum")
    private int mppNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="startDate")
    private LocalDate StartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="endDate")
    private LocalDate EndDate;
    @Column(name="entryType")
    private EntryType entryType;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="entry")
    private List<Student> students = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "entry")
    private List<Block>blocks = new ArrayList<>();

    @OneToOne()
    private Schedule schedule;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntryName() {
        return entryName;
    }

    public int getFppNum() {
        return fppNum;
    }

    public void setFppNum(int fppNum) {
        this.fppNum = fppNum;
    }

    public int getMppNum() {
        return mppNum;
    }

    public void setMppNum(int mppNum) {
        this.mppNum = mppNum;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalDate endDate) {
        EndDate = endDate;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public EntryType getEntryType() {
        return entryType;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "entryName='" + entryName + '\'' +
                ", fppNum=" + fppNum +
                ", mppNum=" + mppNum +
                ", StartDate=" + StartDate +
                ", EndDate=" + EndDate +
                ", entryType=" + entryType +
                '}';
    }
}