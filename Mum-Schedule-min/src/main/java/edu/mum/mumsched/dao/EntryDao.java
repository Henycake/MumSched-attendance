package edu.mum.mumsched.dao;

import edu.mum.mumsched.domain.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryDao extends JpaRepository<Entry, Long>{
    Entry findEntryById(Long id);

    Entry findEntryByEntryName(String name);
}
