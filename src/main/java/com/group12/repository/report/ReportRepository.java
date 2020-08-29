package com.group12.repository.report;

import com.group12.entity.Report;
import com.group12.repository.IRepository;

import java.util.Set;
/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Repository Implementation for report
 * Date: 24 August 2020
 */
public interface ReportRepository extends IRepository<Report, String>
{
    Set<Report> getAll();
}
