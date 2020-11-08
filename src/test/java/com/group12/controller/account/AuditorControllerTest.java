package com.group12.controller.account;
/**  Author: Limpho Ranamane
 *   Date: 22-09-2020
 *   Description: Testing Auditor controller
 */
import com.group12.entity.Auditor;
import com.group12.factory.AuditorFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//fixes methods to run in a sequence
@RunWith(SpringRunner.class)
public class AuditorControllerTest {

    @Autowired
    private TestRestTemplate restTemplate; // specifically used to test sping framework controllers

    private  static final String Authenticate_Username ="Boss";
    private static final String Authenticate_Password ="123";

    String baseUrl = "http://localhost:8080/AuditSystem/auditor";

    private static Auditor auditor = AuditorFactory.createAuditor("Kwezi","Mali","0896542317");


    @Test
    public void a_create() {
        String url = baseUrl+"/create";
        ResponseEntity<Auditor> responseEntity = restTemplate.withBasicAuth(Authenticate_Username,Authenticate_Password).postForEntity(url,auditor,Auditor.class);
        System.out.println("Created: " + auditor);
        if (auditor!=responseEntity.getBody()){
            auditor = responseEntity.getBody(); // this is to ensure that the created auditor has the same attributes as the one provided by the response entity.
            }
        assertEquals(auditor,responseEntity.getBody());
        System.out.println("Saved auditor: " + responseEntity.getBody());
    }

    @Test
    public void b_read() {
        String url = baseUrl+"/read/"+auditor.getAuditorID();
        ResponseEntity<Auditor> responseEntity = restTemplate.withBasicAuth(Authenticate_Username,Authenticate_Password).getForEntity(url,Auditor.class);
        assertEquals(auditor.getAuditorID(),responseEntity.getBody().getAuditorID());
        System.out.println("Auditor created: "+auditor.getAuditorID()+"\n"+"Auditor read: " + responseEntity.getBody().getAuditorID());

    }

    @Test
    public void c_update() {
        Auditor updatedAuditor = new Auditor.Builder().copy(auditor).setAuditorSurname("Bali").build();
        String url = baseUrl+"/update";
        HttpEntity<Auditor> auditorHttpEntity = new HttpEntity<>(updatedAuditor,null);
        ResponseEntity<Auditor> responseUpdated = restTemplate.withBasicAuth(Authenticate_Username,Authenticate_Password).exchange(url,HttpMethod.PUT,auditorHttpEntity,Auditor.class);
        assertEquals(updatedAuditor.getAuditorSurname(),responseUpdated.getBody().getAuditorSurname());
        System.out.println("Auditor: "+updatedAuditor.getAuditorID()+"\n"+"Response from update: " + responseUpdated.getBody().getAuditorID());

    }

    @Test
    @Ignore
    public void e_delete() {
        String url = baseUrl+"/delete/"+auditor.getAuditorID();
        System.out.println("Deleting user: " + url);
        restTemplate.withBasicAuth(Authenticate_Username,Authenticate_Password).delete(url);
        assertTrue("Deleted: "+auditor.getAuditorID(),true);
    }

    @Test
    public void d_getAll() {
        String url = baseUrl+"/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> retrievingAll= restTemplate.withBasicAuth(Authenticate_Username,Authenticate_Password).exchange(url, HttpMethod.GET, entity, String.class);
        assertNotNull(retrievingAll);
        System.out.println("Auditor: "+auditor+"\n"+"Auditor on DB: " + retrievingAll.getBody());

    }
}