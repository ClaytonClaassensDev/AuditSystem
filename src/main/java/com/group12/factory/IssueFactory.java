package com.group12.factory;

import com.group12.entity.Issue;
import com.group12.util.GenerateIssueRaisedDate;
import com.group12.util.GenerateID;

import java.time.LocalDateTime;

public class IssueFactory {


    public static Issue createIssue(String issueArea, String issueDescription, String issueStatus){

        String issueId = GenerateID.generateID();
        LocalDateTime issueRaisedDate = GenerateIssueRaisedDate.generateIssueRaisedDate();

        Issue issue = new Issue.Builder()
                .setIssueID(issueId)
                .setIssueRaisedDate(issueRaisedDate)
                .setIssueArea(issueArea)
                .setIssueDescription(issueDescription)
                .setIssueStatus(issueStatus)
                .build();
        return issue;
    }

}
