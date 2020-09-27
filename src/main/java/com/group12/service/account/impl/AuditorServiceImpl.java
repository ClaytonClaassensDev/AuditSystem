package com.group12.service.account.impl;

import com.group12.entity.Auditor;
import com.group12.repository.account.AuditorRepository;
import com.group12.repository.account.impl.AuditorRepositoryImpl;
import com.group12.service.account.AuditorService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**  Author: Limpho Ranamane
 *   Date: 01-09-2020
 *   Description: Auditor service implementation responsible for providing service for repository on Auditor
 */

@Service //acts as a service over the internet
public class AuditorServiceImpl implements AuditorService {

    private AuditorRepository auditorRepository;
    private static AuditorService auditorService = null;

    private AuditorServiceImpl() {
        this.auditorRepository = AuditorRepositoryImpl.getAuditorRepository(); //initializing AuditorRepository
    }

    //singleton to only access and enforce a single entry to the AuditorRepository
    //enforces only one instance of this class
    public static AuditorService getAuditorService(){
        if(auditorService ==null) auditorService =new AuditorServiceImpl();
        return auditorService;
    }

    //the following methods interact with the repository layer (has access to the DB) and send requests to it and the repository layer responds to those requests

    @Override
    public Auditor create(Auditor t) {
        return this.auditorRepository.create(t);
    }

    @Override
    public Auditor read(String s) {
        return this.auditorRepository.read(s);
    }

    @Override
    public Auditor update(Auditor t) {
        return this.auditorRepository.update(t);
    }

    @Override
    public boolean delete(String s) {
        return this.auditorRepository.delete(s);
    }

    @Override
    public Set<Auditor> getAll() {
        return this.auditorRepository.getAll();
    }
}
