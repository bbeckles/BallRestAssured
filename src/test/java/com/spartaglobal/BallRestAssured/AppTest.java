package com.spartaglobal.BallRestAssured;

import static org.junit.Assert.assertTrue;

import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class AppTest 
{

    private static Response teamResponse;
    @BeforeClass

    public static void setup() {
        baseURI = "https://www.balldontlie.io/api/v1";
        basePath = "/teams";
        teamResponse = get();
    }

    @Test
    public void shouldAnswerWithTrue()
    {

        teamResponse
                .then()
                .statusCode(200)
                .body("data[0].id", equalTo(1));
    }

    @Test
    public void secondTest(){
        teamResponse
                .then()
                .body("data[0].name", equalTo("Hawks"));
    }

    @Test
    public void thirdTest(){
        System.out.println(teamResponse
                .getTime());
    }
}
