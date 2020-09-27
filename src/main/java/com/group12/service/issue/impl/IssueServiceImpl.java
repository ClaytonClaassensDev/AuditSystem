package com.group12.service.issue.impl;

import com.group12.entity.Issue;
import com.group12.repository.issue.IssueRepository;
import com.group12.repository.issue.impl.IssueRepositoryImpl;
import com.group12.service.issue.IssueService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class IssueServiceImpl implements IssueService {

    private static IssueService issueService = null;
    private IssueRepository issueRepository;

    private IssueServiceImpl(){

        this.issueRepository = IssueRepositoryImpl.getIssueRepositoryInstance();
    }

    public static IssueService getInstance(){

        if(issueService == null){

            issueService = new IssueServiceImpl();
        }
        return issueService;
    }

    @Override
    public Set<Issue> getAll() {

        return this.issueRepository.getAll();
    }

    //issueStatus true=open
    @Override
    public Issue resolveIssue(String issueID) {

        Issue resolvedIssue = null;
        try {


            Issue issue = this.issueRepository.read(issueID);

            if (issueID != null) {

                resolvedIssue = new Issue.Builder().copy(issue)
                        .setIsResolved(true)
                        .setIssueResolvedDate(LocalDateTime.now())
                        .build();

                this.issueRepository.update(resolvedIssue);
            }


        }catch (Exception e){

            System.out.print(e.getCause());
        }

        return resolvedIssue;
    }

    @Override
    public Issue validateIssue(String issueID) {

        Issue validatedIssue = null;

        try {
            Issue issue = this.issueRepository.read(issueID);

            if (issueID != null) {

                validatedIssue = new Issue.Builder().copy(issue)

                        .setIsValidated(true)
                        .build();

                this.issueRepository.update(validatedIssue);
            }

        }catch (Exception e){

            System.out.printf(e.getMessage());
        }
        return validatedIssue;
    }

    @Override
    public Issue openIssue(String issueID) {

        Issue openedIssue = null;
        Issue issue = this.issueRepository.read(issueID);

        if( issue != null && issue.getIssueStatus() == false){

            openedIssue = new Issue.Builder().copy(issue)
                    .setIssueStatus(true)
                    .build();

            this.issueRepository.update(openedIssue);
        }

        return openedIssue;
    }

    @Override
    public Issue closeIssue(String issueID) {

        Issue closedIssue = null;
        Issue issue = this.issueRepository.read(issueID);

        if(issue.getIssueStatus() == true && issue.getIsValidated() == true){

            closedIssue = new Issue.Builder().copy(issue)
                    .setIssueStatus(false)
                    .build();

            this.issueRepository.update(closedIssue);
        }

        return closedIssue;
    }

    @Override
    public Issue create(Issue t) {
        return this.issueRepository.create(t);
    }

    @Override
    public Issue read(String id) {
        return this.issueRepository.read(id);
    }

    @Override
    public Issue update(Issue t) {
        return this.issueRepository.update(t);
    }

    @Override
    public boolean delete(String id) {
        return this.issueRepository.delete(id);
    }
}
