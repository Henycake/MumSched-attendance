package edu.mum.mumsched.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

  //  @NotEmpty
    // private ScheduleStatus status;
    private ScheduleStatus scheduleStatus;
    private String status;
    private String entryName;
    private String blockName;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "schedule")
    private List<Block> blockList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.REMOVE)//(mappedBy = "schedule")
    private Entry entry;

    public void addBlock(Block block){
        blockList.add(block);
    }





}
