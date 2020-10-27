package com.group12.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author: Clayton Claassens
 * @desc: entity.Issue Entity --> Builder Pattern
 */
//NOTE!! issueStatus = open when true || issueStatus = false when closed
    @Entity
public class Issue{

    @Id
    private String issueID = null;
    private LocalDateTime issueRaisedDate = null;
    private String issueArea;
    private boolean issueStatus = true;//true = open
    private boolean isResolved = false;
    private boolean isValidated = false;
    private String issueDescription  = null;
    private LocalDateTime issueResolvedDate;//This date should be set once an Issue is resolved.

    public Issue(){

    }

    private Issue(Builder builder){

        this.issueID = builder.issueID;
        this.issueRaisedDate = builder.issueRaisedDate;
        this.issueArea = builder.issueArea;
        this.issueDescription = builder.issueDescription;
        this.isResolved = builder.isResolved;
        this.isValidated = builder.isValidated;
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

    public boolean getIssueStatus() {
        return issueStatus;
    }

    public boolean getIsValidated(){

        return isValidated;
    }

    public boolean getIsResolved(){

        return isResolved;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueID='" + issueID + '\'' +
                ", issueRaisedDate=" + issueRaisedDate +
                ", issueArea='" + issueArea + '\'' +
                ", issueStatus=" + issueStatus +
                ", isResolved=" + isResolved +
                ", isValidated=" + isValidated +
                ", issueDescription='" + issueDescription + '\'' +
                ", issueResolvedDate=" + issueResolvedDate +
                '}';
    }

    public static class Builder {

        private String issueID;
        private LocalDateTime issueRaisedDate;
        private LocalDateTime issueResolvedDate;
        private String issueArea;
        private String issueDescription;
        private boolean issueStatus;
        private boolean isResolved;
        private boolean isValidated;


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

        public Builder setIssueDescription(String issueDescription) {

            this.issueDescription = issueDescription;
            return this;
        }

        public Builder setIssueStatus(boolean issueStatus) {

            this.issueStatus = issueStatus;
            return this;
        }

        public Builder setIsResolved(boolean isResolved){

            this.isResolved = isResolved;
            return this;
        }

        public Builder setIsValidated(boolean isValidated){

            this.isValidated = isValidated;
            return this;
        }


        public Builder copy(Issue issue)
        {
            this.issueID = issue.issueID;
            this.issueRaisedDate = issue.issueRaisedDate;
            this.issueArea = issue.issueArea;
            this.issueDescription = issue.issueDescription;
            this.issueStatus = issue.issueStatus;
            this.isResolved = issue.isResolved;
            this.isValidated = issue.isValidated;
            return this;
        }
        

        public Issue build(){

            return new Issue(this);
        }

    }
}
