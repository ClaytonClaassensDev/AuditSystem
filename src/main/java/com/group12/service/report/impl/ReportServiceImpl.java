package com.group12.service.report.impl;

import com.group12.entity.Report;
import com.group12.repository.report.ReportRepository;
import com.group12.repository.report.impl.ReportRepositoryImpl;
import com.group12.service.report.ReportService;

import java.util.Set;
/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Service Implementation for report
 * Date: 28 August 2020
 */
public class ReportServiceImpl implements ReportService
{

    private static ReportService service = null;
    private ReportRepository repository;

    private ReportServiceImpl()
    {
        this.repository = ReportRepositoryImpl.getRepository();
    }

    public static ReportService getService()
    {
        if (service == null) service = new ReportServiceImpl();
        return service;
    }

    @Override
    public Report create(Report report)
    {
        return this.repository.create(report);
    }

    @Override
    public Report read(String id)
    {
        return this.repository.read(id);
    }

    @Override
    public Report update(Report report)
    {
        return this.repository.update(report);
    }

    @Override
    public boolean delete(String id)
    {
        return this.repository.delete(id);
    }

    @Override
    public Set<Report> getAll()
    {
        return this.repository.getAll();
    }
}
