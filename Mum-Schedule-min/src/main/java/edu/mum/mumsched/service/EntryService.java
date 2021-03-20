package edu.mum.mumsched.service;

import edu.mum.mumsched.domain.Entry;

import java.util.List;

public interface EntryService {
    List<Entry> getAllEntries();

    public void create(Entry entry);

    void deleteEntry(Long id);

    Entry findByEntryId(Long id);

    Entry findEntryByName(String entryName);
}
