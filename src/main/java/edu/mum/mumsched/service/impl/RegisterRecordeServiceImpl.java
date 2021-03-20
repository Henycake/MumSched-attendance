package edu.mum.mumsched.service.impl;

import edu.mum.mumsched.dao.RegisterRecordeDao;
import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.RegisterRecorde;
import edu.mum.mumsched.service.RegisterRecordeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterRecordeServiceImpl implements RegisterRecordeService {
    @Autowired
    RegisterRecordeDao registerRecordeDao;

    @Override
    public void save(RegisterRecorde registerRecorde) {
       registerRecordeDao.save(registerRecorde);
    }

    @Override
    public RegisterRecorde getRegisterRecordeById(long id) {
        return registerRecordeDao.findRegisterRecordeById(id);
    }

    @Override
    public void deleteRegisterRecordeById(Long id) {
             registerRecordeDao.deleteById(id);
    }
}
