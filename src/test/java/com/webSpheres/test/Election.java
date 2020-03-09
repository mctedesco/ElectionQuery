package com.webSpheres.test;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class Election {

    /**
     * AUT_001 Test Case 1 - Verify election query endpoint request returns positive result 200 status with API Key checkbox checked
     */
    @Test
    public void validateElectionQuerywithAPIKey(){
        given().
                param("key", "AIzaSyCTMXDhAkBJBNEcAINED-LFYuTECeEw4GI").
                when().
                get("https://www.googleapis.com/civicinfo/v2/elections").
                then().
                statusCode(200).log().all();
    }

    /**
     * AUT_002 Test Case 2 - Verify election query endpoint request returns negative result 403 status with API Key checkbox unchecked
     */
    @Test
    public void validateElectionQuerywithoutAPIKey(){
        given().
                get("https://www.googleapis.com/civicinfo/v2/elections").
                then().
                statusCode(403).log().all();
    }


    /**
     * AUT_003 Test Case 3 - Verify election query endpoint request returns positive result 200 status when Show Parameters Alt selected
     */
    @Test
    public void validateElectionQuerywithAltSelected(){
        given().
                param("alt", "json").
                param("key", "AIzaSyCTMXDhAkBJBNEcAINED-LFYuTECeEw4GI").
                when().
                get("https://www.googleapis.com/civicinfo/v2/elections").
                then()
                .statusCode(200).log().all();
    }

    /**
     * AUT_004 Test Case 4 - Verify election query endpoint request returns positive result 200 status when Show Parameters fields selected with string value
     */
    @Test
    public void validateElectionQuerywithFieldSelected(){
        given().
                param("fields", "kind").
                param("key", "AIzaSyCTMXDhAkBJBNEcAINED-LFYuTECeEw4GI").
                when().
                get("https://www.googleapis.com/civicinfo/v2/elections").
                then().
                statusCode(200).log().all().
                body("kind", is("civicinfo#electionsQueryResponse"));

    }

    /**
     * AUT_005 Test Case 5 - Verify election query endpoint request returns negative result 400 status when Show Parameters fields selected with erroneous string value
     */
    @Test
    public void validateElectionQuerywithErrorFieldSelected(){
        given().
                param("fields", "kindsss").
                param("key", "AIzaSyCTMXDhAkBJBNEcAINED-LFYuTECeEw4GI").
                when().
                get("https://www.googleapis.com/civicinfo/v2/elections").
                then().
                statusCode(400).log().all();

    }

    /**
     * AUT_006 Test Case 6 - Verify election query endpoint request returns positive result 200 status when ALL Show Parameters fields selected with string value
     */
    @Test
    public void validateElectionQuerywithAllFieldSelected(){
        given().
                param("fields", "kind,elections(id,name,electionDay,ocdDivisionId)").
                param("key", "AIzaSyCTMXDhAkBJBNEcAINED-LFYuTECeEw4GI").
                when().
                get("https://www.googleapis.com/civicinfo/v2/elections").
                then().
                statusCode(200).log().all();

    }
}
