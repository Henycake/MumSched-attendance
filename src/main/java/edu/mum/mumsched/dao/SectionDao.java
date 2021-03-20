package edu.mum.mumsched.dao;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface SectionDao extends JpaRepository<Section,Long> {
    Section findSectionById(long id);
     Section findSectionBySectionName(String sectionName);

    Section findSectionByStartDate(LocalDate startDate);

    void deleteSectionBySectionName(String sectionName);
}
