package edu.mum.mumsched.service.impl;

import edu.mum.mumsched.dao.ScheduleDao;
import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Schedule;
import edu.mum.mumsched.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleDao scheduleDao;


    @Override
    public Schedule save(Schedule schedule) {
        return scheduleDao.save(schedule);
    }

    @Override
    public Schedule getScheduleById(long id) {
        return scheduleDao.findScheduleById(id);
    }

    @Override
    public List<Schedule> getAllSchedules() {
       return scheduleDao.findAll();
    }

    @Override
    public void deleteScheduleById(Long id) {
            scheduleDao.deleteById(id);
    }

    @Override
    public void deleteScheduleByEntryName(String entryName) {
      scheduleDao.deleteScheduleByEntryName(entryName);
    }
}
