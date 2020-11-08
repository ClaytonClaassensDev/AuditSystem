package com.group12.service.account.impl;

import com.group12.entity.UniversityStaff;
import com.group12.repository.account.UniversityStaffRepository;
import com.group12.service.account.UniversityStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**  Author: Limpho Ranamane
 *   Date: 01-09-2020
 *   Description: UniversityStaff service implementation responsible for providing service for repository on University Staff
 */

@Service
public class UniversityStaffServiceImpl implements UniversityStaffService {
    @Autowired //enforces singleton
    private UniversityStaffRepository universityStaffRepository;

    @Override
    public UniversityStaff create(UniversityStaff t) {
        return this.universityStaffRepository.save(t);
    }

    @Override
    public UniversityStaff read(String s) {
        return this.universityStaffRepository.findById(s).orElseGet(null);
    }

    @Override
    public UniversityStaff update(UniversityStaff t) {
        return this.universityStaffRepository.save(t);
    }

    @Override
    public boolean delete(String s) {
        this.universityStaffRepository.deleteById(s);
        if(this.universityStaffRepository.existsById(s)) return false;
        else return true;
    }

    @Override
    public Set<UniversityStaff> getAll() {
        return this.universityStaffRepository.findAll().stream().collect(Collectors.toSet());
    }
}

