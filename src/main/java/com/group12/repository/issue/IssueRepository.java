package com.group12.repository.issue;

import com.group12.entity.Issue;
import com.group12.repository.IRepository;

import java.util.Set;

public interface IssueRepository extends IRepository<Issue, String> {

    Set<Issue> getAll();

}
