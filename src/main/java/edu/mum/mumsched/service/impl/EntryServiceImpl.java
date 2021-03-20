package edu.mum.mumsched.service.impl;

import edu.mum.mumsched.dao.EntryDao;
import edu.mum.mumsched.domain.Entry;
import edu.mum.mumsched.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryServiceImpl implements EntryService {
    @Autowired
    EntryDao entryDao;
    @Override
    public List<Entry> getAllEntries() {
        return entryDao.findAll();
    }

    @Override
    public void CreateEntry(Entry entry) {
         entryDao.save(entry);

    }

    @Override
    public void deleteEntry(Long id) {
        entryDao.deleteById(id);

    }

    @Override
    public Entry findByEntryId(Long id) {
        return entryDao.findEntryById(id);
    }

    @Override
    public Entry findEntryByName(String entryName) {
        return entryDao.findEntryByEntryName(entryName);
    }
}
