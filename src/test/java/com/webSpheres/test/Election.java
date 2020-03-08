package com.webSpheres.test;

import com.webSpheres.test.common.Endpoint;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;


public class Election {

    @Test
    //AUT_001 Test Case 1 - Verify election query endpoint request returns positive result 200 status with API Key checkbox checked
    public void validateElectionQuerywithAPIKey(){
        given().get("https://www.googleapis.com/civicinfo/v2/elections?key=AIzaSyCTMXDhAkBJBNEcAINED-LFYuTECeEw4GI").then()
.statusCode(200).log().all();
    }

    @Test
    //AUT_002 Test Case 2 - Verify election query endpoint request returns negative result 403 status with API Key checkbox unchecked
    public void validateElectionQuerywithoutAPIKey(){
        given().get("https://www.googleapis.com/civicinfo/v2/elections").then()
                .statusCode(403).log().all();
    }

    @Test
    //AUT_003 Test Case 3 - Verify election query endpoint request returns positive result 200 status when Show Parameters Alt selected
    public void validateElectionQuerywithAltSelected(){
        given().
                get("https://www.googleapis.com/civicinfo/v2/elections?alt=json&key=AIzaSyCTMXDhAkBJBNEcAINED-LFYuTECeEw4GI").
                then()
                .statusCode(200).log().all();
    }

    @Test
    //AUT_004 Test Case 4 - Verify election query endpoint request returns positive result 200 status when Show Parameters fields selected with string value
    public void validateElectionQuerywithFieldSelected(){
        given().
                get("https://www.googleapis.com/civicinfo/v2/elections?fields=kind&key=AIzaSyCTMXDhAkBJBNEcAINED-LFYuTECeEw4GI").
                then().
                statusCode(200).log().all().
                body("kind", is("civicinfo#electionsQueryResponse"));

    }

    @Test
    //AUT_005 Test Case 5 - Verify election query endpoint request returns negative result 400 status when Show Parameters fields selected with erroneous string value
    public void validateElectionQuerywithErrorFieldSelected(){
        given().
                get("https://www.googleapis.com/civicinfo/v2/elections?fields=kindsss&key=AIzaSyCTMXDhAkBJBNEcAINED-LFYuTECeEw4GI").
                then().
                statusCode(400).log().all();

    }

}
