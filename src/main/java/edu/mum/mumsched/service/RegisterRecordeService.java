package edu.mum.mumsched.service;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.RegisterRecorde;

import java.time.LocalDate;
import java.util.List;

public interface RegisterRecordeService {
    public void  save(RegisterRecorde registerRecorde);
    public RegisterRecorde getRegisterRecordeById( long id);

    public void deleteRegisterRecordeById(Long id);


}
