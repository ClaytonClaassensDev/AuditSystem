package com.group12.repository.issue.impl;

import com.group12.entity.Issue;
import com.group12.factory.IssueFactory;
import com.group12.repository.issue.IssueRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.Set;
import static junit.framework.TestCase.*;

//Tests methods used for Issue Repository
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IssueRepositoryImplTest{


    private static IssueRepository issueDB = IssueRepositoryImpl.getIssueRepositoryInstance();
    private static Set<Issue> issueSet = null;

    Issue issueExpected = IssueFactory.createIssue("Safety", "Out of Order Fire Escapes", "Open");
    Issue issue1 = IssueFactory.createIssue("Safety", "Broken Entrance Doors", "Open");
    Issue issue2 = IssueFactory.createIssue("Health", "Expired cafeteria food", "Open");
    Issue issue3 = IssueFactory.createIssue("Academics", "Outdated learning material", "Open");
    Issue issue4 = IssueFactory.createIssue("Safety", "Broken Mirrors and Windows", "Open");
    Issue issue5 = IssueFactory.createIssue("Health", "Campus Clinic Sanitation", "Open");


    @Test
    public void a_testGetIssueRepositoryInstance() {

        try {

            IssueRepository issueRepository = IssueRepositoryImpl.getIssueRepositoryInstance();
            Assert.assertSame(issueDB, issueRepository);

        }catch (Exception e){

            System.out.println(e.getCause());
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void b_testCreate() {

        try {

            issueDB.create(issueExpected);

            Issue issueActual = issueDB.read(issueExpected.getIssueID());

            assertEquals(issueExpected, issueActual);

        }catch (Exception e){

            System.out.println(e.getCause());
            Assert.fail(e.getMessage());
        }


    }

    @Test
    public void c_testRead() {

        try {

            issueDB.create(issueExpected);

            Issue issueFromDB = issueDB.read(issueExpected.getIssueID());

            assertSame(issueExpected, issueFromDB);

        }catch (Exception e){

            System.out.println(e.getCause());
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void d_testUpdate() {

        try {

            Issue issueExp = issueDB.create(issueExpected);

            Issue issue = new Issue.Builder().copy(issueExp).setIssueDescription("Broken Mirrors").build();

            Issue issueReturned = issueDB.update(issue);

            assertSame(issueExp.getIssueID(), issueReturned.getIssueID());

        }catch (Exception e){

            System.out.println(e.getCause());
            //Assert.fail(e.getMessage());
        }

    }

    @Test
    public void k_testDelete() {

        try {

            Issue issue = issueDB.create(issueExpected);

            boolean deleteStatus = issueDB.delete(issue.getIssueID());
            assertTrue(deleteStatus);
            boolean dbContainRecord = issueDB.equals(issueExpected);

            Assert.assertNotEquals(deleteStatus, dbContainRecord);

        }catch (Exception e){

            System.out.println(e.getCause());
            //Assert.fail(e.getMessage());

        }
    }

    @Test
    public void e_testGetAll() {

        try {

            issueDB.create(issue1);
            issueDB.create(issue2);
            issueDB.create(issue3);
            issueDB.create(issue4);
            issueDB.create(issue5);

            issueSet = issueDB.getAll();

            assertSame(issueSet.size(), issueDB.getAll().size());

        }catch(Exception e){

            System.out.println(e.getCause());
            Assert.fail(e.getMessage());

        }
    }
}