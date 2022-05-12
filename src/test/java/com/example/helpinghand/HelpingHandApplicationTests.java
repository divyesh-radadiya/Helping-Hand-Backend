package com.example.helpinghand;

import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

@EnableWebMvc
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HelpingHandApplicationTests extends AbstractTest{

    @Autowired
    WebApplicationContext webApplicationContext;
    protected MockMvc mvc;
    @BeforeEach
    protected void setUp() throws Exception {
        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Order(1)
    void contextLoads() {
        System.out.println("Get All Manager Data : Success");

    }

    @Test
    @Order(2)
    void  getNgoTest() throws Exception
    {
        String  uri = "/ngo/getNgo/dradadiya990@gmail.com";
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        try {
            assertEquals( 200, status);
            System.out.println("Get All Ngo Data : Success");
        }catch(Exception e) {
            System.out.println("Get All Ngo Data : Fail");
        }
    }

    @Test
    @Order(3)
    void  requestTest() throws Exception
    {
        String req="";
        try {
            File file = new File("src/test/java/com/example/helpinghand/req.json");
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(file));

        req = obj.toString();
        } catch (IOException | ParseException e) {
            System.out.println(e);
        }
        String  uri = "/request/add";
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(req)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();

        String content = mvcResult.getResponse().getContentAsString();
        try {
            assertEquals( 200, status);
            System.out.println("Register request : Success");
        }catch(Exception e) {
            System.out.println("Register request : Fail");
        }

        uri = "/request/setStatus/1";
        mvcResult = this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        status = mvcResult.getResponse().getStatus();
        try {
            assertEquals( 200, status);
            System.out.println("Set request : Success");
        }catch(Exception e) {
            System.out.println("Ser request : Fail");
        }

        uri = "/request/unsetStatus/1";
        mvcResult = this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        status = mvcResult.getResponse().getStatus();
        try {
            assertEquals( 200, status);
            System.out.println("Unset request : Success");
        }catch(Exception e) {
            System.out.println("Unset request : Fail");
        }

        uri = "/request/getRequests/9999999999";
        mvcResult = this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        status = mvcResult.getResponse().getStatus();
        try {
            assertEquals( 200, status);
            System.out.println("Get request : Success");
        }catch(Exception e) {
            System.out.println("Get request : Fail");
        }

    }

    @Test
    @Order(4)
    void  donorTest() throws Exception
    {
        String req="";
        try {
            File file = new File("src/test/java/com/example/helpinghand/donor.json");
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(file));

            req = obj.toString();
        } catch (IOException | ParseException e) {
            System.out.println(e);
        }
        String  uri = "/donor/add";
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(req)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();

        String content = mvcResult.getResponse().getContentAsString();
        try {
            assertEquals( 200, status);
            System.out.println("Register donor : Success");
        }catch(Exception e) {
            System.out.println("Register donor : Fail");
        }


    }

}
