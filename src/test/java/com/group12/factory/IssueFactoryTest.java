package com.group12.factory;

import com.group12.entity.Issue;
import org.junit.Assert;
import org.junit.Test;

public class IssueFactoryTest {

    @Test
    public void testCreateIssue() {

        Issue issue = IssueFactory.createIssue("Safety","Broken mirrors in the toilet","MEDIUM");

    }


}