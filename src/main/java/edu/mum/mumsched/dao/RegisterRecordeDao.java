package edu.mum.mumsched.dao;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.RegisterRecorde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RegisterRecordeDao extends JpaRepository<RegisterRecorde, Long>  {
    RegisterRecorde findRegisterRecordeById(long id);


}
