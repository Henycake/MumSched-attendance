package edu.mum.mumsched.service;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Schedule;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {
    public Schedule save(Schedule schedule);
    public Schedule getScheduleById( long id);
    public List<Schedule> getAllSchedules();

    public void deleteScheduleById(Long id);
    public void deleteScheduleByEntryName(String entryName);

}
