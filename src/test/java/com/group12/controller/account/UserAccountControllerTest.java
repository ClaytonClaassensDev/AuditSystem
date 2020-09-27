package com.group12.controller.account;

/**  Author: Rachael Klein
 *   Student no: 218 057 377
 *   Date: 21-09-2020
 *   Description: Controller Test for UserAccount
 */

import com.group12.entity.UserAccount;
import com.group12.factory.UserAccountFactory;
import com.group12.service.account.UserAccountService;
import com.group12.util.GenerateID;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@RunWith(SpringRunner.class)
public class UserAccountControllerTest {

    static LocalDate date = LocalDate.now();

    //test your rest application through restTemplate
    @Autowired
    private TestRestTemplate restTemplate;

    //need a base URl
    private static String baseURL = "http://localhost:8080/userAccount";


    //This method is a generic method used by some tests used to create a userAccount before running the tests
    private UserAccount CreateUser() throws Exception
    {
        UserAccount userAccount = UserAccountFactory.createUserAccount("rachael@cput.ac.za", "rachael@cput.ac.za", true, date);
        String url = baseURL + "/create";
        ResponseEntity<UserAccount> postResponse = restTemplate.postForEntity(url, userAccount, UserAccount.class);
        return postResponse.getBody();
    }

    @Test
    public void a_create() {
        try {
            UserAccount userAccount = UserAccountFactory.createUserAccount("rachael@cput.ac.za", "rachael@cput.ac.za", true, date);
            String url = baseURL + "/create";
            System.out.println(url);
            ResponseEntity<UserAccount> postResponse = restTemplate.postForEntity(url, userAccount, UserAccount.class);
            assertNotNull(postResponse);
            assertNotNull(postResponse.getBody());
            System.out.println(postResponse.getBody());
        }catch (Exception e)
        {
            fail();
        }
    }

    @Test
    public void b_read() {
        try {
            UserAccount userAccount = CreateUser();
            String url = baseURL + "/read?userId=" +  userAccount.getUserId();
            System.out.println("URL: " + url);

            ResponseEntity<UserAccount> accountResponse = restTemplate.getForEntity(url, UserAccount.class);
            assertEquals(userAccount.getUserId(), accountResponse.getBody().getUserId());
        }catch(Exception e)
        {
            fail();
        }
    }

    @Test
    public void c_update() {
        try{
            UserAccount userAccount = CreateUser();

            UserAccount updated = new UserAccount.Builder().copy(userAccount).setEmail("RachaelJoubert@gmail.com").build();
            String url = baseURL + "/update";
            System.out.println("URL: " + url);
            System.out.println("Put data: " + updated);
            HttpEntity<UserAccount> httpsEntityUserAccount = new HttpEntity<UserAccount>(updated, null);
            ResponseEntity<UserAccount> updateResponse = restTemplate.exchange(url, HttpMethod.PUT, httpsEntityUserAccount, UserAccount.class);
            assertEquals(updateResponse.getStatusCode(), HttpStatus.OK);
            assertEquals(updated.getEmail(), updateResponse.getBody().getEmail());
        }catch (Exception e)
        {
            fail();
        }
    }

    @Test
    public void d_registerUserAccount() {
        String randomEmail = "rachael" + GenerateID.generateID() + "@cput.ac.za";
        String url = baseURL + "/registerUserAccount?email="+randomEmail+"&verifyemail="+randomEmail+"&password=P@ssword123&verifypassword=P@ssword123";
        System.out.println("URL: " + url);
        ResponseEntity<UserAccount> registerResponse = restTemplate.postForEntity(url, null, UserAccount.class);
        assertEquals(randomEmail, registerResponse.getBody().getEmail());
    }

    @Test
    public void e_changePassword() {
        try{
            CreateUser();
            String url = baseURL + "/changePassword?email=rachael@cput.ac.za&existingPassword=rachael@cput.ac.za&newPassword=123P@ssword&verifyNewPassword=123P@ssword";
            System.out.println("URL: " + url);
            ResponseEntity updateResponse = restTemplate.exchange(url, HttpMethod.PUT, null, boolean.class);
            assertEquals(updateResponse.getStatusCode(), HttpStatus.OK);
            assertTrue((boolean)updateResponse.getBody());
        }catch (Exception e)
        {
            fail();
        }
    }

    @Test
    public void f_updateEmailAddress() {
        try{
            CreateUser();
            // the update email address end point takes in multiple param. seperated by a & symbol.
            String url = baseURL + "/updateEmailAddress?email=rachael@cput.ac.za&existingPassword=rachael@cput.ac.za&newEmail=rachaelKlein@cput.ac.za&verifyNewEmail=rachaelKlein@cput.ac.za";
            System.out.println("URL: " + url);
            ResponseEntity updateResponse = restTemplate.exchange(url, HttpMethod.PUT, null, boolean.class);
            assertEquals(updateResponse.getStatusCode(), HttpStatus.OK);
            assertTrue((boolean)updateResponse.getBody());
        }catch (Exception e)
        {
            fail();
        }
    }

    @Test
    public void g_forgotPassword() {
        try {
            UserAccount userAccount = CreateUser();

            String url = baseURL + "/forgotPassword?email=" +  userAccount.getEmail();
            System.out.println("URL: " + url);
            ResponseEntity accountResponse = restTemplate.getForEntity(url, boolean.class);
            assertEquals(HttpStatus.OK, accountResponse.getStatusCode());
            assertEquals(true, accountResponse.getBody());
        }catch(Exception e)
        {
            fail();
        }
    }

    @Test
    public void h_getUserAccountViaEmailAddress() {
        try {
            UserAccount userAccount = CreateUser();

            String url = baseURL + "/getUserAccountViaEmailAddress?email=" +  userAccount.getEmail();
            System.out.println("URL: " + url);
            ResponseEntity<UserAccount> accountResponse = restTemplate.getForEntity(url, UserAccount.class);
            assertEquals(HttpStatus.OK, accountResponse.getStatusCode());
            assertEquals(userAccount.getEmail(), accountResponse.getBody().getEmail());
        }catch(Exception e)
        {
            fail();
        }
    }


    @Test
    public void i_delete() {
        try{
            UserAccount userAccount = CreateUser();
            String url = baseURL + "/delete?userId=" + userAccount.getUserId();
            System.out.println("URL: " + url);
            ResponseEntity updateResponse = restTemplate.exchange(url, HttpMethod.DELETE, null, boolean.class);
            assertEquals(updateResponse.getStatusCode(), HttpStatus.OK);
            assertTrue((boolean)updateResponse.getBody());
        }catch (Exception e)
        {
            fail();
        }
    }


    @Test
    public void j_getAll() {
        String url = baseURL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response= restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }
}