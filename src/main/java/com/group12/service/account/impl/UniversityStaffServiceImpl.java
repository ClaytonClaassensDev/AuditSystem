package com.group12.service.account.impl;

import com.group12.entity.UniversityStaff;
import com.group12.repository.account.UniversityStaffRepository;
import com.group12.repository.account.impl.UniversityStaffRepositoryImpl;
import com.group12.service.account.UniversityStaffService;

import java.util.Set;

/**  Author: Limpho Ranamane
 *   Date: 01-09-2020
 *   Description: UniversityStaff service implementation responsible for providing service for repository on University Staff
 */
public class UniversityStaffServiceImpl implements com.group12.service.account.UniversityStaffService {

    private UniversityStaffRepository universityStaffRepository;
    private static com.group12.service.account.UniversityStaffService UniversityStaffService = null;

    private UniversityStaffServiceImpl() {
        this.universityStaffRepository = UniversityStaffRepositoryImpl.getUniversityStaffRepository(); //initializing UniversityStaffRepository
    }

    //singleton to only access and enforce a single entry to the UniversityStaffRepository
    //enforces only one instance of this class
    public static UniversityStaffService getUniversityStaffService(){
        if(UniversityStaffService ==null) UniversityStaffService =new UniversityStaffServiceImpl();
        return UniversityStaffService;
    }

    //the following methods interact with the repository layer (has access to the DB) and send requests to it and the repository layer responds to those requests
    @Override
    public UniversityStaff create(UniversityStaff t) {
        return this.universityStaffRepository.create(t);
    }

    @Override
    public UniversityStaff read(String s) {
        return this.universityStaffRepository.read(s);
    }

    @Override
    public UniversityStaff update(UniversityStaff t) {
        return this.universityStaffRepository.update(t);
    }

    @Override
    public boolean delete(String s) {
        return this.universityStaffRepository.delete(s);
    }

    @Override
    public Set<UniversityStaff> getAll() {
        return this.universityStaffRepository.getAll();
    }
}

