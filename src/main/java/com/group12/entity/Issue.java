package com.group12.entity;

import java.time.LocalDateTime;

/**
 * @author: Clayton Claassens
 * @desc: entity.Issue Entity --> Builder Pattern
 */
public class Issue{

    private final String issueID;
    private final LocalDateTime issueRaisedDate;
    private String issueArea;
    private String issueStatus;
    private final String issueDescription;
    private LocalDateTime issueResolvedDate;
    private boolean isResolved;

    private Issue(Builder builder){

        this.issueID = builder.issueID;
        this.issueRaisedDate = builder.issueRaisedDate;
        this.issueArea = builder.issueArea;
        this.issueDescription = builder.issueDescription;
        this.issueStatus = builder.issueStatus;
    }

    public String getIssueID() {
        return issueID;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public String getIssueArea() {
        return issueArea;
    }

    public LocalDateTime getIssueRaisedDate() {
        return issueRaisedDate;
    }

    public LocalDateTime getIssueResolvedDate(){
        return issueResolvedDate;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public boolean isResolved() {
        return isResolved;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueID='" + issueID + '\'' +
                ", issueRaisedDate=" + issueRaisedDate +
                ", issueArea='" + issueArea + '\'' +
                ", issueStatus='" + issueStatus + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", issueResolvedDate=" + issueResolvedDate +
                ", isResolved=" + isResolved +
                '}';
    }


    public static class Builder {

        private String issueID;
        private LocalDateTime issueRaisedDate;
        private LocalDateTime issueResolvedDate;
        private String issueArea;
        private String issueDescription;
        private String issueStatus;
        private boolean isResolved;


        public Builder setIssueID(String issueID) {

            this.issueID = issueID;
            return this;
        }

        public Builder setIssueRaisedDate(LocalDateTime issueRaisedDate) {

            this.issueRaisedDate = issueRaisedDate;
            return this;
        }

        public Builder setIssueResolvedDate(LocalDateTime issueResolvedDate){

            this.issueResolvedDate = issueResolvedDate;
            return this;
        }

        public Builder setIssueArea(String issueArea) {

            this.issueArea = issueArea;
            return this;
        }

        public  Builder setIssueDescription(String issueDescription) {

            this.issueDescription = issueDescription;
            return this;
        }

        public Builder setIssueStatus(String issueStatus) {

            this.issueStatus = issueStatus;
            return this;
        }

        public Builder setResolved(boolean resolved) {
            isResolved = resolved;
            return this;
        }

        public Builder copy(Issue issue)
        {
            this.issueID = issue.issueID;
            this.issueRaisedDate = issue.issueRaisedDate;
            this.issueArea = issue.issueArea;
            this.issueDescription = issue.issueDescription;
            this.issueStatus = issue.issueStatus;
            return this;
        }
        

        public Issue build(){

            return new Issue(this);
        }



    }
}
