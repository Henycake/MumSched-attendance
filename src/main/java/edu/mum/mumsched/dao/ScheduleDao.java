package edu.mum.mumsched.dao;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ScheduleDao extends JpaRepository<Schedule, Long>  {
    Schedule findScheduleById(long id);

    Schedule findScheduleByEntryName(String entryName);


    void deleteScheduleByEntryName(String entryName);
}
