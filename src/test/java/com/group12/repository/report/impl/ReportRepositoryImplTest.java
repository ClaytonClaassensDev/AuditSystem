package com.group12.repository.report.impl;

import com.group12.entity.Report;
import com.group12.factory.ReportFactory;
import com.group12.repository.report.ReportRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Repository Implementation Test for report
 * Date: 24 August 2020
 */
public class ReportRepositoryImplTest
{
    private static ReportRepository repository = ReportRepositoryImpl.getRepository();
    private static Report report = ReportFactory.createReport("Brian");

    // This test checks if a report object was added to the repository
    @Test
    public void a_create()
    {
        Report created = repository.create(report);
        assertEquals(report.getReportId(), created.getReportId());
        System.out.println("Created: " + created);
    }

    // This test checks if the specified report is found and displays it
    @Test
    public void b_read()
    {
        Report read = repository.read(report.getReportId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    // This test checks if the name of the person who generated the report has been changed
    @Test
    public void c_update()
    {
        Report updated = new Report.Builder()
                .copy(report).setReportAuth("Rebecca")
                .build();
        updated = repository.update(updated);
        assertEquals("Rebecca", repository.read(report.getReportId()).getReportAuth());
        System.out.println("Updated: " + updated);
    }

    // This test checks if a specified report in the repository is deleted using an ID
    @Test
    public void e_delete()
    {
        boolean deleted = repository.delete(report.getReportId());
        assertTrue(deleted);
    }

    // This test checks to see if all the reports in the repository are returned
    @Test
    public void d_getAll()
    {
        System.out.println("All Reports: " + repository.getAll());
        assertEquals(1, repository.getAll().size());
    }
}