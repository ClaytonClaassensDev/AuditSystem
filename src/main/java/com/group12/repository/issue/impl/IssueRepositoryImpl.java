package com.group12.repository.issue.impl;

import com.group12.entity.Issue;
import com.group12.repository.issue.IssueRepository;

import java.util.HashSet;
import java.util.Set;

//This class is used to override methods of IssueRepository for use of ssue entity.
public class IssueRepositoryImpl implements IssueRepository {

    private static IssueRepository issueRepository = null;

    private Set<Issue> issueDB;

    private IssueRepositoryImpl(){

        this.issueDB = new HashSet<>();
    }

    public static IssueRepository getIssueRepositoryInstance(){

        if(issueRepository == null) issueRepository = new IssueRepositoryImpl();
        return issueRepository;
    }

    //adds Issue record to Repository
    @Override
    public Issue create(Issue issue) {

        this.issueDB.add(issue);
        return issue;
    }


    @Override
    public Issue read(String id) {

        Issue issueToRead = null;

        for(Issue issue: this.issueDB){
            if(issue.getIssueID().contentEquals(id)){

                issueToRead = issue;
            }
        }
        return issueToRead;
    }

    @Override
    public Issue update(Issue issue) {

        Issue dbUpdatedIssue = null;

        for(Issue i: this.issueDB){

            if(i.getIssueID().matches(issue.getIssueID())){

                this.issueDB.remove(i);
                this.issueDB.add(issue);
                dbUpdatedIssue = issue;

            }
        }
        return dbUpdatedIssue;
    }

    @Override
    public boolean delete(String id) {

        boolean isDeleted = false;

        for (Issue issue: this.issueDB){

            if(issue.getIssueID().contentEquals(id)){
                this.issueDB.remove(issue);
                isDeleted = true;
            }else isDeleted = false;
        }
        return isDeleted;
    }

    @Override
    public Set<Issue> getAll() {

        return this.issueDB;
    }


}
