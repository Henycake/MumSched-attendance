package edu.mum.mumsched.dao;

import edu.mum.mumsched.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BlockDao extends JpaRepository<Block, Long>  {
    Block findBlockById(long id);

    Block findBlockByblockName(String blockName);

    Block findBlockByStartDate(LocalDate startDate);

    void deleteBlockByBlockName(String blockName);
}
