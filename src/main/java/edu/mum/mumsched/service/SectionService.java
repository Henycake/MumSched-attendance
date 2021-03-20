package edu.mum.mumsched.service;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Section;

import java.time.LocalDate;
import java.util.List;

public interface SectionService {
    public Section save(Section section);
    public Section getSectionById( long id);
    public List<Section> getAllSection();
    public Section getSectionBySectionName(String sectionName);
    public Section getSectionByStartDate(LocalDate startDate);
    public void deleteSectionById(Long id);
    public void deleteSectionByName(String sectionName);

}
