package com.group12.controller.faculty;

import com.group12.entity.Faculty;
import com.group12.factory.FacultyFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacultyControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/faculty/";

    // Instances to test with
    private static Faculty engineering = null;
    private static Faculty accounting = null;
    private static Faculty acting = null;


    @Test
    public void a_create() {
        System.out.println("\nCREATE");

        String url = baseURL + "create";

        try {
            engineering = FacultyFactory.createFaculty("Engineering");
            accounting = FacultyFactory.createFaculty("Accounting");
            acting = FacultyFactory.createFaculty("Acting");

            ResponseEntity<String> engPostRes = restTemplate.postForEntity(url, engineering, String.class);
            ResponseEntity<String> accPostRes = restTemplate.postForEntity(url, accounting, String.class);
            ResponseEntity<String> actPostRes = restTemplate.postForEntity(url, acting, String.class);

            System.out.println(engPostRes.getBody());
            System.out.println(accPostRes.getBody());
            System.out.println(actPostRes.getBody());
            System.out.println("");
        }
        catch (Exception e) {
            Assert.fail();
        }

    }


    @Test
    public void c_getAllStartingWith() {
        System.out.println("GET ALL STARTING WITH");
        String url = baseURL + "getAllStartWith/ac";
        ResponseEntity<String> getRes = restTemplate.getForEntity(url, String.class);

        System.out.println(getRes.getBody());
        System.out.println("");
    }

    @Test
    public void d_getByName() {
        System.out.println("GET BY NAME");
        String name = acting.getFacultyName();
        String url = baseURL + "getByName/" + name;

        ResponseEntity<String> getRes = restTemplate.getForEntity(url, String.class);

        System.out.println(getRes.getBody());
        System.out.println("");
    }

    @Test
    public void e_getById() {
        System.out.println("GET BY ID");
        String id = acting.getFacultyId();
        String url = baseURL + "getById/" + id;

        ResponseEntity<String> getRes = restTemplate.getForEntity(url, String.class);

        System.out.println(getRes.getBody());
        System.out.println("");
    }

    @Test
    public void f_update() {
        System.out.println("UPDATE");
        String url = baseURL + "update";

        Faculty newAccounting = new Faculty
                .Builder()
                .copy(accounting)
                .setFacultyName("Financial Accounting")
                .build();

        HttpEntity<Faculty> request = new HttpEntity<>(newAccounting);
        ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.PUT, request, String.class);

        System.out.println(res.getBody());
        System.out.println("");
    }

    @Test
    public void g_delete() {
        System.out.println("DELETE");
        String id = acting.getFacultyId();
        String url = baseURL + "delete/" + id;

        //ResponseEntity<String> getRes = restTemplate.delete(url);

        //System.out.println(getRes.getBody());
        System.out.println("");

    }


    @Test
    public void h_getAll() {
        System.out.println("GET ALL");
        String url = baseURL + "getAll";

        ResponseEntity<String> getRes = restTemplate.getForEntity(url, String.class);

        System.out.println(getRes.getBody());
        System.out.println("");
    }



}