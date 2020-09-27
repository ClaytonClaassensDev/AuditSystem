package com.group12.controller.issue;

import com.group12.entity.Issue;
import com.group12.factory.IssueFactory;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class IssueControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    String url = "http://localhost:8080/issue";

    ResponseEntity<Issue> issue = null;

    @BeforeEach
    void setup(){

        Issue setupIssue = IssueFactory.createIssue("Safety","Broken bathroom mirrors");
        issue = restTemplate.postForEntity(url+"/createIssue", setupIssue,Issue.class);

    }

    @Test
    void d_createIssue() {

        try{

            Issue createIssue = IssueFactory.createIssue("Area Of New Issue","Description of New Issue");
            ResponseEntity<Issue> expectedIssue = restTemplate.postForEntity(url+"/createIssue", createIssue,Issue.class);
            System.out.printf(expectedIssue.getBody()+ "\n");

            String issueArea = expectedIssue.getBody().getIssueArea();
            String issueDescription = expectedIssue.getBody().getIssueDescription();

            if(issueArea != null && issueDescription != null) {

                assertEquals(expectedIssue.getStatusCode(), HttpStatus.OK);
                assertNotNull(expectedIssue);
            }



        }catch(Exception e){

            System.out.printf(e.getMessage());
        }
    }

    @Test
    void b_readIssue() {

        String urlRead = url+"/readIssue?issueID="+issue.getBody().getIssueID();

        ResponseEntity<Issue> responseIssue = restTemplate.getForEntity(urlRead, Issue.class);

        System.out.printf(responseIssue.getBody().toString()+"\n");

        assertNotNull(responseIssue);
        assertEquals(responseIssue.getStatusCode(), HttpStatus.OK);
        assertEquals(issue.getBody().getIssueID(), responseIssue.getBody().getIssueID());

    }

    @Test
    void c_updateIssue() {

        String urlUpdate = url+"/updateIssue";

        Issue issueToUpdate = IssueFactory.createIssue("IssueToUpdateArea","IssueToUpdateDescription");
        ResponseEntity<Issue> updateIssue = restTemplate.postForEntity(url+"/createIssue", issueToUpdate,Issue.class);

        Issue updatedIssue = new Issue.Builder().copy(updateIssue.getBody())
                .setIsResolved(true)
                .build();

        HttpEntity<Issue> issueHttpEntity = new HttpEntity<Issue>(updatedIssue, null);
        restTemplate.exchange(urlUpdate, HttpMethod.PUT, issueHttpEntity, Issue.class);

        ResponseEntity<Issue> updatedIssueResponse = restTemplate.getForEntity(url+"/readIssue?issueID="+issueHttpEntity.getBody().getIssueID(), Issue.class);

        System.out.printf(issueHttpEntity.toString()+"\n");
        System.out.printf(updatedIssue.toString()+"\n");
        System.out.printf(updatedIssueResponse.getBody().toString());

        assertNotNull(updatedIssueResponse);
        assertNotEquals(issueHttpEntity, updatedIssueResponse);
        assertEquals(issueHttpEntity.getBody().getIssueID(), updatedIssueResponse.getBody().getIssueID());

    }

    @Test
    void a_deleteIssue() {

        Issue issueToDelete = IssueFactory.createIssue("IssueToDeleteArea","IssueToDeleteDescription");

        ResponseEntity<Issue> expectedIssue = restTemplate.postForEntity(url+"/createIssue", issueToDelete,Issue.class);

        String issueID = expectedIssue.getBody().getIssueID();

        System.out.printf(expectedIssue.getBody().toString()+"\n");

        String urlDelete = url+"/deleteIssue?issueID="+issueID;

        ResponseEntity<Boolean> isDeleted = restTemplate.exchange(urlDelete, HttpMethod.DELETE,null , boolean.class);

        System.out.printf(isDeleted.getStatusCode()+"\n"+isDeleted.getBody());

        assertTrue(isDeleted.getBody());
        assertEquals(isDeleted.getStatusCode(), HttpStatus.OK);

    }


    @Test
    void f_resolveIssue() {

        String urlResolve = url+"/resolveIssue?issueID="+issue.getBody().getIssueID();

        ResponseEntity<Issue> issueResponseEntity = restTemplate.getForEntity(urlResolve, Issue.class);

        assertEquals(issueResponseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(issue.getBody().getIssueID(), issueResponseEntity.getBody().getIssueID());
        assertEquals(true, issueResponseEntity.getBody().getIsResolved());

    }

    @Test
    void g_validateIssue() {

        Issue issueToValidate = IssueFactory.createIssue("IssueToValidateArea","IssueToValidateDescription");

        ResponseEntity<Issue> expectedIssue = restTemplate.postForEntity(url+"/createIssue", issueToValidate,Issue.class);

        ResponseEntity<Issue> resolvedIssue = restTemplate.getForEntity(url+"/resolveIssue?issueID="+expectedIssue.getBody().getIssueID(), Issue.class);

        System.out.printf("resolved: "+resolvedIssue.getBody().toString());

        ResponseEntity<Issue> updatedIssue = restTemplate.getForEntity(url+"/readIssue?issueID="+resolvedIssue.getBody().getIssueID(), Issue.class);

        System.out.printf(updatedIssue.getBody().toString()+"\n");

        String urlValidate = url+"/validateIssue?issueID="+updatedIssue.getBody().getIssueID();

        restTemplate.getForEntity(urlValidate, Issue.class);

        ResponseEntity<Issue> validatedIssue = restTemplate.getForEntity(url+"/readIssue?issueID="+updatedIssue.getBody().getIssueID(), Issue.class);

        System.out.printf("Validated: "+validatedIssue.getBody().toString()+"\n");

        assertEquals(validatedIssue.getStatusCode(), HttpStatus.OK);
        assertEquals(validatedIssue.getBody().getIssueID(), expectedIssue.getBody().getIssueID());
        assertEquals(true, validatedIssue.getBody().getIsValidated());

    }

    @Test
    void e_openIssue() {

        Issue issueToOpen = IssueFactory.createIssue("IssueToOpenArea","IssueToOpenDescription");

        ResponseEntity<Issue> expectedIssue = restTemplate.postForEntity(url+"/createIssue", issueToOpen,Issue.class);


        Issue expIssue = new Issue.Builder().copy(expectedIssue.getBody())
                .setIssueStatus(false)
                .build();

        System.out.printf(expectedIssue.getBody().getIssueID()+"\n");

        HttpEntity<Issue> issueHttpEntity = new HttpEntity<>(expIssue);

        String urlUpdate = url+"/updateIssue?issueID="+issueHttpEntity.getBody().getIssueID();

        restTemplate.exchange(urlUpdate, HttpMethod.PUT, issueHttpEntity, Issue.class);

        ResponseEntity<Issue> updatedIssueResponse = restTemplate.getForEntity(url+"/readIssue?issueID="+issueHttpEntity.getBody().getIssueID(), Issue.class);


        System.out.printf(issueHttpEntity.getBody().toString()+"\n");
        System.out.printf(updatedIssueResponse.getBody().toString()+"\n");

        String urlOpenIssue = url+"/openIssue?issueID="+updatedIssueResponse.getBody().getIssueID();

        restTemplate.getForEntity(urlOpenIssue, Issue.class);

        ResponseEntity<Issue> issueResponseEntity = restTemplate.getForEntity(url+"/readIssue?issueID="+updatedIssueResponse.getBody().getIssueID(), Issue.class);


        System.out.printf(issueResponseEntity.getBody().toString()+"\n");

        assertEquals(issueResponseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(expectedIssue.getBody().getIssueID(), issueResponseEntity.getBody().getIssueID());
        assertEquals(true, issueResponseEntity.getBody().getIssueStatus());


    }

    @Test
    void h_closeIssue() {

        Issue issueToClose = IssueFactory.createIssue("IssueToCloseArea","IssueToCloseDescription");

        ResponseEntity<Issue> expectedIssue = restTemplate.postForEntity(url+"/createIssue", issueToClose,Issue.class);

        Issue expIssue = new Issue.Builder().copy(expectedIssue.getBody())
                .setIsResolved(true)
                .setIsValidated(true)
                .build();

        HttpEntity<Issue> issueHttpEntity= new HttpEntity<>(expIssue);

        String urlUpdate = url+"/updateIssue";

        restTemplate.exchange(urlUpdate, HttpMethod.PUT, issueHttpEntity, Issue.class);

        ResponseEntity<Issue> updatedIssueResponse = restTemplate.getForEntity(url+"/readIssue?issueID="+issueHttpEntity.getBody().getIssueID(), Issue.class);

        System.out.printf(issueHttpEntity.getBody().toString()+"\n");
        System.out.printf(updatedIssueResponse.getBody().toString()+"\n");

        String urlCloseIssue = url+"/closeIssue?issueID="+updatedIssueResponse.getBody().getIssueID();

        restTemplate.getForEntity(urlCloseIssue, Issue.class);

        ResponseEntity<Issue> issueResponseEntity = restTemplate.getForEntity(url+"/readIssue?issueID="+updatedIssueResponse.getBody().getIssueID(), Issue.class);


        System.out.println(issueResponseEntity.getBody().getIssueStatus()+"\n");

        assertEquals(issueResponseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(issueHttpEntity.getBody().getIssueID(), issueResponseEntity.getBody().getIssueID());
        assertEquals(false, issueResponseEntity.getBody().getIssueStatus());


    }

    @Test
    void i_getAllIssues() {

        String urlGetAllIssues = url+"/getAllIssues";

        ResponseEntity<Set> setResponseEntity = restTemplate.getForEntity(urlGetAllIssues, Set.class);

        System.out.printf(setResponseEntity.getBody().size()+"");

        assertEquals(setResponseEntity.getStatusCode(), HttpStatus.OK);
        assertNotNull(setResponseEntity);


    }
}