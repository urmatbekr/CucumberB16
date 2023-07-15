package com.mentoring_1;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utils.API_Calls;

import java.util.*;

import static utils.API_Calls.GET;

public class InterviewTask {

    private String expectedCapital = "Bishkek";
    private String actualCapital;

    @Test
    public void validateBreakingBadQuotes() {
        RestAssured.baseURI = "https://api.breakingbadquotes.xyz";
        RestAssured.basePath = "v1/quotes";
        GET("/10").then().log().body().extract().response();
        //Response response = API_Calls.GET("/10");

    }

    @Test
    public void breakingBadQuotes() {
        RestAssured.baseURI = "https://api.breakingbadquotes.xyz";
        RestAssured.basePath = "v1/quotes";
        Response resp = API_Calls.GET("/10");
        List<Map<String, Object>> res = resp.as(new TypeRef<List<Map<String, Object>>>() {
        });

        for (int i = 0; i < res.size(); i++) {
            Map<String, Object> map = res.get(i);
            if (map.get("author").equals("Jesse Pinkman")) {
                System.out.println(map.get("quote"));
            }
        }

    }

    @Test
    public void checkingCapitalName() {
        //RestAssured.baseURI = "";
        //RestAssured.basePath = "";
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("https://restcountries.com/v3.1/all")
                .then().statusCode(200).extract().response();

        List<Map<String, Object>> deseralizationResp = response.as(new TypeRef<List<Map<String, Object>>>() {
        });

        StringBuilder word = new StringBuilder();

        for (int i = 0; i < deseralizationResp.size(); i++) {

            Map<String, Object> outerMap = deseralizationResp.get(i);
            Map<String, Object> innerMap = (Map<String, Object>) outerMap.get("name");


            List<String> capital = new ArrayList<>();

            if (innerMap.get("common").equals("Kyrgyzstan")) {
                capital.add(String.valueOf(outerMap.get("capital")));
                word.append(capital.get(0));
                break;
            }


            Assert.assertEquals(expectedCapital, word);

        }


    }
}
