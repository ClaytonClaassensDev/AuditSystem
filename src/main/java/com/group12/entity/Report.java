package com.group12.entity;

import java.time.LocalDate;

/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Entity for report
 * Date: 3 July 2020
 */

public class Report
{
    private String reportId;
    private String reportAuth;
    private LocalDate reportDate;

    public Report() {
    }

    private Report(Builder builder)
    {
        this.reportId = builder.reportId;
        this.reportAuth = builder.reportAuth;
        this.reportDate = builder.reportDate;
    }

    public String getReportId() {
        return reportId;
    }

    public String getReportAuth() {
        return reportAuth;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportID=" + reportId +
                ", reportAuth='" + reportAuth + '\'' +
                ", reportDate=" + reportDate +
                '}';
    }

    public static class Builder
    {
        private String reportId;
        private String reportAuth;
        private LocalDate reportDate;

        public Builder setReportId(String reportId)
        {
            this.reportId = reportId;
            return this;
        }

        public Builder setReportAuth(String reportAuth)
        {
            this.reportAuth = reportAuth;
            return this;
        }

        public Builder setReportDate(LocalDate reportDate)
        {
            this.reportDate = reportDate;
            return this;
        }

        public Builder copy(Report report)
        {
            this.reportId = report.reportId;
            this.reportAuth = report.reportAuth;
            this.reportDate = report.reportDate;
            return this;
        }

        public Report build()
        {
            return new Report(this);
        }
    }
}
