package edu.mum.mumsched.service.impl;

import edu.mum.mumsched.dao.SectionDao;
import edu.mum.mumsched.domain.Section;
import edu.mum.mumsched.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    SectionDao sectionDao;

    @Override
    public Section save(Section section) {

        return sectionDao.save(section);
    }

    @Override
    public Section getSectionById(long id) {
        return sectionDao.findSectionById(id);
    }

    @Override
    public List<Section> getAllSection() {
        return sectionDao.findAll();
    }

    @Override
    public Section getSectionBySectionName(String sectionName) {
        return sectionDao.findSectionBySectionName(sectionName);
    }

    @Override
    public Section getSectionByStartDate(LocalDate startDate) {
        return sectionDao.findSectionByStartDate(startDate);
    }

    @Override
    public void deleteSectionById(Long id) {
             sectionDao.deleteById(id);
    }

    @Override
    public void deleteSectionByName(String sectionName) {
             sectionDao.deleteSectionBySectionName(sectionName);
    }
}
