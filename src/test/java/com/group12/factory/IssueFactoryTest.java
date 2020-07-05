package com.group12.factory;

import com.group12.entity.Issue;
import org.junit.Assert;
import org.junit.Test;

public class IssueFactoryTest {

    Issue issueDummy1;
    Issue issueDummy2;

    @Test
    public void assertIssueID_IssueRaisedDate_NotNull() {

        issueDummy1 = IssueFactory.createIssue("","","");

        Assert.assertNotNull(issueDummy1.getIssueID());
        Assert.assertNotNull(issueDummy1.getIssueRaisedDate());

    }

    @Test
    public void assertIssueID_Unique(){

        issueDummy1 = IssueFactory.createIssue("Health", "Expired cafeteria food", "HIGH");
        issueDummy2 = IssueFactory.createIssue("Safety","Broken toilet mirrors","HIGH");

        Assert.assertNotEquals(issueDummy1.getIssueID(), issueDummy2.getIssueID());
    }


}